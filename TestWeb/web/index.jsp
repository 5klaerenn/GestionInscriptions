<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri ="http://java.sun.com/jsp/jstl/functions" %>
<%@page import="model.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Accueil</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="style.css">
    </head>
  <body>
      
        <h1>Gestion des étudiants</h1>
          
        <h3>Pour inscrire un nouvel étudiant : </h3>       
        
        <form action="student" method="post">
            <input type="hidden" name="action" value="add">
                 
            <label>First Name:</label>
            <input type="text" name="firstName" required><br>

            <label>Last Name:</label>
            <input type="text" name="lastName" required><br>
            
            <label>&nbsp;</label>
            <input type ="submit" value="Ajouter" id="submit">
        </form>
        
        <h3>Étudiants inscrits : </h3>
        
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
        
        
        
    </body>
</html>