<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="springc" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>
</head>
<body>
<section class="container" ng-app="cartApp">
<p>${competition.name}</p>



    <img src="<c:url value="/resource/images/${competition.competitionId}.jpg"></c:url> " alt="image" style="width: 300px"/>
    <p><springc:message code="competition.rules"/> ${competition.rules}</p>
    <p><springc:message code="competition.preferedTime"/> ${competition.preferedTime} <springc:message code="competition.min"/></p>


    <p data-ng-controller="cartCtrl">
    <a href="#" ng-click="addToCart('${competition.competitionId}')"> <springc:message code="competition.voteNow"/></a>
    <a href="<spring:url value="/competitions"/>"> <springc:message code="competition.backToCompetitions"/></a>
    <a href="<spring:url value="/cart"/>"> <springc:message code="competition.toMyVotingCart"/></a>

</p>
</section>


</body>
</html>
