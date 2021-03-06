<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A Family Member</title>
        <link rel="stylesheet" type="text/css" href="stylesheet.css">
    </head>
    <body>
        
        <div class="wrap"> <!--div to hold all other divs -->

            <%@ include file="includes/header.jsp" %>

            <%@ include file="includes/menu.jsp" %> 
        
        <h1>Add A Family Member</h1>
        
        <form name="addForm" action="addFamily" method="get">
            
            <label>Family Name:</label>
            <input type="text" name="name" value="" />
            <br>
            <label>Relation:</label>
            <input type="text" name="relation" value="" />
            <br>
            <label>Age:</label>
            <input type="text" name="age" value="" />
            <br>
            <label>Gender:</label>
            <input type="text" name="gender" value="" />
            <br>
            <input type="reset" name="reset" value="Clear" />
            <input type="submit" name="submit" value="Submit" />
        </form>
    </body>
</html>
