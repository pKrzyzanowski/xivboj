<%@ taglib prefix="spring" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
    <script	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>
</head>
<body>
<section class="container" data-ng-app="cartApp">
<p>${competition.name}</p>
<p data-ng-controller="cartCtrl">
    <a href="#" data-ng-click="addToCart('${competition.competitionId}')"> zamow teraz</a>
    <a href="<spring:url value="/competitions"/>"> przejdz to konkurencji</a>
    <a href="<spring:url value="/cart"/>"> koszyk</a>

</p>
</section>


</body>
</html>
