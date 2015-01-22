/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vishnu-pt517
 */
public class TrainStatusN {

    public TrainStatus get() throws SQLException {
        Connection con = util.ConnectionUtil.getConnection();
        String query = "select * from train_status_n";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        TrainStatus ts = new TrainStatus();
        rs.next();
        ts.totalSeat = rs.getInt(1);
        ts.availableSeat = rs.getInt(2);
        ts.totlaRac = rs.getInt(3);
        ts.availableRac = rs.getInt(4);
        ts.LB = rs.getLong(5);
        ts.MB = rs.getLong(6);
        ts.UB = rs.getLong(7);
        ts.SU = rs.getLong(8);
        ts.SL = rs.getLong(9);

        return ts;
    }

    public void set(TrainStatus ts) throws SQLException {
        Connection con = util.ConnectionUtil.getConnection();
        String query = "update train_status_n set available_seat=?,available_rac=?,LB=?,MB=?,UB=?,SU=?,SL=?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, ts.availableSeat);
        ps.setInt(2, ts.availableRac);
        ps.setLong(3, ts.LB);
        ps.setLong(4, ts.MB);
        ps.setLong(5, ts.UB);
        ps.setLong(6, ts.SU);
        ps.setLong(7, ts.SL);
        ps.executeUpdate();
    }
}
