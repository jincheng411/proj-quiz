<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>
<head>
    <title>QuizLand</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<h1 class="text-center">Result</h1>
<div class="container">

    <c:choose>
    <c:when test="${submission.getIsPassed() == 1}">
    <div style="background-color: green; padding: 3px 0; color: white">
        <h3 class="text-center">${correctCount} / ${questions.size()}</h3>
        <h3 class="text-center">PASSED</h3>
    </div>
    <br/>
    </c:when>
    <c:otherwise>
    <div style="background-color: red; padding: 3px 0; color: white">
        <h3 class="text-center">${correctCount} / ${questions.size()}</h3>
        <h3 class="text-center">FAIL</h3>
    </div>

    <br/>
    </c:otherwise>


    </c:choose>
    <c:forEach items="${questions}" var="q" varStatus="loop">
    <c:choose>
    <c:when test="${reportSet.get(q.id).selectId == reportSet.get(q.id).answerId}">
    <div style="border: 3px green solid; margin-bottom: 5px">
        </c:when>
        <c:otherwise>
        <div style="border: 5px red solid; margin-bottom: 5px">
            </c:otherwise>
            </c:choose>
            <h3>${loop.index + 1}. ${q.description}</h3>
            <c:forEach items="${choiceList.get(q.id)}" var="choice" varStatus="loop2">
                <c:choose>
                    <c:when test="${choice.id == reportSet.get(q.id).selectId
                && reportSet.get(q.id).selectId != reportSet.get(q.id).answerId}">
                        <h5 class="text-danger font-weight-bold">${arr[loop2.index]}. ${choice.description}</h5>
                    </c:when>
                    <c:when test="${choice.id == reportSet.get(q.id).selectId
                && reportSet.get(q.id).selectId == reportSet.get(q.id).answerId}">
                        <h5 class="text-success font-weight-bold">${arr[loop2.index]}. ${choice.description}</h5>
                    </c:when>
                    <c:when test="${choice.id == reportSet.get(q.id).answerId}">
                        <h5 class="text-success font-weight-bold">${arr[loop2.index]}. ${choice.description}</h5>
                    </c:when>
                    <c:otherwise>
                        <h5 class="font-weight-bold">${arr[loop2.index]}. ${choice.description}</h5>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>

        </c:forEach>


    </div>

</body>
</html>
