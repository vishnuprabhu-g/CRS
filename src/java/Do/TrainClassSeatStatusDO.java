package Do;
import Domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainClassSeatStatusDO{
public void add(TrainClassSeatStatus obj) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="insert into train_class_seat_status (t_class_status_id ,seat_no ,availability ,pnr ,type_id ) values (? , ?, ?, ?, ? )";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,obj.tClassStatusId);
ps.setString(2,obj.seatNo);
ps.setBoolean(3,obj.availability);
ps.setLong(4,obj.pnr);
ps.setLong(5,obj.typeId);
ps.executeUpdate();
}


public void update(TrainClassSeatStatus obj) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="update train_class_seat_status set t_class_status_id= ?,seat_no= ?,availability= ?,pnr= ?,type_id= ? where t_class_status_id = ?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,obj.tClassStatusId);
ps.setString(2,obj.seatNo);
ps.setBoolean(3,obj.availability);
ps.setLong(4,obj.pnr);
ps.setLong(5,obj.typeId);
ps.setLong(6, obj.tClassStatusId);
ps.executeUpdate();
}
public List<TrainClassSeatStatus> getAll(long id) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="select * from train_class_seat_status where t_class_status_id =?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,id);
ResultSet rs=ps.executeQuery();
List <TrainClassSeatStatus> out = new ArrayList<TrainClassSeatStatus> ();
while(rs.next()){
TrainClassSeatStatus obj=new TrainClassSeatStatus();
obj.tClassStatusId = rs.getLong("t_class_status_id");
obj.seatNo = rs.getString("seat_no");
obj.availability = rs.getBoolean("availability");
obj.pnr = rs.getLong("pnr");
obj.typeId = rs.getLong("type_id");
out.add(obj);
}
return out;
}


public TrainClassSeatStatus get(long id) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="select * from train_class_seat_status where t_class_status_id =?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,id);
ResultSet rs=ps.executeQuery();
TrainClassSeatStatus obj=new TrainClassSeatStatus();
if(rs.next()) {
obj.tClassStatusId = rs.getLong("t_class_status_id");
obj.seatNo = rs.getString("seat_no");
obj.availability = rs.getBoolean("availability");
obj.pnr = rs.getLong("pnr");
obj.typeId = rs.getLong("type_id");
}
return obj;
}

public TrainClassSeatStatus getPref(long id,int type_id) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="select * from train_class_seat_status where t_class_status_id =? and type_id=?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,id);
ps.setInt(2, type_id);
ResultSet rs=ps.executeQuery();
TrainClassSeatStatus obj=new TrainClassSeatStatus();
if(rs.next()) {
obj.tClassStatusId = rs.getLong("t_class_status_id");
obj.seatNo = rs.getString("seat_no");
obj.availability = rs.getBoolean("availability");
obj.pnr = rs.getLong("pnr");
obj.typeId = rs.getLong("type_id");
}
return obj;
}

}
