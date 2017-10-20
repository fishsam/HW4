<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.FAMILY"%>
<% FAMILY family = (FAMILY) request.getAttribute("family"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <link rel="stylesheet" type="text/css" href="stylesheet.css">
        <title>Update A Family Member</title>
    </head>
    <body>
        <h1>Update A Family Member Record</h1>
        
        <form name="updateForm" action="updateFamily" method="get">
            
            <table class="update">
                <tr>
                    <td class="right">Family ID:</td>
                    <td><input type="text" name="id" value="<%= family.getID() %>" readonly/></td>
                </tr>
                <tr>
                    <td class="right">Family Name:</td>
                    <td><input type="text" name="name" value="<%= family.getNAME() %>" /></td>
                </tr>
                
                <tr>
                    <td class="right">Relation:</td>
                    <td><input type="text" name="relation" value="<%= family.getRELATION() %>" /></td>
                </tr>
                
                <tr>
                    <td class="right">Age:</td>
                    <td><input type="text" name="age" value="<%= family.getAGE() %>" /></td>
                   </tr>
                
                <tr>
                    <td class="right">Gender:</td>
                    <td><input type="text" name="gender" value="<%= family.getGENDER() %>" /></td>
                </tr>
            </table>
                <br>
                <input type="reset" name="reset" value="Clear" />
            <input type="submit" name="submit" value="Update" />
        </form>
    </body>
</html>
