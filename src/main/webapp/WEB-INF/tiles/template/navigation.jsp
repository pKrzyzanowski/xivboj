<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>

        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">

                <li><a href="<spring:url value="/"/>"><spring:message code="navigation.home"/></a></li>
                <li><a href="<spring:url value="/competitions"/>"><spring:message code="navigation.competitions"/></a></li>
                <li><a href="<spring:url value="/people"/> "><spring:message code="navigation.competitors"/></a></li>
                <li><a href="#"><spring:message code="navigation.votingResults"/></a></li>
                <li><a href="<spring:url value="/competitions/add"/> "><spring:message code="navigation.addCompetition"/></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="<c:url value="/j_spring_security_logout"/> "><spring:message code="navigation.logIn"/></a></li>
                <li><a href="<spring:url value="/cart"/>"><span class="glyphicon glyphicon-user"></span><spring:message code="navigation.myVotes"/></a></li>
            </ul>
        </div>
    </div>
</nav>