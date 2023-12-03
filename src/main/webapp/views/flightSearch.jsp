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
        <form:form method="POST" modelAttribute="searchFlight" action="/flight/search/${planId}">
            <div class="formFields">
                From:
                <form:select name="departureCity" path="departureCity" style="width:15vw; margin-left:2.7vw;">
                    <c:forEach items='${sessionScope.get("cityNames")}' var="city">
                        <option value="${city}">${city}</option>
                    </c:forEach>
                </form:select>
            </div>
            <div class="formFields">

                <br/>
                To:
                <form:select id="destinationCity" name="destinationCity" path="destinationCity"
                             style="width:15vw; margin-left:4.2vw;">
                    <c:forEach items='${sessionScope.get("cityNames")}' var="city">
                        <option value="${city}">${city}</option>
                    </c:forEach>
                </form:select>

            </div>
            <div class="formFields">
                <br />
                <form:input type="hidden" name="travelDate" value="${searchFlight.travelDate}" path="travelDate"/>
                <b>Departure date:</b> ${searchFlight.travelDate}
            </div>

            <form:errors path="travelTime" cssClass="error"/>
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
