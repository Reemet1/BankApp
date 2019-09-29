<%--
  Created by IntelliJ IDEA.
  User: Andrus
  Date: 22.08.2019
  Time: 10:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Dokumendid</title>
    <style><%@include file="/resources/css/style.css"%></style>
    <link type="text/css" rel="stylesheet" href="/css/bootstrap.css"/>
    <link type="text/css" rel="stylesheet" href="/css/app.css"/>
    <script type="text/javascript" src="/js/hwcrypto.js"></script>
    <script type="text/javascript" src="/js/hwcrypto-legacy.js"></script>
    <script type="text/javascript" src="/js/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="/js/jquery.form.min.js"></script>
    <script type="text/javascript" src="/js/hex2base.js"></script>
    <script type="text/javascript" src="/js/app.js"></script>
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
    <li class="active"><a href="/documents/show"><i class="fa fa-credit-card icon"></i>Lepingud</a></li>
    <li><a href="/client/showdetails/"><i class="fa fa-address-card icon"></i>Profiil</a></li>
</ul>


<div id="content">

    <a href="/documents/download">Loe dokumenti</a>.</p>

</div>




<div id="footer"></div>

</body>
</html>
