<%--
  Created by IntelliJ IDEA.
  User: paolo
  Date: 18.11.2023
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>

<html>
<head>
    <title>Your plan</title>
</head>
<body>

<div id="formDiv" style="height:18vw">
    <div id="formHeader">
        <p>"<i><c:out value='${travelPlan.name}'/></i>" plan details</p>
    </div>
    <div id="formMain" style="height:13vw; padding-top:2vw">
        <div class="formFields">
            Plan name: <b><c:out value='${travelPlan.name}'/></b>
        </div><br />
        <div class="formFields">
            From: <b><c:out value='${travelPlan.startDate}'/></b>
        </div><br />
        <form:form style="display:block; width:100%" action="/plan/edit/${travelPlan.id}">
            <button style="display:block; margin-left:4vw; width:12vw">Edit plan</button>
        </form:form>
        <form:form method="POST" action="/plan/removed/${travelPlan.id}">
            <button style="display:block; margin-left:4vw; width:12vw">Remove plan</button>
        </form:form>
    </div>
</div>
</div>

</body>
</html>
