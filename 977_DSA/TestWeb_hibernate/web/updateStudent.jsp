<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update student</title>
        <link rel="stylesheet" href="style.css">

    </head>
    <body>
                 
        <h3>Modifier les informations de l'étudiant : </h3>
        
        <form action="updateStudent" method="post">
            <input type="hidden" name="action" value="update">
            <input type="hidden" name="id" value="${student.id}">

            <label>First Name:</label>
            <input type="text" name="firstName" value="${student.firstName}" required><br>

            <label>Last Name:</label>
            <input type="text" name="lastName" value="${student.lastName}" required><br>

            <label>&nbsp;</label>
            <input type="submit" value="Update">
        </form>
    </body>
</html>
