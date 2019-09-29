<%--
  Created by IntelliJ IDEA.
  User: Andrus
  Date: 22.08.2019
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Laenud</title>
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
    <li class="active"><a href="/loans/show"><i class="fa fa-suitcase icon"></i>Laenud</a></li>
    <li><a href="/documents/show"><i class="fa fa-credit-card icon"></i>Lepingud</a></li>
    <li><a href="/client/showdetails/"><i class="fa fa-address-card icon"></i>Profiil</a></li>
</ul>


<div id="content" style="background-image: url('/resources/img/loan-background.jpg'); background-repeat: no-repeat; background-size: 100% 100%;">

    <table>
        <tr>
            <th>Laenu tüüp</th>
            <th>Laenusumma</th>
            <th>Intress</th>
            <th>Tagasimakse aeg</th>
            <th>Tagasimakstav summa</th>
            <th>Kuumakse</th>
            <th>Algus kuupäev</th>
            <th>Lõppkuupäev</th>
        </tr>


        <c:forEach var="loan" items="${loans}">
            <tr>
                <td>${loan.type}</td>
                <td>${loan.loanAmount}</td>
                <td>${loan.interestRate}</td>
                <td>${loan.totalPaybackTime}</td>
                <td>${loan.paybackAmount}</td>
                <td>${loan.monthlyPaymentAmount}</td>
                <td>${loan.startDate}</td>
                <td>${loan.endDate}</td>
            </tr>
        </c:forEach>

    </table>

    <br/><br/>

    <form:form action="${pageContext.request.contextPath}/loans/take" modelAttribute="loan">

        Laenutüüp:
        <form:select path="type">
            <form:option value="consumer_loan">Väikelaen</form:option>
            <form:option value="car_loan">Autolaen</form:option>
            <form:option value="home_loan">Kodulaen</form:option>
        </form:select>

        <br/><br/>

        Laenusumma: <form:input path="loanAmount" />
        <form:errors path="loanAmount"></form:errors>
        <br/><br/>

        Tagasimakse aeg (kuud): <form:input path="totalPaybackTime" />
        <form:errors path="totalPaybackTime"></form:errors>
        <br/><br/>

        <input type="submit" value="Submit" />

    </form:form>

</div>

<div id="footer"></div>

</body>
</html>
