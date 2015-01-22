package Do;
import Domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerDO{
public void add(Passenger obj) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="insert into passenger (pnr ,name ,age ,gender ,initial_seat ,current_seat ,status ,sno ) values (? , ?, ?, ?, ?, ?, ?, ? )";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,obj.pnr);
ps.setString(2,obj.name);
ps.setInt(3,obj.age);
ps.setInt(4,obj.gender);
ps.setString(5,obj.initialSeat);
ps.setString(6,obj.currentSeat);
ps.setInt(7,obj.status);
ps.setInt(8,obj.sno);
ps.executeUpdate();
}


public void update(Passenger obj) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="update passenger set pnr= ?,name= ?,age= ?,gender= ?,initial_seat= ?,current_seat= ?,status= ?,sno= ? where pnr = ?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,obj.pnr);
ps.setString(2,obj.name);
ps.setInt(3,obj.age);
ps.setInt(4,obj.gender);
ps.setString(5,obj.initialSeat);
ps.setString(6,obj.currentSeat);
ps.setInt(7,obj.status);
ps.setInt(8,obj.sno);
ps.setLong(9, obj.pnr);
ps.executeUpdate();
}
public List<Passenger> getAll(long id) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="select * from passenger where pnr =?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,id);
ResultSet rs=ps.executeQuery();
List <Passenger> out = new ArrayList<Passenger> ();
while(rs.next()){
Passenger obj=new Passenger();
obj.pnr = rs.getLong("pnr");
obj.name = rs.getString("name");
obj.age = rs.getInt("age");
obj.gender = rs.getInt("gender");
obj.initialSeat = rs.getString("initial_seat");
obj.currentSeat = rs.getString("current_seat");
obj.status = rs.getInt("status");
obj.sno = rs.getInt("sno");
out.add(obj);
}
return out;
}


public Passenger get(long id) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="select * from passenger where pnr =?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,id);
ResultSet rs=ps.executeQuery();
Passenger obj=new Passenger();
if(rs.next()) {
obj.pnr = rs.getLong("pnr");
obj.name = rs.getString("name");
obj.age = rs.getInt("age");
obj.gender = rs.getInt("gender");
obj.initialSeat = rs.getString("initial_seat");
obj.currentSeat = rs.getString("current_seat");
obj.status = rs.getInt("status");
obj.sno = rs.getInt("sno");
}
return obj;
}



}
