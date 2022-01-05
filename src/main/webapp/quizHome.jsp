<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>

<html>
<head>
    <title>QuizLand</title>
</head>
<body>
<%@ include file="navbar.jsp" %>
<h1 class="text-center">Taking quiz</h1>
<h1 id="timer" class="text-center" style="height: 80px"></h1>
<div class="container w-50">
    <div class="row">
        <c:forEach items="${questions}" var="q" varStatus="loop">
            <a style="color: white" href="${pageContext.request.contextPath}/quiz/${quizId}?index=${loop.index}">
                <c:choose>
                    <c:when test="${currIndex == loop.index}">
                        <div class="col-sm-3"
                             style="background-color: #1eb71e; border: 2px white solid">${loop.index + 1}</div>
                    </c:when>
                    <c:when test="${answered.contains(loop.index)}">
                        <div class="col-sm-3"
                             style="background-color: #cc984a; border: 2px white solid">${loop.index + 1}</div>
                    </c:when>
                    <c:when test="${currIndex != loop.index}">
                        <div class="col-sm-3"
                             style="background-color: #3a9cd2; border: 2px white solid">${loop.index + 1}</div>
                    </c:when>

                    <%--                     <c:if test="${answerId != null}">style="background-color: #083405; border: 2px white solid" </c:if>--%>
                </c:choose>
            </a>
        </c:forEach>
    </div>
    <div class="row">
        <h3>${question.description}</h3>
    </div>

    <form method="POST" action="${pageContext.request.contextPath}/report">
        <c:forEach items="${choices}" var="choice" varStatus="loop">
            <div class="form-check">
                <h4>
                    <input class="form-check-input" type="radio" name="input" id="flexRadio${loop.index}"
                           value="${choice.id}" <c:if test="${answerId == choice.id}">checked </c:if>>
                    <label class="form-check-label" for="flexRadio${loop.index}">
                            ${choice.description}
                    </label>
                </h4>
            </div>
        </c:forEach>

        <c:if test="${currIndex > 0}">
            <button class="btn btn-primary" type="submit" name="action" value="prev">Previous</button>
        </c:if>

        <c:if test="${currIndex < questions.size() - 1}">
            <button class="btn btn-primary" type="submit" name="action" value="next">Next</button>
        </c:if>
        <button class="btn btn-danger" type="submit" name="action" value="submit">Submit</button>
        <button hidden type="submit" name="action" value="submit" id="hiddenBtn">Submit</button>
    </form>
</div>
</body>

<script>

    //confirm btn
    function confirmFun() {
        confirm("Are you sure?")
    }

    // Set the date we're counting down to
    var countDownDate = new Date("${timer}").getTime();
    console.log(countDownDate);
    // Update the count down every 1 second
    var x = setInterval(function () {

        // Get today's date and time
        var now = new Date().getTime();

        // Find the distance between now and the count down date
        var distance = countDownDate - now;

        // Time calculations for days, hours, minutes and seconds
        var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
        var seconds = Math.floor((distance % (1000 * 60)) / 1000);

        // Output the result in an element with id="demo"
        document.getElementById("timer").innerHTML = minutes + "m " + seconds + "s ";

        // If the count down is over, write some text
        if (distance < 0) {
            clearInterval(x);
            document.getElementById("hiddenBtn").click();
            document.getElementById("timer").innerHTML = "EXPIRED";
        }
    }, 1000);
</script>
</html>
