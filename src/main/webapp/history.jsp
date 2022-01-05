<%--
  Created by IntelliJ IDEA.
  User: jincheng
  Date: 1/4/22
  Time: 12:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<html>
<head>
    <title>QuizLand</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<h1 class="text-center">Quiz History</h1>
<div class="container">
    <c:forEach items="${submissions}" var="s">

    <c:choose>
    <c:when test="${s.getIsPassed() == 1}">
    <div style="border:3px solid green; color: white">
        </c:when>
        <c:otherwise>
        <div style="border:3px solid red; color: white">
            </c:otherwise>
            </c:choose>
            <a href="${pageContext.request.contextPath}/result/${s.id}">
                <h4>${quizTypes[s.quizTypeId]} ${s.startTime}</h4>
            </a>
        </div>
        <br>

        </c:forEach>

    </div>
</body>
</html>
