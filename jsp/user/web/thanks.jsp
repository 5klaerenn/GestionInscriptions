<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chapter 2</title>
        <link rel="stylesheet" href="style.css" type="text/css"/>
    </head>
    
    <body>
        <h1>Thansk for joining our email list</h1>
        <p>Here is the information that you entered : </p>
        
        <label>Email:</label>
        <span>${user.email}</span><br>
        <label>First Name :</label>
        <span>${user.firstName}</span><br>
        <label>Lst Name :</label>
        <span>${user.lastName}</span><br>
        
        <p>To enter another email adress, click on the Back button in your browser or the Return button shown below.</p>
        
        <form action="" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>
        
    </body>
</html>
