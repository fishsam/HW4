
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add A Family Member</title>
    </head>
    <body>
        <h1>Add A Family Member</h1>
        
        <form name="addForm" action="addFamily" method="get">
            <link rel="stylesheet" type="text/css" href="READ.css">
            <label>Family Name:</label>
            <input type="text" name="NAME" value="" />
            <br>
            <label>Relation:</label>
            <input type="text" name="RELATION" value="" />
            <br>
            <label>Age:</label>
            <input type="text" name="AGE" value="" />
            <br>
            <label>Gender:</label>
            <input type="text" name="GENDER" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" />
        </form>
    </body>
</html>
