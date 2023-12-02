<%--
  Created by IntelliJ IDEA.
  User: paolo
  Date: 26.11.2023
  Time: 12:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>My plans</title>
    <style>
        .planClass:hover {
            background-color: skyblue;
        }
    </style>
</head>
<body>
<div id="formDiv" style="height:35vw">
    <div id="formHeader">
        <p>My plans:</p>
    </div>
    <div id="formMain" style="height:32vw; overflow:scroll; padding-top:0vw">
        <c:forEach items="${allPlans}" var="plan">
            <div class="planClass" style="width:100%; height:13vw; border-bottom:0.1vw black solid;">
                <form:form method="GET" action="/plan/details/${plan.id}">
                    <br/>
                    <p style="text-align: left; margin-top:0vw; margin-left:3vw; color:blue; font-size:1.2vw; width:100%;">
                        <b>${plan.name}</b></p>
                    <p style="text-align: left; margin-left:3vw; margin-top:0vw; width:100%;"><b>Departure
                        date: </b>${plan.startDate}</p>
                    <c:choose>
                        <c:when test="${null == plan.flight}">
                            <p style="text-align: left; margin-left:3vw; margin-top:0vw; width:100%;"><i>No flight added for this plan. </i> <button style=" display:block; width:30%" name="action" value="newFlight">Add a flight</button></p>
                        </c:when>
                        <c:otherwise>
                            <p style="text-align: left; margin-left:3vw; margin-top:0vw; width:100%;">Flight ${plan.flight.id} from ${plan.flight.departureCity} to
                                ${plan.flight.arrivalCity}</p>
                        </c:otherwise>
                    </c:choose>
                    <button style="margin:0vw; margin-left:3vw; display:block; width:30%" name="action" value="edit">Edit your plan</button>
                </form:form>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>
