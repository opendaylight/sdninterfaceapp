/*
 * Copyright (c) 2015 Tata Consultancy Services.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.protocol.bgp.sdniwrapper;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import junit.framework.TestCase;
import org.junit.Test;
import org.opendaylight.protocol.bgp.sdniwrapper.SdniWrapper;

public class parsesdnitoplologymessageTest extends TestCase{
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    private static final String DB_URL = "jdbc:sqlite:/home/tcs/sdni/database/CONTROLLER_TOPOLOGY_DATABASE";
    public static long ipToLong(String ipAddress) {
        long result = 0;
        String[] atoms = ipAddress.split("\\.");

        for (int i = 3; i >= 0; i--) {
            result |= (Long.parseLong(atoms[3 - i]) << (i * 8));
        }

        return result & 0xFFFFFFFF;
    }
    @Test
    public void testSDNIMessage(){
        //String expected="{\"output\":{\"controller\":\"10.138.89.89\",\"links\":[\"2:1->6:1\",\"3:1->7:1\",\"4:1->8:1\",\"5:1->9:1\"]}}";
        StringBuffer s=new StringBuffer();
        s.append("{\"TOPOoutput\":{\"controller\":\"10.138.89.79\",\"links\":[\"Uri [_value=openflow:3:1]\",\"Uri [_value=openflow:3:3]\",\"Uri [_value=openflow:1:4]\",\"Uri [_value=openflow:2:2]\",\"Uri [_value=openflow:2:1]\",\"Uri [_value=openflow:1:3]\"]}};{\"QoSoutput\":[{\"controller\":\"10.138.89.79\",\"node\":\"openflow:1\",\"port\":\"openflow:1:2\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:1\",\"port\":\"openflow:1:1\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:1\",\"port\":\"openflow:1:LOCAL\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:1\",\"port\":\"openflow:1:3\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:1\",\"port\":\"openflow:1:4\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:2\",\"port\":\"openflow:2:1\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:2\",\"port\":\"openflow:2:LOCAL\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:2\",\"port\":\"openflow:2:2\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:3\",\"port\":\"openflow:3:2\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:3\",\"port\":\"openflow:3:1\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:3\",\"port\":\"openflow:3:LOCAL\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:3\",\"port\":\"openflow:3:3\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"}]}");
        byte[] defaultbytes;
        ByteBuf sdnibytes = null;
        List<String> controllerList=new ArrayList<String>();
        List<String> linksList=new ArrayList<String>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        defaultbytes = s.toString().getBytes();
        sdnibytes = Unpooled.copiedBuffer(defaultbytes);
        SdniWrapper sw=SdniWrapper.getInstance();
        sw.parseSDNITopoMessage(sdnibytes);
        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL);
            stmt = conn.createStatement();
            String fetchQoSSQL="select * from TOPOLOGY_DATABASE_PEER ";
            rs=stmt.executeQuery(fetchQoSSQL);
            while(rs.next())
            {
                controllerList.add(rs.getString("controller"));
                linksList.add(rs.getString("links"));
            }
            List<String> givencontrollerList=new ArrayList<String>();
            List<String> givenlinksList=new ArrayList<String>();
            givencontrollerList.add(String.valueOf(ipToLong("10.138.89.89")));
            givencontrollerList.add(String.valueOf(ipToLong("10.138.89.89")));
            givencontrollerList.add(String.valueOf(ipToLong("10.138.89.89")));
            givencontrollerList.add(String.valueOf(ipToLong("10.138.89.89")));
            givenlinksList.add("2:1->6:1");
            givenlinksList.add("3:1->7:1");
            givenlinksList.add("4:1->8:1");
            givenlinksList.add("5:1->9:1");
            assertEquals(givencontrollerList,controllerList);
            assertEquals(givenlinksList,linksList);
        }
        catch (SQLException se) {

            return;
        } catch (Exception e) {

            return;
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {

                return;
            }

            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {

                return;
            }
        }

    }

}
