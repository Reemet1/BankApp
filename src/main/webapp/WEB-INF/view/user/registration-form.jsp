<%--
  Created by IntelliJ IDEA.
  User: Andrus
  Date: 27.07.2019
  Time: 21:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Registreerimine</title>
    <style><%@include file="/resources/css/style.css"%></style>
    <link type="text/css" rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>

<body style="background-image:
        url('${pageContext.request.contextPath}/resources/img/login-background.jpeg');
        background-size: 100%;">


<form:form id="registrationForm" action="${pageContext.request.contextPath}/registration/confirm" modelAttribute="registrationForm" >
    <h2>Registreerimine</h2>

    <div class="input-container">
        <i class="fa fa-user icon"></i>
        <input class="input-field" type="text" placeholder="Eesnimi" name="firstName">
        <form:errors path="firstName"></form:errors>
    </div>

    <div class="input-container">
        <i class="fa fa-user icon"></i>
        <input class="input-field" type="text" placeholder="Perenimi" name="lastName">
        <form:errors path="lastName"></form:errors>
    </div>

    <div class="input-container">
        <i class="fa fa-envelope icon"></i>
        <input class="input-field" type="text" placeholder="Email" name="email">
        <form:errors path="email"></form:errors>
    </div>

    <div class="input-container">
        <i class="fa fa-user icon"></i>
        <input class="input-field" type="text" placeholder="Kasutajanimi" name="username">
        <form:errors path="username"></form:errors>
    </div>

    <div class="input-container">
        <i class="fa fa-lock icon"></i>
        <input class="input-field" type="password" placeholder="Parool" name="password">
        <form:errors path="password"></form:errors>
    </div>

    <button type="submit" class="btn">Registreeri</button>
</form:form>


</body>
</html>
