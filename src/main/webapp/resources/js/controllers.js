var cartApp = angular.module('cartApp', []);

cartApp.controller('cartCtrl',  function ($scope, $http) {

    $scope.refreshCart = function(cartId) {
        $http.get('/rest/cart/'+$scope.cartId)
            .success(function(data) {
                $scope.cart = data;
            });
    };

    $scope.clearCart = function() {
        $http.delete('/rest/cart/'+$scope.cartId)
            .success($scope.refreshCart($scope.cartId));

    };

    $scope.initCartId = function(cartId) {
        $scope.cartId=cartId;
        $scope.refreshCart($scope.cartId);
    };

    $scope.addToCart = function(competitionId) {
        $http.put('/rest/cart/add/'+competitionId)
            .success(function(data) {
                $scope.refreshCart($http.get('/rest/cart/get/cartId'));
                alert("Produkt pomyślnie dodany do koszyczka!");
            });
    };
    $scope.removeFromCart = function(productId) {
        $http.put('/rest/cart/remove/'+productId)
            .success(function(data) {
                $scope.refreshCart($http.get('/rest/cart/get/cartId'));
            });
    };
});
