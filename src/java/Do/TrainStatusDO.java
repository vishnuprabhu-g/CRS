package Do;
import Domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrainStatusDO{
    public TrainStatusDO(){}
public void add(TrainStatus obj) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="insert into train_status (staus_id ,train_id ,date ) values (? , ?, ? )";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,obj.stausId);
ps.setLong(2,obj.trainId);
ps.setDate(3,obj.date);
ps.executeUpdate();
}


public void update(TrainStatus obj) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="update train_status set staus_id= ?,train_id= ?,date= ? where staus_id = ?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,obj.stausId);
ps.setLong(2,obj.trainId);
ps.setDate(3,obj.date);
ps.setLong(4, obj.stausId);
ps.executeUpdate();
}
public List<TrainStatus> getAll(long id) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="select * from train_status where train_id =?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,id);
ResultSet rs=ps.executeQuery();
List <TrainStatus> out = new ArrayList<TrainStatus> ();
while(rs.next()){
TrainStatus obj=new TrainStatus();
obj.stausId = rs.getLong("status_id");
obj.trainId = rs.getLong("train_id");
obj.date = rs.getDate("date");
out.add(obj);
}
return out;
}


public TrainStatus get(long id) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="select * from train_status where train_id =?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,id);
ResultSet rs=ps.executeQuery();
TrainStatus obj=new TrainStatus();
if(rs.next()) {
obj.stausId = rs.getLong("status_id");
obj.trainId = rs.getLong("train_id");
obj.date = rs.getDate("date");
}
return obj;
}



}
