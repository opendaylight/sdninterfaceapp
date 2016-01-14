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
    @Test
    public void testparseSDNIQosMessage(){
        String expectedstr="{\"output\":[{\"controller\":\"10.138.89.66\",\"node\":\"00:00:00:00:00:00:00:02\",\"port\":\"3\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"234\",\"transmitPackets\":\"123\"},{\"controller\":\"10.138.89.66\",\"node\":\"00:00:00:00:00:00:00:01\",\"port\":\"3\",\"collisionCount\":\"0\",\"receiveFrameError\":\"0\",\"receiveOverRunError\":\"0\",\"receiveCrcError\":\"0\",\"receivePackets\":\"234\",\"transmitPackets\":\"123\"}]}";
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

        Defaultbytes = expectedstr.getBytes();
        Sdnibytes= Unpooled.copiedBuffer(Defaultbytes);
        SdniWrapper Sw=new SdniWrapper();
        Sw.parseSDNIQoSMessage(Sdnibytes);

        try{
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(QOS_DB_URL);
            stmt = conn.createStatement();
            String fetchQoSSQL="select * from QOS_DATABASE_PEER_1 ";
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
            givencontrollerList.add("10.138.89.66");
            givencontrollerList.add("10.138.89.66");
            givennodeList.add("2");
            givennodeList.add("1");
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
            assertEquals(givencontrollerList,controllerList);
            assertEquals(givennodeList,nodeList);
            assertEquals(givenportList,portList);
            assertEquals(givenrecieveframeerrorList,receiveFrameErrorList);
            assertEquals(givenrecieveoverrunerrorList,receiveOverRunErrorList);
            assertEquals(givenrecievecrcerrorList,receiveCrcErrorList);
            assertEquals(givencollisioncountList,collisionCountList);
            assertEquals(givenrecievedPacketList,recievedPacketList);
            assertEquals(givenrtransmitPacketList,transmitPacketList);
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
