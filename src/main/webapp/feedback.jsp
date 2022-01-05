<%--
  Created by IntelliJ IDEA.
  User: jincheng
  Date: 1/4/22
  Time: 1:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="navbar.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>QuizLand</title>
</head>
<body>

<h1 class="text-center">Give us a feedback</h1>

<div class="container">
    <form method="POST" action="/feedback">

        <div class="form-group">
            <label for="quizType">Feedback</label>
            <select class="form-control" id="quizType" name="quizType" rows="5">
                <c:forEach items="${quizTypes}" var="t">
                    <option value="${t.id}">${t.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label for="description">Feedback</label>
            <textarea class="form-control" id="description" name="description" rows="5">
            </textarea>
        </div>


        <div class="text-center">
            <button type="submit" class="btn btn-primary">Submit</button>

        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>

</div>

</body>
</html>
