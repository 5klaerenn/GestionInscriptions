<%--
  Created by IntelliJ IDEA.
  User: Sklaerenn
  Date: 2023-08-26
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="entity.Student"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste d'étudiants</title>
</head>
<body>
<table border="2">

    Session:= ${sessionId}

    <c:forEach var="pers" items="${x}" >
        <tr>
            <td>  ${pers.id} </td>
            <td>   ${pers.name} </td>
            <td>    <a href="<c:url value='/student?x=${pers.id}&act=delete'/>">delete</a>
            </td>
            <td>     <a href="<c:url value='/student?x=${pers.id}&act=update'/>">update</a>   <br>
            </td>
        </tr>
    </c:forEach>
</table>
<br>


<a href="student.html" >new</a> <br>
<a href="<c:url value='/logout'/>">logout</a>


</body>
</html>
