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
    <title>Register</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<div id="formDiv" style="height:38vw">
    <div id="formHeader">
        <p>Registration form:</p>
    </div>
    <div id="formMain" style="height:33vw; padding-top:2vw">
        <form:form method="POST" modelAttribute="user" action="/user/register">
            <div class="formFields">
                First name:
                <form:input path="firstName" name="firstName" style="margin-left:1vw;"/><br/>
            </div>
            <form:errors path="firstName" cssClass="error"/><br/>
            <div class="formFields">
                Last name:
                <form:input path="lastName" name="lastName" style="margin-left:1.2vw;"/><br/>
            </div>
            <form:errors path="lastName" cssClass="error"/><br/>
            <div class="formFields">
                Birthdate:
                <form:input path="birthDate" name="birthDate" placeholder="DD/MM/YYYY" style="margin-left:1.6vw;"/><br/>
            </div>
            <form:errors path="birthDate" cssClass="error"/><br/>
            <div class="formFields">
                E-mail:
                <form:input path="email" name="email" placeholder="aaa@bbb.cc" style="margin-left:3.1vw;"/><br/>
            </div>
            <form:errors path="email" cssClass="error"/><br/>
            <div class="formFields">Password:
                <form:input path="password" type="password" style="margin-left:1.6vw;"/><br/>
            </div>
            <form:errors path="password" cssClass="error"/><br/>
            <button style="margin-left:7vw">Register</button>
            <c:if test='${!empty sessionScope.get("errorMessage")}'>
                <p style="color:red; font: 1vw red bold Verdana; margin-top:2vw;">${sessionScope.get("errorMessage")}</p>
            </c:if>
        </form:form>
    </div>
</div>
</body>
</html>
