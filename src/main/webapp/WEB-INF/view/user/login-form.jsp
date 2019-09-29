<%--
  Created by IntelliJ IDEA.
  User: Andrus
  Date: 27.07.2019
  Time: 19:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Sisselogimine</title>
    <style><%@include file="/resources/css/style.css"%></style>

    <link type="text/css" rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>
<body style="background-image:
        url('${pageContext.request.contextPath}/resources/img/login-background.jpeg');
        background-size: 100%;">


<form:form id="loginForm" action="${pageContext.request.contextPath}/authenticate" modelAttribute="loginForm" >
    <h2>Sisselogimine</h2>
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

    <button type="submit" class="btn">Logi sisse</button>
    <a href="/registration/show">Registreeri kasutajaks</a>
</form:form>


</body>
</html>
