/*
 * Copyright (c) 2014 TATA Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */

package org.opendaylight.controller.sdnimanager.northbound;

import java.util.List;
import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.PathParam;

import org.codehaus.enunciate.jaxrs.ResponseCode;
import org.codehaus.enunciate.jaxrs.StatusCodes;
import org.opendaylight.controller.northbound.commons.RestMessages;
import org.opendaylight.controller.northbound.commons.exception.ResourceNotFoundException;
import org.opendaylight.controller.northbound.commons.exception.ServiceUnavailableException;
import org.opendaylight.yang.gen.v1.urn.opendaylight.port.statistics.rev151006.node.connector.statistics.and.port.number.map.NodeConnectorStatisticsAndPortNumberMap;
import org.opendaylight.sdniaggregator.OpendaylightSdniManager;

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

    private static final int OPERATION_SUCCESSFUL = 201;
    private static final int INVALID_CONFIGURATION = 400;
    private static final int USER_NOT_AUTHORIZED = 401;
    private static final int CONTAINER_NOT_FOUND = 404;
    private static final int NON_DEFAULT_CONTAINER = 406;
    private static final int CLUSTER_CONFLICT = 409;
    private static final int SERVICES_UNAVAILABLE = 503;
    private static final String CONTAINER = "Container ";
    private static final String NOT_AUTHORIZED_MESSAGE = "User is not authorized to perform this operation on container ";

    OpendaylightSdniManager sdniManager;
    List<NodeConnectorStatisticsAndPortNumberMap> list = new ArrayList<NodeConnectorStatisticsAndPortNumberMap>();

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
     * Retrieve the NodeConnectorStatisticsAndPortNumberMap Data like node, port, receive packets etc.,
     * from SDNiAggregator
     * @return NodeConnectorStatisticsAndPortNumberMap Example: Request URL:
     *         http://localhost:8080/controller/nb/v2/sdni/default/qos
     *         Response Body in JSON:
     *      [{"node":"00:00:00:00:00:00:00:04","port":"0","receivePackets":0,"transmitPackets":0,"collisionCount":0,"receiveFrameError":0,
     *      "receiveOverRunError":0,"receiveCrcError":0},
     *      {"node":"00:00:00:00:00:00:00:04","port":"1","receivePackets":61,"transmitPackets":63,"collisionCount":0,"receiveFrameError":0,
     *      "receiveOverRunError":0,"receiveCrcError":0},
     *      {"node":"00:00:00:00:00:00:00:04","port":"2","receivePackets":47,"transmitPackets":47,"collisionCount":0,"receiveFrameError":0,
     *      "receiveOverRunError":0,"receiveCrcError":0},
     *      {"node":"00:00:00:00:00:00:00:04","port":"3","receivePackets":62,"transmitPackets":64,"collisionCount":0,"receiveFrameError":0,
     *      "receiveOverRunError":0,"receiveCrcError":0},
     *      {"node":"00:00:00:00:00:00:00:06","port":"4","receivePackets":70,"transmitPackets":72,"collisionCount":0,"receiveFrameError":0,
     *      "receiveOverRunError":0,"receiveCrcError":0},
     *      {"node":"00:00:00:00:00:00:00:06","port":"0","receivePackets":0,"transmitPackets":0,"collisionCount":0,"receiveFrameError":0,
     *      "receiveOverRunError":0,"receiveCrcError":0},
     *      {"node":"00:00:00:00:00:00:00:06","port":"1","receivePackets":27,"transmitPackets":290,"collisionCount":0,
     *      "receiveFrameError":0,"receiveOverRunError":0,"receiveCrcError":0},
     *      {"node":"00:00:00:00:00:00:00:06","port":"2","receivePackets":23,"transmitPackets":285,"collisionCount":0,
     *      "receiveFrameError":0,"receiveOverRunError":0,"receiveCrcError":0},
     *      {"node":"00:00:00:00:00:00:00:06","port":"3","receivePackets":61,"transmitPackets":55,"collisionCount":0,"receiveFrameError":0,
     *      "receiveOverRunError":0,"receiveCrcError":0},
     *      {"node":"00:00:00:00:00:00:00:05","port":"0","receivePackets":0,"transmitPackets":0,"collisionCount":0,"receiveFrameError":0,
     *      "receiveOverRunError":0,"receiveCrcError":0},
     *      "node":"00:00:00:00:00:00:00:05","port":"1","receivePackets":51,"transmitPackets":51,"collisionCount":0,"receiveFrameError":0,
     *      "receiveOverRunError":0,"receiveCrcError":0},
     *      {"node":"00:00:00:00:00:00:00:05","port":"2","receivePackets":52,"transmitPackets":54,"collisionCount":0,"receiveFrameError":0,
     *      "receiveOverRunError":0,"receiveCrcError":0}]
  **/

    @Path("/{containerName}/qos")
    @GET
    @Produces({ MediaType.APPLICATION_JSON })
    @StatusCodes({ @ResponseCode(code = CONTAINER_NOT_FOUND, condition = "The Container Name was not found") })
    public List<NodeConnectorStatisticsAndPortNumberMap> getQosDetails(){

    LOGGER.info("after populated NetworkCapabilitiesQOS data");
    try {
       list = sdniManager.getNodeConnectorStatistics();
    }
    catch (Exception e) {
    }

    LOGGER.info("list property"+ list);
    if(list == null){
       throw new ServiceUnavailableException("SDNi QoS service "+ RestMessages.SERVICEUNAVAILABLE.toString());
    }
    return list;
  }
}
