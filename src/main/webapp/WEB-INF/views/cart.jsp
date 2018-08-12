
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.0.1/angular.min.js"></script>
    <script src="/resources/js/controllers.js"></script>
</head>
<body>

<section class="container" ng-app="cartApp">
    <div ng-controller="cartCtrl" nginit="initCartId('${cartId}')">
        <a class="btn btn-danger" ng-click="cleanCart()">
            wyczysc koszyk
        </a>
        <a href="#" ng-click="cleanCart()">
            kupuje
        </a>
    </div>


    <table class="table table-hover">

        <tr>
            <th>konkurencja</th>
        </tr>
        <tr ng-repeat="item in cart.cartItems">
            <td>{{item.competition.name}}</td>
            <td>
                <a href="#" ng-click="removeFromCart(item.competition.competitionId)">usun</a>
            </td>
        </tr>
    </table>
    <a href="<spring:url value="/competitions" />" class="btn btndefault">
        <span class="glyphicon-hand-left glyphicon"></span> Wróć do konkurencji
    </a>
</section>
</body>
</html>
