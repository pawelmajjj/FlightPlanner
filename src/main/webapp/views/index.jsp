<%--
  Created by IntelliJ IDEA.
  User: paolo
  Date: 18.11.2023
  Time: 12:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<html>
<head>
    <title>FlightPlanner</title>
    <style>
        #homeDiv p {
            text-align: center;
            font: 3vw Verdana;
            font-style: italic;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div id="homeDiv">
    <c:if test='${empty sessionScope.get("loggedUser")}'>
        <p>Zaplanuj swoje wymarzone wakacje!!!</p>
    </c:if>

    <c:if test='${!empty sessionScope.get("loggedUser")}'>
        <p>Zalogowany, "${loggedUser.email}"!</p>
    </c:if>

</div>
</body>
</html>
