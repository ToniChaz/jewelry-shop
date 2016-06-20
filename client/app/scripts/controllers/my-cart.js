'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:MyCartCtrl
 * @description
 * # MyCartCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('MyCartCtrl', function ($scope, $rootScope, $location, Cart) {
    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    $rootScope.user.cart = {};

    Cart.get($rootScope.userId).then(function (response) {
      $rootScope.user.cart = response;
    });

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    function isLogged(){
      if(!$rootScope.isLogged){
        $location.path('/login');
      }
    }

    $scope.delete = function(product){

      var userCart = $rootScope.user.cart;

      for (var i = 0; i < userCart.products.length; i++){
        if (userCart.products[i].id === product.id) {
          $rootScope.user.cart.products.splice(i, 1);
          break;
        }
      }
      Cart.update($rootScope.userId, $rootScope.user.cart).then(function(response){
        $rootScope.$broadcast('alert', 'success', 'Your cart has been updated successfully.');
        $rootScope.user.cart = response;
      });

    };

    $scope.pay = function(){
      Cart.delete($rootScope.userId).then(function(){
        $rootScope.$broadcast('alert', 'success', 'Your order has been send successfully.');
        $rootScope.user.cart = {};
      });
    };
    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLogged();

  });

