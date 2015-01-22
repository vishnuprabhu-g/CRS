<%-- 
    Document   : viewTicket
    Created on : 21 Jan, 2015, 9:15:49 AM
    Author     : vishnu-pt517
--%>

<%@page import="java.util.List"%>
<%@page import="Domain.Passenger"%>
<%@page import="DO.PassengerDO"%>
<%@page import="Domain.Reservation"%>
<%@page import="DO.ReservationDO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Ticket</title>
    </head>
    <body>
        <%
            long pnr = Long.parseLong(request.getParameter("pnr"));
            out.println("PNR: " + pnr + "<br>");

            ReservationDO rdo = new ReservationDO();
            Reservation r = rdo.get(pnr);
            out.println("Booked on:" + new java.util.Date(r.getTimestamp()));

            PassengerDO pdo = new PassengerDO();
            List<Passenger> passengers = pdo.get(pnr);
        %>
        <table>
            <thead>
                <tr>
                    <th>Name</th><th>Age</th><th>Gender</th><th>Seat</th>
                </tr>
            </thead>
            <tbody>

                <%
                    for (Passenger p : passengers) {
                        String gen = p.getGender() == 1 ? "Male" : "Female";
                        out.println("<tr><td>" + p.getPassenger_name() + "</td><td>" + p.getAge() + "</td><td>" + gen+"</td><td>"+p.getSeat()+"</td></tr>");
                    }
                %>

            </tbody>
        </table>
    </body>
</html>
