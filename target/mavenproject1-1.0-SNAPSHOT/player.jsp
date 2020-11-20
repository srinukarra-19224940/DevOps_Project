<%-- 
    Document   : player
    Created on : 28-Oct-2020, 2:37:05 PM
    Author     : srinu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PLAYER INFORmATION</title>
    </head>
    
        <script
	  src="https://code.jquery.com/jquery-3.5.1.js"
	  integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	  crossorigin="anonymous"></script>

	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
        <h1>PLAYER INFORMATION</h1>
        
        <div class="panel-body">
            
        </div>
        <!--Insert player method -->
       <form action = "<%= request.getContextPath()%>/cricket" method ="post">
            
       <!-- Displaying player  -->
        <div class="form-group">
            <label for ="jerseyno">Jerseyno</label>
            <input type ="text" class="form-control" name="jerseyno"/>
        </div>
        <div class="form-group">
            <label for ="player_name">Player_Name</label>
            <input type ="text" class="form-control" name="player_name"/>
        </div>
        <div class="form-group">
            <label for ="player_age">Player_Age</label>
            <input type ="text" class="form-control" name="player_age"/>
        </div>
        <div class="form-group">
            <label for ="player_type">Player_Type</label>
            <input type ="text" class="form-control" name="player_type"/>
        </div>
        <div class="form-group">
            <label for ="total_runs">Total_Runs</label>
            <input type ="text" class="form-control" name="total_runs"/>
        </div>
        <div class="form-group">
            <label for ="total_wickets">Total_Wickets</label>
            <input type ="text" class="form-control" name="total_wickets"/>
        </div>
        <input type="submit" class="btn btn-primary" />
        <button class="btn btn-primary" ><a  href="welcome.jsp" style="color:white; ">Back</a></button>
         </form>

</html>
