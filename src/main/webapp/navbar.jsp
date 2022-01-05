<%@ page import="com.example.quizzproject.entity.User" %><%--
  Created by IntelliJ IDEA.
  User: jincheng
  Date: 12/31/21
  Time: 9:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%
    HttpSession session = request.getSession(false);
    User user = null;
    if (session != null) {
        user = (User) session.getAttribute("user");
    }
%>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">QuizLand</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${pageContext.request.contextPath}/">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/result">History</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="${pageContext.request.contextPath}/feedback">Feedback</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    Take a quiz
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/quiz/1?newQuiz=1">Java</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/quiz/2?newQuiz=1">MySQL</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/quiz/3?newQuiz=1">JavaScript</a>
                </div>
            </li>
        </ul>
        <div class="form-inline my-2 my-lg-0">
            <% if (user == null) { %>
            <a href="${pageContext.request.contextPath}/login" class="mr-sm-2">Login</a>
            <a href="${pageContext.request.contextPath}/signUp" class="mr-sm-2">Sign Up</a>
           <% } else { %>
            Hello, <%=user.getName()%>
            <a href="${pageContext.request.contextPath}/logout" class="mr-sm-2">Logout</a>
            <%} %>

        </div>
    </div>
</nav>
</body>
</html>
