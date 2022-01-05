<%--
  Created by IntelliJ IDEA.
  User: jincheng
  Date: 12/31/21
  Time: 10:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>

<html>
<head>
    <%@ include file="navbar.jsp" %>
    <title>Sign Up</title>
</head>
<body>
<div class="container">
    <h1 class="text-center">Sign up</h1>
    <form method="POST" action="/signUp">

        <div class="form-group">
        <label for="email">Email</label>
        <input type="text" class="form-control" id="email" name="email">
    </div>
        <div class="form-group">
            <label for="name">Name</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" class="form-control" id="password" name="password">
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-primary">Sign Up</button>
            <div>
                <a href="${pageContext.request.contextPath}/login" class="mr-sm-2">Already have an account?</a>
            </div>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />

    </form>
</div>
</body>
</html>
