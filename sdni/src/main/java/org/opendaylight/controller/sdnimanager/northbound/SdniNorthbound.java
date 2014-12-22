/*
 * Copyright (c) 2014 TATA Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.sdnimanager.northbound;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.core.UriInfo;

import org.codehaus.enunciate.jaxrs.ResponseCode;
import org.codehaus.enunciate.jaxrs.StatusCodes;
import org.codehaus.enunciate.jaxrs.TypeHint;
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
import org.opendaylight.controller.sal.utils.Status;
import org.opendaylight.controller.sdniaggregator.NetworkCapabilities;
import org.opendaylight.controller.sdniaggregator.SdniManager;
import org.opendaylight.controller.switchmanager.ISwitchManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * This class SDNi REST APIs is used to retrieve SDNi Network Capabilities Data.
 * And also Update the available bandwidth based on the parameters Its queries
 * SDNiAggregator to fetch/modify the data. Totally 3 API calls - Network
 * Capabilities Data, Update
 */

@Path("/")
public class SdniNorthbound {

    private String username;
    private static final Logger LOGGER = LoggerFactory
            .getLogger(SdniNorthbound.class);
    private SdniManager sdnimanager = new SdniManager();
    private NetworkCapabilities nc = new NetworkCapabilities();
    private static final int OPERATION_SUCCESSFUL = 201;
    private static final int INVALID_CONFIGURATION = 400;
    private static final int USER_NOT_AUTHORIZED = 401;
    private static final int CONTAINER_NOT_FOUND = 404;
    private static final int NON_DEFAULT_CONTAINER = 406;
    private static final int CLUSTER_CONFLICT = 409;
    private static final int SERVICES_UNAVAILABLE = 503;
    private static final String CONTAINER = "Container ";
    private static final String NOT_AUTHORIZED_MESSAGE = "User is not authorized to perform this operation on container ";

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
     * @return ISwitchManager
     */
    private ISwitchManager getIfSwitchManagerService(String containerName) {
        IContainerManager containerManager = (IContainerManager) ServiceHelper
                .getGlobalInstance(IContainerManager.class, this);

        if (containerManager == null) {
            throw new ServiceUnavailableException(CONTAINER
                    + RestMessages.SERVICEUNAVAILABLE.toString());
        }

        boolean found = false;
        List<String> containerNames = containerManager.getContainerNames();
        for (String cName : containerNames) {
            if (cName.trim().equalsIgnoreCase(containerName.trim())) {
                found = true;
                break;
            }
        }

        if (!found) {
            throw new ResourceNotFoundException(containerName + " "
                    + RestMessages.NOCONTAINER.toString());
        }

        ISwitchManager switchManager = (ISwitchManager) ServiceHelper
                .getInstance(ISwitchManager.class, containerName, this);

        if (switchManager == null) {
            throw new ServiceUnavailableException("Switch Manager "
                    + RestMessages.SERVICEUNAVAILABLE.toString());
        }

        return switchManager;
    }

    /**
     * Check for a valid container
     * @param containerName
     * @return boolean
     */
    private boolean isValidContainer(String containerName) {
        if (containerName.equals(GlobalConstants.DEFAULT.toString())) {
            return true;
        }
        IContainerManager containerManager = (IContainerManager) ServiceHelper
                .getGlobalInstance(IContainerManager.class, this);

        if (containerManager == null) {
            throw new InternalServerErrorException(
                    RestMessages.INTERNALERROR.toString());
        }
        if (containerManager.getContainerNames().contains(containerName)) {
            return true;
        }
        return false;
    }

    /**
     * Retrieve the Network Capabilities Data like links, bandwidth, node etc.,
     * from SDNiAggregator
     * @param containerName
     * @return NetworkCapabilities Example: Request URL:
     *         http://localhost:8080/controller/nb/v2/sdni/default/topology
     *         Response Body in XML: {"link":[
     *         "(OF|2@OF|00:00:00:00:00:00:00:01->OF|3@OF|00:00:00:00:00:00:00:03)"
     *         ,
     *         "(OF|3@OF|00:00:00:00:00:00:00:03->OF|2@OF|00:00:00:00:00:00:00:01)"
     *         ,
     *         "(OF|1@OF|00:00:00:00:00:00:00:01->OF|3@OF|00:00:00:00:00:00:00:02)"
     *         ,
     *         "(OF|3@OF|00:00:00:00:00:00:00:02->OF|1@OF|00:00:00:00:00:00:00:01)"
     *         ],
     *         "bandwidth":["10Gbps","10Gbps","10Gbps","10Gbps"],"latency":[],
     *         "macAddressList"
     *         :["00:00:00:00:00:01","00:00:00:00:00:02","00:00:00:00:00:03"],
     *         "ipAddressList"
     *         :["10.0.0.1","10.0.0.3"],"controller":["10.132.35.14"],
     *         "node":["00:00:00:00:00:00:00:01","00:00:00:00:00:00:00:02",
     *         "00:00:00:00:00:00:00:03"],"host":["1","1"]}
     */
    @Path("/{containerName}/topology")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @StatusCodes({ @ResponseCode(code = CONTAINER_NOT_FOUND, condition = "The Container Name was not found") })
    public NetworkCapabilities getTopologyDetails(
            @PathParam("containerName") String containerName) {

        LOGGER.debug("inside getTopologyDetails of sdni northbound");
     	LOGGER.info("inside getTopologyDetails of sdni northbound");
	if (!isValidContainer(containerName)) {
            throw new ResourceNotFoundException(CONTAINER + containerName
                    + " does not exist.");
        }
        if (!NorthboundUtils.isAuthorized(getUserName(), containerName,
                Privilege.WRITE, this)) {
	    LOGGER.info("not authorized");
            throw new UnauthorizedException(NOT_AUTHORIZED_MESSAGE + containerName);
        }
        ISwitchManager switchManager = getIfSwitchManagerService(containerName);
        if (switchManager == null) {
	    LOGGER.info("switchManager not availbale");
            throw new ServiceUnavailableException("Switch Manager "
                    + RestMessages.SERVICEUNAVAILABLE.toString());
        }
        IfIptoHost hostTracker = (IfIptoHost) ServiceHelper.getInstance(
                IfIptoHost.class, containerName, this);
        if (hostTracker == null) {
	    LOGGER.info("hostTracker not available");
            throw new ServiceUnavailableException("Host Tracker "
                    + RestMessages.SERVICEUNAVAILABLE.toString());
        }
	LOGGER.info("after populated NetworkCapabilities data");
	nc = sdnimanager.getTopologyDetails(containerName);
	LOGGER.info("nc property"+ nc.getIpAddressList());
	return nc;
}

/**
     * Update the available bandwidth property. This method returns a
     * non-successful response if the bandwidth is not updated.
     * @param containerName
     *            Name of the Container (Eg. 'default')
     * @param propertyName
     *            Name of the Property. Properties that can be configured are:
     *            description, forwarding(only for default container) and tier
     * @param propertyValue
     *            Value of the Property. Description can be any string (Eg.
     *            'Node1'), valid values for tier are non negative numbers, and
     *            valid values for forwarding are 0 for reactive and 1 for
     *            proactive forwarding.
     * @return Response as dictated by the HTTP Response Status code
     *         <pre>
     * Example:
     * Request URL:
     * http://localhost:8080/controller/nb/v2/sdni/default/property/bandwidth/5
     * </pre>
     */

    @Path("/{containerName}/property/{propertyName}/{propertyValue}")
    @PUT
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @TypeHint(Response.class)
    @StatusCodes({
            @ResponseCode(code = OPERATION_SUCCESSFUL, condition = "Operation successful"),
            @ResponseCode(code = INVALID_CONFIGURATION, condition = "The nodeId or configuration is invalid"),
            @ResponseCode(code = USER_NOT_AUTHORIZED, condition = "User not authorized to perform this operation"),
            @ResponseCode(code = CONTAINER_NOT_FOUND, condition = "The Container Name or node or configuration name is not found"),
            @ResponseCode(code = NON_DEFAULT_CONTAINER, condition = "The property cannot be configured in non-default container"),
            @ResponseCode(code = CLUSTER_CONFLICT, condition = "Unable to update configuration due to cluster conflict or conflicting description property"),
            @ResponseCode(code = SERVICES_UNAVAILABLE, condition = "One or more of Controller services are unavailable") })
    public Response updateBandwidthProperty(@Context UriInfo uriInfo,
            @PathParam("containerName") String containerName,
            @PathParam("propertyName") String propertyName,
            @PathParam("propertyValue") String propertyValue) {

        if (!isValidContainer(containerName)) {
            throw new ResourceNotFoundException(CONTAINER + containerName
                    + " does not exist.");
        }
        if (!NorthboundUtils.isAuthorized(getUserName(), containerName,
                Privilege.WRITE, this)) {
            throw new UnauthorizedException(NOT_AUTHORIZED_MESSAGE + containerName);
        }
        long bandwidth = Long.parseLong(propertyValue);
        Status status = sdnimanager.updateBandwidth(containerName, bandwidth);
        return NorthboundUtils.getResponse(status);
    }

    /**
     * Update the available bandwidth property by its link name. Set of linkname
     * with different bandwidth can be updated here. This method returns a
     * non-successful response if the bandwidth is not updated.
     * @param containerName
     *            Name of the Container (Eg. 'default')
     * @param propertyName
     *            Name of the Property. Properties that can be configured are:
     *            description, forwarding(only for default container) and tier
     * @param propertyValue
     *            Value of the Property. Description can be any string (Eg.
     *            'Node1'), valid values for tier are non negative numbers, and
     *            valid values for forwarding are 0 for reactive and 1 for
     *            proactive forwarding.
     * @return Response as dictated by the HTTP Response Status code
     *         <pre>
     * Example:
     * Request URL:
     * http://localhost:8080/controller/nb/v2/sdni/default/property/linkbandwidth/JSONObject
     * </pre>
     */

    @Path("/{containerName}/property/linkbandwidth/{propertyValue}")
    @PUT
    @Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    @TypeHint(Response.class)
    @StatusCodes({
            @ResponseCode(code = OPERATION_SUCCESSFUL, condition = "Operation successful"),
            @ResponseCode(code = INVALID_CONFIGURATION, condition = "The nodeId or configuration is invalid"),
            @ResponseCode(code = USER_NOT_AUTHORIZED, condition = "User not authorized to perform this operation"),
            @ResponseCode(code = CONTAINER_NOT_FOUND, condition = "The Container Name or node or configuration name is not found"),
            @ResponseCode(code = NON_DEFAULT_CONTAINER, condition = "The property cannot be configured in non-default container"),
            @ResponseCode(code = CLUSTER_CONFLICT, condition = "Unable to update configuration due to cluster conflict or conflicting description property"),
            @ResponseCode(code = SERVICES_UNAVAILABLE, condition = "One or more of Controller services are unavailable") })
    public Response updateLinkBandwidthProperty(@Context UriInfo uriInfo,
            @PathParam("containerName") String containerName,
            @PathParam("propertyValue") String propertyValue) {

        if (!isValidContainer(containerName)) {
            throw new ResourceNotFoundException(CONTAINER + containerName
                    + " does not exist.");
        }
        if (!NorthboundUtils.isAuthorized(getUserName(), containerName,
                Privilege.WRITE, this)) {
            throw new UnauthorizedException(NOT_AUTHORIZED_MESSAGE + containerName);
        }
        Status status = sdnimanager.updateLinkBandwidth(containerName,
                propertyValue);
        return NorthboundUtils.getResponse(status);
    }


}
