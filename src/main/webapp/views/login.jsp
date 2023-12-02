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
    <title>Login</title>
</head>
<body>

<div id="formDiv" style="height:20vw">
    <div id="formHeader">
        <p>Login form:</p>
    </div>
    <div id="formMain" style="height:15vw; padding-top:2vw">
        <form:form method="POST" modelAttribute="user" action="/user/login">
            <div class="formFields">
                E-mail:
                <form:input path="email" name="email" placeholder="aaa@bbb.cc" style="margin-left:2vw;"/><br/>
            </div>
            <form:errors path="email" cssClass="error"/><br/>
            <div class="formFields">
                Password:
                <form:input path="password" type="password" name="password" style="margin-left:0.5vw;"/><br/>
            </div>
            <c:if test='${!empty sessionScope.get("errorMessage")}'>
                <p style="color:red; font-size: 0.8vw; padding:0; margin-left:-2vw">${errorMessage}</p>
            </c:if>
            <button style="margin-left:5vw">Login</button>

        </form:form>
    </div>
</div>
</body>
</html>
