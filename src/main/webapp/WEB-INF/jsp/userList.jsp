<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Title</title>
</head>
<body>
<table border="1" align="center" width="50%">
    <tr>
        <th>ID:</th>
        <th>Name:</th>
        <th>Age:</th>
        <th>Sex:</th>
    </tr>
    <c:forEach items="${list}" var="user">
    <tr><td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.age}</td>
        <td><c:if test="${user.sex==true}">男</c:if> <c:if test="${user.sex==false}">女</c:if></td>
    </c:forEach>
</table>
</body>
</html>
