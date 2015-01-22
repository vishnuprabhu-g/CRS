package Do;
import Domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class trainClassStatusDO{
public void add(trainClassStatus obj) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="insert into train_class_status (trian_class_status_id ,status_id ,class_id ,total ,available ) values (? , ?, ?, ?, ? )";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,obj.trianClassStatusId);
ps.setLong(2,obj.statusId);
ps.setLong(3,obj.classId);
ps.setInt(4,obj.total);
ps.setInt(5,obj.available);
ps.executeUpdate();
}


public void update(trainClassStatus obj) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="update train_class_status set trian_class_status_id= ?,status_id= ?,class_id= ?,total= ?,available= ? where trian_class_status_id = ?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,obj.trianClassStatusId);
ps.setLong(2,obj.statusId);
ps.setLong(3,obj.classId);
ps.setInt(4,obj.total);
ps.setInt(5,obj.available);
ps.setLong(6, obj.trianClassStatusId);
ps.executeUpdate();
}
public List<trainClassStatus> getAll(long id) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="select * from train_class_status where status_id =?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,id);
ResultSet rs=ps.executeQuery();
List <trainClassStatus> out = new ArrayList<trainClassStatus> ();
while(rs.next()){
trainClassStatus obj=new trainClassStatus();
obj.trianClassStatusId = rs.getLong("trian_class_status_id");
obj.statusId = rs.getLong("status_id");
obj.classId = rs.getLong("class_id");
obj.total = rs.getInt("total");
obj.available = rs.getInt("available");
out.add(obj);
}
return out;
}


public trainClassStatus get(long id) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="select * from train_class_status where status_id =?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,id);
ResultSet rs=ps.executeQuery();
trainClassStatus obj=new trainClassStatus();
if(rs.next()) {
obj.trianClassStatusId = rs.getLong("train_class_status_id");
obj.statusId = rs.getLong("status_id");
obj.classId = rs.getLong("class_id");
obj.total = rs.getInt("total");
obj.available = rs.getInt("available");
}
return obj;
}



}
