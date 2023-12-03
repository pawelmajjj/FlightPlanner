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
<div id="formDiv" style="height:33vw">
    <div id="formHeader">
        <p>Found flights:</p>
    </div>
    <div id="formMain" style="height:30vw; overflow:scroll; padding-top:0vw">
        <c:choose>
            <c:when test="${!empty foundFlights}">
                <c:forEach items="${foundFlights}" var="flight">
                    <div class="planClass" style="width:100%; height:15vw; border-bottom:0.1vw black solid;">
                        <form:form method="POST" action="/flight/found/${currentPlan}/${flight.id}">
                            <br/>
                            <p style="text-align: left; margin-top:0vw; margin-left:3vw; color:blue; font-size:1.2vw; width:100%;">
                                <b>${flight.id}</b></p>
                            <p style="text-align: left; margin-left:3vw; margin-top:0vw; width:100%;"><b>Departure
                                city: </b>${flight.departureCity}</p>
                            <p style="text-align: left; margin-left:3vw; margin-top:0vw; width:100%;"><b>Destination
                                city: </b>${flight.destinationCity}</p>
                            <p style="text-align: left; margin-left:3vw; margin-top:0vw; width:100%;"><b>Departure
                                date: </b>${flight.travelDate}</p>
                            <p style="text-align: left; margin-left:3vw; margin-top:0vw; width:100%;"><b>Departure
                                time: </b>${flight.travelTime}</p>
                            <button style="margin:0vw; margin-left:3vw; display:block; width:30%" name="action">Add your
                                plan
                            </button>
                        </form:form>
                    </div>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <form:form method="GET" action="/flight/search/${currentPlan}">
                    <div class="planClass" style="width:100%; height:13vw; border-bottom:0.1vw black solid;">
                    <br/>
                    <p style="text-align: left; margin-top:0vw; margin-left:3vw; font-size:1.2vw; width:100%;">
                        No flight found for the provided data.</p>
                    <button>Search another flight</button>
                </form:form>
                </div>
            </c:otherwise>
        </c:choose>
    </div>
</div>
</body>
</html>
