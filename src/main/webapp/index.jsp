<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ include file="navbar.jsp" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ page session="false" %>

    <title>QuizLand</title>
</head>
<body>
<h1 class="text-center">Welcome to QuizLand</h1>
<div class="container">
    <div class="row">
        <c:forEach items="${quiz}" var="q">
            <div class="col-sm-4" style="display: flex; flex-direction: column;">
                <h3>${q.name}</h3>
                <div style="width: 400px;height: 400px">
                    <a href="${pageContext.request.contextPath}/quiz/${q.id}?newQuiz=1">
                        <img src="${q.image}"
                             style="object-fit: cover;height: 100%;width: 100%;">
                    </a>
                </div>
                <em>${q.description}</em>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
