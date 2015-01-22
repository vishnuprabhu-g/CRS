package Do;
import Domain.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PassengerTicketDO{
public void add(PassengerTicket obj) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="insert into passenger_ticket (pnr ,journey_id ,from_station ,to_station ,total_fare ,total_adult ,total_children ,timestamp ) values (? , ?, ?, ?, ?, ?, ?, ? )";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,obj.pnr);
ps.setLong(2,obj.journeyId);
ps.setLong(3,obj.fromStation);
ps.setLong(4,obj.toStation);
ps.setInt(5,obj.totalFare);
ps.setInt(6,obj.totalAdult);
ps.setInt(7,obj.totalChildren);
ps.setLong(8,obj.timestamp);
ps.executeUpdate();
}


public void update(PassengerTicket obj) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="update passenger_ticket set pnr= ?,journey_id= ?,from_station= ?,to_station= ?,total_fare= ?,total_adult= ?,total_children= ?,timestamp= ? where pnr = ?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,obj.pnr);
ps.setLong(2,obj.journeyId);
ps.setLong(3,obj.fromStation);
ps.setLong(4,obj.toStation);
ps.setInt(5,obj.totalFare);
ps.setInt(6,obj.totalAdult);
ps.setInt(7,obj.totalChildren);
ps.setLong(8,obj.timestamp);
ps.setLong(9, obj.pnr);
ps.executeUpdate();
}
public List<PassengerTicket> getAll(long id) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="select * from passenger_ticket where pnr =?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,id);
ResultSet rs=ps.executeQuery();
List <PassengerTicket> out = new ArrayList<PassengerTicket> ();
while(rs.next()){
PassengerTicket obj=new PassengerTicket();
obj.pnr = rs.getLong("pnr");
obj.journeyId = rs.getLong("journey_id");
obj.fromStation = rs.getLong("from_station");
obj.toStation = rs.getLong("to_station");
obj.totalFare = rs.getInt("total_fare");
obj.totalAdult = rs.getInt("total_adult");
obj.totalChildren = rs.getInt("total_children");
obj.timestamp = rs.getLong("timestamp");
out.add(obj);
}
return out;
}


public PassengerTicket get(long id) throws SQLException{
Connection con=util.ConnectionUtil.getConnection();
String q="select * from passenger_ticket where pnr =?;";
PreparedStatement ps=con.prepareStatement(q);
ps.setLong(1,id);
ResultSet rs=ps.executeQuery();
PassengerTicket obj=new PassengerTicket();
if(rs.next()) {
obj.pnr = rs.getLong("pnr");
obj.journeyId = rs.getLong("journey_id");
obj.fromStation = rs.getLong("from_station");
obj.toStation = rs.getLong("to_station");
obj.totalFare = rs.getInt("total_fare");
obj.totalAdult = rs.getInt("total_adult");
obj.totalChildren = rs.getInt("total_children");
obj.timestamp = rs.getLong("timestamp");
}
return obj;
}



}
