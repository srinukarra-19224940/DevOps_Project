<%-- 
    Document   : update
    Created on : 04-Nov-2020, 8:22:44 PM
    Author     : srinu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Info</title>
    </head>
    <body>
        <h1>Enter Details</h1>
        <form action = "<%= request.getContextPath()%>/EditServlet" method ="get">
        
         <div class="form-group">
            <label for ="jerseyno">Jersey No : </label>
            <input type ="text" class="form-control" name="jerseyno"/>
            <button type ="Submit" class="btn-btn-primary">Get Details</button>
            
        </form>
    </body>
</html>
