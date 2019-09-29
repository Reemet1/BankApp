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
    <title>Kliendiinfo</title>
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


<div id="content">
    <h2>Üldinfo</h2>
    <table>
        <tr>
            <th>Eesnimi</th>
            <th>Peremini</th>
            <th>Email</th>
        </tr>
        <tr>
            <td>${client.clientDetails.firstName}</td>
            <td>${client.clientDetails.lastName}</td>
            <td>${client.clientDetails.email}</td>
        </tr>

    </table>

    <h2>Kontod</h2>

    <table>
        <tr>
            <th>Kontonumber</th>
            <th>Vabad vahendid</th>
        </tr>

        <c:forEach var="account" items="${client.accounts}">
            <tr>
                <td>${account.accountNumber}</td>
                <td>${account.balance}</td>
                <td><a href="/accounts/show/${account.id}">Vaata</a></td>
            </tr>
        </c:forEach>

    </table>

    <h2>Kaartid</h2>

    <table>
        <tr>
            <th>Kaarti number</th>
            <th>Seotud konto</th>
        </tr>

        <c:forEach var="card" items="${client.bankCards}">
            <tr>
                <td>${card.cardNumber}</td>
                <td>${card.account.accountNumber}</td>
            </tr>
        </c:forEach>

    </table>
</div>

<div id="footer"></div>

</body>
</html>
