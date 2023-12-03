<%--
  Created by IntelliJ IDEA.
  User: paolo
  Date: 26.11.2023
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="header.jsp" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div id="formDiv" style="height:22vw">
    <div id="formHeader">
        <p>Add a new travel plan:</p>
    </div>
    <div id="formMain" style="height:17vw; padding-top:2vw">
        <form:form method="POST" modelAttribute="travelPlanDto" action="/plan/edit/${travelPlan.id}">
            <div class="formFields">
                Plan name:
                <form:input path="name" name="name" value="${travelPlan.name}" style="margin-left:1vw;"/><br/>
            </div>
            <form:errors path="name" cssClass="error"/><br/>
            <div class="formFields">
                From:
                <form:input path="startDate" name="startDate" value="${travelPlan.startDate}" placeholder="DD/MM/YYYY"
                            style="margin-left:3.6vw;"/><br/>
            </div>
            <form:errors path="startDate" cssClass="error"/><br/>
            <button style="margin-left:7vw">Save a plan</button>
        </form:form>
        <form:form action="/plan/removed/${travelPlan.id}">
            <button style="margin-left:7vw" name="action" value="remove">Remove this plan</button>
        </form:form>
    </div>
</div>

</body>
</html>
