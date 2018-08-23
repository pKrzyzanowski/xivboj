<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>
</head>
<body>
<section class="container" ng-app="cartApp">
<p>${competition.name}</p>
<p data-ng-controller="cartCtrl">

    <img src="<c:url value="/resource/images/${competition.competitionId}.jpg"></c:url> " alt="image" style="width: 300px"/>
    <a href="#" ng-click="addToCart('${competition.competitionId}')"> zamow teraz</a>
    <a href="<spring:url value="/competitions"/>"> przejdz to konkurencji</a>
    <a href="<spring:url value="/cart"/>"> koszyk</a>

</p>
</section>


</body>
</html>
