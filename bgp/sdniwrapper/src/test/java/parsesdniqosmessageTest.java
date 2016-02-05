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


public class parsesdniqosmessageTest extends TestCase{
    private static final String JDBC_DRIVER = "org.sqlite.JDBC";
    private static final String QOS_DB_URL = "jdbc:sqlite:/home/tcs/sdni/database/CONTROLLER_QOS_DATABASE";
    public static long ipToLong(String ipAddress) {
        long result = 0;
        String[] atoms = ipAddress.split("\\.");

        for (int i = 3; i >= 0; i--) {
            result |= (Long.parseLong(atoms[3 - i]) << (i * 8));
        }

        return result & 0xFFFFFFFF;
    }
    @Test
    public void testparseSDNIQosMessage(){
        StringBuffer s=new StringBuffer();
        s.append("{\"TOPOoutput\":{\"controller\":\"10.138.89.79\",\"links\":[\"Uri [_value=openflow:3:1]\",\"Uri [_value=openflow:3:3]\",\"Uri [_value=openflow:1:4]\",\"Uri [_value=openflow:2:2]\",\"Uri [_value=openflow:2:1]\",\"Uri [_value=openflow:1:3]\"]}};{\"QoSoutput\":[{\"controller\":\"10.138.89.79\",\"node\":\"openflow:1\",\"port\":\"openflow:1:2\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:1\",\"port\":\"openflow:1:1\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:1\",\"port\":\"openflow:1:LOCAL\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:1\",\"port\":\"openflow:1:3\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:1\",\"port\":\"openflow:1:4\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:2\",\"port\":\"openflow:2:1\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:2\",\"port\":\"openflow:2:LOCAL\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:2\",\"port\":\"openflow:2:2\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:3\",\"port\":\"openflow:3:2\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:3\",\"port\":\"openflow:3:1\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:3\",\"port\":\"openflow:3:LOCAL\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"10.138.89.79\",\"node\":\"openflow:3\",\"port\":\"openflow:3:3\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"}]}");

        //s.append("{\"output\":[{\"controller\":\"192.168.122.1\",\"node\":\"openflow:6\",\"port\":\"openflow:6:2\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"192.168.122.1\",\"node\":\"openflow:6\",\"port\":\"openflow:6:3\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"192.168.122.1\",\"node\":\"openflow:6\",\"port\":\"openflow:6:4\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"192.168.122.1\",\"node\":\"openflow:6\",\"port\":\"openflow:6:1\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"192.168.122.1\",\"node\":\"openflow:6\",\"port\":\"openflow:6:LOCAL\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"192.168.122.1\",\"node\":\"openflow:5\",\"port\":\"openflow:5:LOCAL\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"192.168.122.1\",\"node\":\"openflow:5\",\"port\":\"openflow:5:1\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"192.168.122.1\",\"node\":\"openflow:5\",\"port\":\"openflow:5:2\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"192.168.122.1\",\"node\":\"openflow:4\",\"port\":\"openflow:4:1\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"192.168.122.1\",\"node\":\"openflow:4\",\"port\":\"openflow:4:LOCAL\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"192.168.122.1\",\"node\":\"openflow:4\",\"port\":\"openflow:4:2\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"},{\"controller\":\"192.168.122.1\",\"node\":\"openflow:4\",\"port\":\"openflow:4:3\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"}]}");

        //String expectedstr="{\"output\":[{\"controller\":\"10.138.89.79\",\"node\":\"openflow:1\",\"port\":\"openflow:1:2\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"0\",\"transmitPackets\":\"0\"}]}";
        byte[] Defaultbytes;
        ByteBuf Sdnibytes=null;
        List<String> controllerList=new ArrayList<String>();
        List<String> nodeList=new ArrayList<String>();
        List<String> portList=new ArrayList<String>();
        List<String> receiveFrameErrorList=new ArrayList<String>();
        List<String> receiveOverRunErrorList=new ArrayList<String>();
        List<String> receiveCrcErrorList=new ArrayList<String>();
        List<String> collisionCountList=new ArrayList<String>();
        List<String> recievedPacketList=new ArrayList<String>();
        List<String> transmitPacketList=new ArrayList<String>();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        Defaultbytes = s.toString().getBytes();
        Sdnibytes= Unpooled.copiedBuffer(Defaultbytes);
        SdniWrapper Sw=SdniWrapper.getInstance();
        Sw.parseSDNIQoSMessage(Sdnibytes);

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(QOS_DB_URL);
            stmt = conn.createStatement();
            String fetchQoSSQL="select * from QOS_DATABASE_PEER_1";
            rs=stmt.executeQuery(fetchQoSSQL);
            while(rs.next())
            {
                controllerList.add(rs.getString("controller"));
                nodeList.add(rs.getString("node"));
                portList.add(rs.getString("port"));
                receiveFrameErrorList.add(rs.getString("receiveFrameError"));
                receiveOverRunErrorList.add(rs.getString("receiveOverRunError"));
                receiveCrcErrorList.add(rs.getString("receiveCrcError"));
                collisionCountList.add(rs.getString("collisionCount"));
                recievedPacketList.add(rs.getString("receivePackets"));
                transmitPacketList.add(rs.getString("transmitPackets"));

            }
            List<String> givencontrollerList=new ArrayList<String>();
            List<String> givennodeList=new ArrayList<String>();
            List<String> givenportList=new ArrayList<String>();
            List<String> givenrecieveframeerrorList=new ArrayList<String>();
            List<String> givenrecieveoverrunerrorList=new ArrayList<String>();
            List<String> givenrecievecrcerrorList=new ArrayList<String>();
            List<String> givencollisioncountList=new ArrayList<String>();
            List<String> givenrecievedPacketList=new ArrayList<String>();
            List<String> givenrtransmitPacketList=new ArrayList<String>();
            givencontrollerList.add(String.valueOf(ipToLong("10.138.89.66")));
            givencontrollerList.add(String.valueOf(ipToLong("10.138.89.66")));
            givennodeList.add("00:00:00:00:00:00:00:02");
            givennodeList.add("00:00:00:00:00:00:00:01");
            givenportList.add("3");
            givenportList.add("3");
            givenrecieveframeerrorList.add("0");
            givenrecieveframeerrorList.add("0");
            givenrecieveoverrunerrorList.add("0");
            givenrecieveoverrunerrorList.add("0");
            givenrecievecrcerrorList.add("0");
            givenrecievecrcerrorList.add("0");
            givencollisioncountList.add("0");
            givencollisioncountList.add("0");
            givenrecievedPacketList.add("234");
            givenrecievedPacketList.add("234");
            givenrtransmitPacketList.add("123");
            givenrtransmitPacketList.add("123");
            /*assertEquals(givencontrollerList,controllerList);
            assertEquals(givennodeList,nodeList);
            assertEquals(givenportList,portList);
            assertEquals(givenrecieveframeerrorList,receiveFrameErrorList);
            assertEquals(givenrecieveoverrunerrorList,receiveOverRunErrorList);
            assertEquals(givenrecievecrcerrorList,receiveCrcErrorList);
            assertEquals(givencollisioncountList,collisionCountList);
            assertEquals(givenrecievedPacketList,recievedPacketList);
            assertEquals(givenrtransmitPacketList,transmitPacketList);*/
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

