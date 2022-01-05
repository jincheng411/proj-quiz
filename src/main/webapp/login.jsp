
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>

<html>
<head>
    <title>Login</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Login</h1>
    <form method="POST" action="/login">
    <div class="form-group">
        <label for="email">Email</label>
        <input type="text" class="form-control" id="email" name="email">
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password">
    </div>
    <div class="text-center">
        <button type="submit" class="btn btn-primary">Login</button>
        <div>

        <a href="${pageContext.request.contextPath}/signUp" class="mr-sm-2">Don't have an account?</a>
        </div>
    </div>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    </form>
</body>
</html>
