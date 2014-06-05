/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.sdnimanager.northbound;


import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import org.codehaus.enunciate.jaxrs.ResponseCode;
import org.codehaus.enunciate.jaxrs.StatusCodes;
import org.opendaylight.controller.containermanager.IContainerManager;
import org.opendaylight.controller.hosttracker.IfIptoHost;
import org.opendaylight.controller.northbound.commons.RestMessages;
import org.opendaylight.controller.northbound.commons.exception.InternalServerErrorException;
import org.opendaylight.controller.northbound.commons.exception.ResourceNotFoundException;
import org.opendaylight.controller.northbound.commons.exception.ServiceUnavailableException;
import org.opendaylight.controller.northbound.commons.exception.UnauthorizedException;
import org.opendaylight.controller.northbound.commons.utils.NorthboundUtils;
import org.opendaylight.controller.sal.authorization.Privilege;
import org.opendaylight.controller.sal.utils.GlobalConstants;
import org.opendaylight.controller.sal.utils.ServiceHelper;
import org.opendaylight.controller.sdni.NetworkCapabilities;
import org.opendaylight.controller.sdni.SdniManager;
import org.opendaylight.controller.switchmanager.ISwitchManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * The class provides Northbound SDNi REST APIs to access the nodes, node connectors
 * and their properties.
 *
 */

@Path("/")
public class SdniNorthbound {

    private String username;
    private static final Logger logger = LoggerFactory.getLogger(SdniNorthbound.class);
   
    @Context
    public void setSecurityContext(SecurityContext context) {
        if (context != null && context.getUserPrincipal() != null) {
            username = context.getUserPrincipal().getName();
        }
    }

    protected String getUserName() {
        return username;
    }

    /**
     * Establish Container and Switch manager connection.
     * @param containerName
     * @return
     */
    private ISwitchManager getIfSwitchManagerService(String containerName) {
    	
        IContainerManager containerManager = (IContainerManager) ServiceHelper.getGlobalInstance(IContainerManager.class, this);
        
        if (containerManager == null) {
            throw new ServiceUnavailableException("Container " + RestMessages.SERVICEUNAVAILABLE.toString());
        }

        boolean found = false;
        List<String> containerNames = containerManager.getContainerNames();
        for (String cName : containerNames) {
            if (cName.trim().equalsIgnoreCase(containerName.trim())) {
                found = true;
                break;
            }
        }

        if (found == false) {
            throw new ResourceNotFoundException(containerName + " " + RestMessages.NOCONTAINER.toString());
        }

        ISwitchManager switchManager = (ISwitchManager) ServiceHelper.getInstance(ISwitchManager.class, containerName,this);

        if (switchManager == null) {
            throw new ServiceUnavailableException("Switch Manager " + RestMessages.SERVICEUNAVAILABLE.toString());
        }

        return switchManager;
    }
    
    /**
     * Check for a valid container
     * 
     * @param containerName
     * @return
     */
    private boolean isValidContainer(String containerName) {
        if (containerName.equals(GlobalConstants.DEFAULT.toString())) {
            return true;
        }
        IContainerManager containerManager = (IContainerManager) ServiceHelper.getGlobalInstance(IContainerManager.class, this);
        
        if (containerManager == null) {
            throw new InternalServerErrorException(RestMessages.INTERNALERROR.toString());
        }
        if (containerManager.getContainerNames().contains(containerName)) {
            return true;
        }
        return false;
    }

    
    /**
     * Retrieve the Network Capabilities information like links, bandwidth, node etc., 
     * 
     * @param containerName
     * @return Return Links, Bandwidth, Latency, Node and its mac address, hosts and its IP address
     * 
     * Example:
     * 
     * Request URL: 
     * http://localhost:8080/controller/nb/v2/sdni/default/topology
     * 
     * Response Body in XML:
     * {"link":["(OF|2@OF|00:00:00:00:00:00:00:01->OF|3@OF|00:00:00:00:00:00:00:03)",
     * "(OF|3@OF|00:00:00:00:00:00:00:03->OF|2@OF|00:00:00:00:00:00:00:01)",
     * "(OF|1@OF|00:00:00:00:00:00:00:01->OF|3@OF|00:00:00:00:00:00:00:02)",
     * "(OF|3@OF|00:00:00:00:00:00:00:02->OF|1@OF|00:00:00:00:00:00:00:01)"],
     * "bandwidth":["10Gbps","10Gbps","10Gbps","10Gbps"],"latency":[],
     * "macAddressList":["00:00:00:00:00:01","00:00:00:00:00:02","00:00:00:00:00:03"],
     * "ipAddressList":["10.0.0.1","10.0.0.3"],"controller":["10.132.35.14"],
     * "node":["00:00:00:00:00:00:00:01","00:00:00:00:00:00:00:02",
     * "00:00:00:00:00:00:00:03"],"host":["1","1"]}
     * 
     */
    @Path("/{containerName}/topology")
    @GET
    @Produces({ MediaType.APPLICATION_JSON})
    @StatusCodes({ @ResponseCode(code = 404, condition = "The Container Name was not found") })
  	public NetworkCapabilities getTopologyDetails(
            @PathParam("containerName") String containerName) {
    	
    	logger.debug("inside getTopologyDetails of sdni northbound");
    	if (!isValidContainer(containerName)) {
            throw new ResourceNotFoundException("Container " + containerName + " does not exist.");
        }
        if (!NorthboundUtils.isAuthorized(getUserName(), containerName, Privilege.WRITE, this)) {
            throw new UnauthorizedException("User is not authorized to perform this operation on container "+ containerName);
        }
        ISwitchManager switchManager = getIfSwitchManagerService(containerName);
        if (switchManager == null) {
            throw new ServiceUnavailableException("Switch Manager " + RestMessages.SERVICEUNAVAILABLE.toString());
        }
        IfIptoHost hostTracker = (IfIptoHost) ServiceHelper.getInstance(IfIptoHost.class, containerName, this);
        if (hostTracker == null) {
            throw new ServiceUnavailableException("Host Tracker " + RestMessages.SERVICEUNAVAILABLE.toString());
        }
    	NetworkCapabilities nwCapabilities = new NetworkCapabilities();
    	SdniManager sdnimanager = new SdniManager();
    	nwCapabilities = (NetworkCapabilities)sdnimanager.getTopologyDetails(containerName);
    	return nwCapabilities;
    }
}
