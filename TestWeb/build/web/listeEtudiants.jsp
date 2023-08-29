<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="model.Person"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="style.css" type="text/css">

        <title>Tous les etudiants</title>
    </head>
    <body>
        
        <h1>Etudiants inscrits</h1>
        
        <table border="1">
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
            </tr>
            
            <c:forEach items="${students}" var="student">
                <tr>
                    <td>${student.firstName}</td>
                    <td>${student.lastName}</td>
                    <td><a href="<c:url value='/updateStudent?id=${student.id}&action=update'/>">Modifier</a></td>
                    <td><a href="<c:url value='/index?action=delete&id=${student.id}'/>">Supprimer</a></td>
                </tr>
            </c:forEach>

        </table>
            
         <p>Pour inscrire un nouvel étudiant :</p>
        <form action="" method="get">
            <input type="hidden" name="action" value="join">
            <input type="submit" value="Return">
        </form>

    </body>
</html>
