<%--
  Created by IntelliJ IDEA.
  User: Andrus
  Date: 22.08.2019
  Time: 18:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Kliendiandmed</title>
    <style><%@include file="/resources/css/style.css"%></style>
    <link type="text/css" rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"/>
</head>
<body>

<div id="header">

    <!--
    <form action="/logout" method='POST'>
        <input type="submit" value="Logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form> -->
</div>

<ul id="menu">
    <li><a href="/"><i class="fa fa-home icon"></i>Pealeht</a></li>
    <li><a href="/payments/show"><i class="fa fa-credit-card icon"></i>Maksed</a></li>
    <li><a href="/history/show"><i class="fa fa-list-alt icon"></i>Väljavõte</a></li>
    <li><a href="/accounts/show"><i class="fa fa-book icon"></i>Kontod</a></li>
    <li><a href="/cards/show"><i class="fa fa-credit-card icon"></i>Kaardid</a></li>
    <li><a href="/loans/show"><i class="fa fa-suitcase icon"></i>Laenud</a></li>
    <li><a href="/documents/show"><i class="fa fa-credit-card icon"></i>Lepingud</a></li>
    <li class="active"><a href="/client/showdetails/"><i class="fa fa-address-card icon"></i>Profiil</a></li>
</ul>


<div id="content">

    <form:form action="${pageContext.request.contextPath}/client/update" modelAttribute="clientDetails">

        First name: <form:input path="firstName" />
        <br/><br/>
        Last name: <form:input path="lastName" />

        <br/><br/>
        Isikukood: <form:input path="personalId" />

        <br/><br/>
        Sünniaeg: <form:input path="dateOfBirth" />

        <br/><br/>
        Aadress1: <form:input path="address1" />

        <br/><br/>
        Aadress2: <form:input path="address2" />

        <br/><br/>
        Telefon: <form:input path="phoneNumber" />

        <br/><br/>
        Email: <form:input path="email" />


        <br/><br/>

        <input type="submit" value="Submit" />

    </form:form>

</div>

<div id="footer"></div>

</body>
</html>
