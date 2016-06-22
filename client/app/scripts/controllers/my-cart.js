'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:MyCartCtrl
 * @description
 * # MyCartCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('MyCartCtrl', function ($scope, $rootScope, $location, Cart, User) {
    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    function isLogged() {
      if (!$rootScope.isLogged) {
        $location.path('/login');
      } else if ($rootScope.user === undefined) {
        User.get($rootScope.userId).then(function (response) {
          $rootScope.setUserData(response);
          $scope.updateData = $rootScope.user;
          Cart.get($rootScope.userId).then(function (response) {
            $rootScope.user.cart = response;
          });
        });
      }
    }

    $scope.delete = function (product) {

      var userCart = $rootScope.user.cart;

      for (var i = 0; i < userCart.products.length; i++) {
        if (userCart.products[i].id === product.id) {
          $rootScope.user.cart.products.splice(i, 1);
          break;
        }
      }
      Cart.removeProductFromCart($rootScope.userId, product.id).then(function (response) {
        $rootScope.$broadcast('alert', 'success', 'Your cart has been updated successfully.');
        $rootScope.user.cart = response;
      });

    };

    $scope.pay = function () {
      Cart.transactionComplete($rootScope.userId).then(function (response) {
        $rootScope.$broadcast('alert', 'success', 'Your order has been send successfully.');
        $rootScope.user.cart = {};
        $rootScope.user.orders.push(response);
      });
    };
    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLogged();

  });

