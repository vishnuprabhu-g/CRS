<%@page import="Domain.trainClassStatus"%>
<%@page import="Domain.TrainStatus"%>
<%@page import="util.TrainStatusN"%>
<%
    Domain.TrainStatus ts=new TrainStatus();
    ts=new Do.TrainStatusDO().get(1);
    Domain.trainClassStatus tcs=new trainClassStatus();
    tcs=new Do.trainClassStatusDO().get(ts.stausId);
%>

<html>
    <body>
        <table>
            <thead>
                <tr>
                    <th>Train Name</th><th>Available </th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Train 1</td><td><%= tcs.available %></td><td><a href="book.jsp?tcs= <%= tcs.trianClassStatusId %> " >Book</a></td>
                </tr>
            </tbody>
        </table>
    </body>
</html>