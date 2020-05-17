<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>file download page</title>
</head>
<body>
<%
String user=request.getParameter("username");
out.print("欢迎"+user+"登录");
%>
</body>
</html>