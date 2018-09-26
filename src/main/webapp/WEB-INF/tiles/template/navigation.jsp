<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-2" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>



        <%
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            String currentPrincipalName = authentication.getName();
        %>
        <c:set var="userName" value="<%= currentPrincipalName %>"/>
        <c:set var="anonymousUser" value="anonymousUser"/>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">

                <li><a href="<spring:url value="/"/>">G³ówna</a></li>
                <li><a href="<spring:url value="/competitions"/>">Konkurencje</a></li>
                <li><a href="<spring:url value="/people"/> ">Uczestnicy</a></li>
                <li><a href="<spring:url value="/results"/>">Wyniki g³osowania</a></li>
                <li><a href="<spring:url value="/competitions/add"/> ">Dodaj konkurencjê</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

                        <c:if test="${!userName.contains(anonymousUser)}">
                        <li><a href="<c:url value="/j_spring_security_logout"/> ">Wyloguj siê (<%= currentPrincipalName %>)</a></li>
                        </c:if>
                <c:if test="${userName.contains(anonymousUser)}">
                    <li><a href="<spring:url value="/competitions"/>">Zaloguj siê</a></li>
                </c:if>



                <li><a href="<spring:url value="/cart"/>"><span class="glyphicon glyphicon-user"></span>Moje g³osy</a></li>
            </ul>
        </div>
    </div>
</nav>