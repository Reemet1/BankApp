<%--
  Created by IntelliJ IDEA.
  User: Andrus
  Date: 22.08.2019
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Pangakontod</title>
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
    <li><a href="/adminhome"><i class="fa fa-home icon"></i>Pealeht</a></li>
    <li class="active"><a href="/client/showall"><i class="fa fa-home icon"></i>Kliendid</a></li>
    <li><a href="/serviceFees/show"><i class="fa fa-home icon"></i>Teenustasud</a></li>
</ul>


<div id="content" style="background-image: url('/resources/img/mainpage-background.jpg'); background-repeat: no-repeat; background-size: 100% 100%;">
    <h2>Üldinfo</h2>
    <table>
        <tr>
            <th>Kontonumber</th>
            <th>Vabad vahendid</th>
        </tr>
        <tr>
            <td>${account.accountNumber}</td>
            <td>${account.balance}</td>
        </tr>

    </table>

    <h2>Limiidid</h2>

    <c:forEach var="limit" items="${account.accountLimits}">
        <table>
            <tr>
                <th>Makse limiit</th>
                <th>Päevalimiit</th>
                <th>Kuulimiit</th>
            </tr>

            <tr>
                <td>${limit.transactionLimit}</td>
                <td>${limit.dailyLimit}</td>
                <td>${limit.monthlyLimit}</td>
            </tr>
        </table>
    </c:forEach>


</div>

<div id="footer"></div>

</body>
</html>
