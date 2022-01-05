<%--
  Created by IntelliJ IDEA.
  User: jincheng
  Date: 1/1/22
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<html>
<head>

    <title>QuizLand</title>
</head>
<body>
    <%@ include file="navbar.jsp" %>
<div class="container">
    <h1>Error</h1>
    <h5>${exception}</h5>
    <h5>${url}</h5>
</div>
</body>
</html>

