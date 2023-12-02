<%--
  Created by IntelliJ IDEA.
  User: paolo
  Date: 26.11.2023
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div id="formDiv" style="height:25vw">
    <div id="formHeader">
        <p>Find a new flight:</p>
    </div>
    <div id="formMain" style="height:20vw; padding-top:2vw">
        <h4 style="margin:0; padding:0;">Choose two cities to find if there's a connection.</h4><br/>
        <form:form method="POST" modelAttribute="flightDto" action="/flight/search/${planId}">
            <div class="formFields">
                From:
                <c:choose>
                    <c:when test='${empty sessionScope.get("departureCity")}'>
                        <form:select name="departureCity" path="departureCity" style="width:15vw; margin-left:2.7vw;">
                            <c:forEach items='${sessionScope.get("cityNames")}' var="city">
                                <option value="${city}">${city}</option>
                            </c:forEach>
                        </form:select>
                    </c:when>
                    <c:otherwise>
                        <c:out value='${sessionScope.get("departureCity")}'/>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="formFields">

                <c:choose>
                    <c:when test='${empty sessionScope.get("departureCity")}'>
                        <h5>Choose the departure city!</h5>
                    </c:when>
                    <c:otherwise>
                        <br/>
                        To:
                        <c:if test='${empty sessionScope.get("arrivalCity")}'>
                            <form:select id="arrivalCity" name="arrivalCity" path="arrivalCity"
                                         style="width:15vw; margin-left:4.2vw;">
                                <c:forEach items='${sessionScope.get("cityNames")}' var="city">
                                    <c:if test='${city !=  sessionScope.get("departureCity")})}'>
                                        <option value="${city}">${city}</option>
                                    </c:if>
                                </c:forEach>
                            </form:select>
                        </c:if>
                        <c:if test='${empty sessionScope.get("departureCity")}'>
                            <c:out value='${sessionScope.get("arrivalCity")}'/>
                        </c:if>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="formFields">
            <c:choose>
                <c:when test='${empty sessionScope.get("arrivalCity") && empty sessionScope.get("departureCity")}'>
                    <h5>Choose the arrival city!</h5>
                </c:when>
                <c:otherwise>
                    <br/>
                    <c:if test='${!empty sessionScope.get("arrivalCity")}'>

                        Date:
                        <form:input type="text" name="departureDate" path="departureDate" placeholder="DD/MM/YYYY"
                                    style="margin-left:3vw;"/>
                    </c:if>
                    <c:if test='${!empty sessionScope.get("departureDate")}'>
                        <c:out value='${sessionScope.get("departureDate")}'/>
                    </c:if>
                    </div>
                    <form:errors path="departureDate" cssClass="error"/>
                </c:otherwise>
            </c:choose>
            <div class="formFields">
                <c:if test='${empty sessionScope.get("departureDate") && !empty sessionScope.get("arrivalCity")}'>
                    <h5>Choose the departure date!</h5>
                </c:if>
            </div>
            <button style="margin-left:5vw">Search</button>

        </form:form>
        <c:if test='${!empty sessionScope.get("departureCity")}'>
            <!-- <form method="GET" action="/flight/resetForm/{planId}">
            <button width="15vw">Restart searching</button>
            </form>-->
        </c:if>

    </div>
</div>
</body>
</html>
