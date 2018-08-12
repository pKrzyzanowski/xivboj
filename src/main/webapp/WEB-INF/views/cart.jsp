<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>
</head>
<body>

<section class="container" data-ng-app="cartApp">
    <div data-ng-controller="cartCtrl" data-ng-init="initCartId('${cartId}')">
        <a class="btn btn-danger" data-ng-click="cleanCart()">
            wyczysc koszyk
        </a>
        <a href="#">
            kupuje
        </a>
    </div>


    <table class="table table-hover">

        <tr>
            <th>konkurencja</th>
        </tr>
        <tr data-ng-repeat="item in cart.cartItems">
            <td>{{item.competition.name}}</td>
            <td>
                <a href="#" data-ng-click="removeFromCart(item.competition.competitionId)">usun</a>
            </td>
        </tr>
    </table>
    <a href="<spring:url value="/competitions" />" class="btn btndefault">
        <span class="glyphicon-hand-left glyphicon"></span> Wróć do konkurencji
    </a>
</section>
</body>
</html>
