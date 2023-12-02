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

<div id="formDiv" style="height:12vw">
    <div id="formHeader">
        <p>Add a new travel plan:</p>
    </div>
    <div id="formMain" style="height:7vw; padding-top:2vw">
        <form:form method="POST" action="/plan/list">
        Plan "${travelPlan.name}" successfully removed!<br /><br />
        <button style="margin-left:0vw" >Return to my plans.</button>
        </form:form>
    </div>
</div>

</body>
</html>
