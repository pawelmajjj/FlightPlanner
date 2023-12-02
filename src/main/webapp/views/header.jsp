<%--
  Created by IntelliJ IDEA.
  User: paolo
  Date: 25.11.2023
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8"/>
    <style>
        body {
            padding: 0;
            margin: 0;
            font-family: Verdana;
        }

        .navbar {
            overflow: hidden;
            color: black;
            background-color: powderblue;
        <c:if test='${empty sessionScope.get("loggedUser")}'>
            width: 29vw;
            margin-left: 20vw;
        </c:if><c:if test='${!empty sessionScope.get("loggedUser")}'>
            width: 43.5vw;
            margin-left: 20vw;
        </c:if>
            text-align: left;
            font-weight: bold;

            border: 0.1vw black solid;
        }

        .navbar a {
            float: left;
            font: 1vw black bold;
            background-color: inherit;
            padding: 0.6vw 1.2vw;
            width: 12vw;
            text-decoration: none;
        }

        .dropdown {
            float: left;
        }

        .dropdown .dropButton {
            font-size: 1vw;
            outline: none;
            padding: 0.6vw 1.2vw;
            width: 12vw;
            background-color: inherit;
            margin: 0;
        }

        .dropdown a {
            background-color: inherit;
        }

        .navbar a:hover, .dropdown:hover .dropButton {
            background-color: lightgray;
        }

        .dropdown-content {
            display: none;
            position: absolute;
            width: 12vw;
            background-color: skyblue;
            z-index: 1;
        }

        .dropdown-content a {
            width: inherit;
            text-decoration: none;
            display: block;
            border: 0.1vw black solid;
        }

        .dropdown-content a:hover {
            background-color: gray;
        }

        .dropdown:hover .dropdown-content {
            display: block;
        }

        #formDiv {
            margin-left: 35%;
            margin-top: 2vw;
            text-align: center;
            width: 30%;
            border: 0.2vw black solid;
        }

        #formHeader {
            height: 2.9vw;
            font-size: 1.2vw;
            font-weight: bold;
            background-color: lightskyblue;
            border-bottom: 0.1vw black solid;
        }

        #formHeader p {
            margin: 0;
            padding-top: 0.7vw;
        }

        #formDiv label, input {
            font-size: 1vw;
            width: 15vw;
            height: 1.6vw;
            margin-bottom: 1vw;
        }

        .formFields {
            display: block;
            width: 100%;
            text-align: left;
            font: 1vw black;
            margin-left: 4vw;
        }


        #formDiv button {
            margin-top: 0.5vw;
            font-size: 1vw;
            width: 15vw;
            height: 2vw;
        }

        #formDiv input {
            font-size: 0.8vw;
        }

        #formMain {
            background-color: whitesmoke;
            width: 100%;
        }


        .error {
            display: block;
            font: 0.7vw red;
            text-align: left;
            padding-top: -15vw;
            margin-top: 0vw;
            margin-left: 4vw;
            color: red;
        }


    </style>
</head>
<body>
<header class="page-header">
    <div class="navbar">
        <div class="dropdown" style="border-right:0.1vw black solid">
            <a href="/">FlightPlanner</a>
            <i class="fa fa-caret-down"></i>
        </div>
        <c:if test='${empty sessionScope.get("loggedUser")}'>
        <div class="dropdown">
            <div class="dropButton">Login/register
                <i class="fa fa-caret-down"></i>
            </div>
            <div class="dropdown-content">
                <a href="/user/register">Register</a>
                <a href="/user/login">Login</a>
            </div>
        </div>
        </c:if>
        <c:if test='${!empty sessionScope.get("loggedUser")}'>
      <!--  <div class="dropdown">
            <div class="dropButton" style="border-right:0.1vw black solid">My flights
                <i class="fa fa-caret-down"></i>
            </div>
            <div class="dropdown-content">
                <a href="/flight/add">See my flights</a>
                <a href="/flight/search">Find a new flight</a>
            </div>
        </div>-->
        <div class="dropdown">
            <div class="dropButton" style="border-right:0.1vw black solid">My plans
                <i class="fa fa-caret-down"></i>
            </div>
            <div class="dropdown-content">
                <a href="/plan/list">See my plans</a>
                <a href="/plan/add">Add a new plan</a>
            </div>
        </div>
        <div class="menu-button">
            <a href="/user/logout">Logout</a>
        </div>
        </c:if>

</header>
</body>
</html>
