<html>
    <body>
        <form action="../BookTest" id="frm">
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="col-md-1">S.No</th><th class="col-md-4">Name<span class="red-star">*</span></th><th class="col-md-2">Age<span class="red-star">*</span></th><th class="col-md-2">Gender<span class="red-star">*</span></th><th class="col-md-2">Berth preference</th><th class="col-md-1">Senior</th>
                    </tr>
                </thead>
                <tbody>               
                    <%
                        for (int i = 0; i < 6; i++) {
                            out.println("<tr><td>" + i + "</td><td><input size=\"30\" type=\"text\" name=\"name" + i + "\"></td><td><input type=\"text\"  size=\"3\" name=\"age" + i + "\" ></td><td><select name=\"gender" + i + "\"><option value=\"1\">Male</option><option value=\"2\">Female</option> </select></td><td><select name=\"berth" + i + "\"><option value=\"0\">No preference</option><option value=\"1\">Lower Berth</option><option value=\"2\">Middle Berth</option><option value=\"3\">Upper Berth</option><option value=\"4\">Side Upper</option></select></td><td><select name=\"senior" + i + "\"><option value=\"1\">No</option><option value=\"2\">Yes</option> </select></td></tr>");
                        }
                    %>               
                </tbody>
            </table>
            <input type="submit">
        </form>
    </body>
</html>
