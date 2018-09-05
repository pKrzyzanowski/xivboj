<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resource/js/controllers.js"></script>
</head>
<body>

<section class="container" data-ng-app="cartApp">
    <div ng-controller="cartCtrl" ng-init="initCartId('${cartId}')">

        <div>
            <a href="<spring:url value="/checkout?cartId=${cartId}"/>" class="btn btn-success pull-right"> <span
                    class="btn btn-lg btn-success btn-block"></span> <spring:message code="cart.vote"/>
            </a>
        </div>
        <table class="table table-hover">
            <tr>
                <th>Nazwa</th>

            </tr>
            <tr ng-repeat="item in cart.cartItems">
                <td>{{item.competition.name}}</td>

                <td><a href="#" class="label label-danger"
                       ng-click="removeFromCart(item.competition.competitionId)"> <span
                        class="glyphicon glyphicon-remove"></span> <spring:message code="cart.backOffVote"/>
                </a></td>
            </tr>

        </table>

        <a href="<spring:url value="/competitions" />" class="btn btn-default">
            <span class="glyphicon-hand-left glyphicon"></span> <spring:message code="cart.return"/>
        </a>
    </div>
</section>
</body>
</html>