<%-- 
    Document   : user/index
    Created on : 19 Jan, 2015, 12:33:46 PM
    Author     : vishnu-pt517
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Passenger Home</title>
        <link rel="stylesheet" href="../css/bootstrap.css"/>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.2/themes/smoothness/jquery-ui.css">
        <style>
            .red-star {
                color: red;
                font-size: 110%;
            }
        </style>
    </head>
    <body>
        <script src="//code.jquery.com/ui/1.11.2/jquery-ui.js"></script>
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <div >
            <div >
                <form id="ticket_book">
                    <!-- <table>
                         <tr><td> From:</td><td><input type="text" name="from"/></td></tr>
                         <tr><td>To:</td><td><input type="text" name="to"/></td></tr>
                         <tr><td> Date:</td><td> <input type="text" id="datepicker"></td></tr>
                     </table>-->
                </form>                
            </div>
            <div style="margin-left: 15%;margin-right: 15%">
                <%@include file="book_ticket1.jsp" %>
            </div>
        </div>
    </body>
</html>
