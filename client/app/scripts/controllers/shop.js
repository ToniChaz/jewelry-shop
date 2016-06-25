'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:ShopCtrl
 * @description
 * # ShopCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('ShopCtrl', function ($scope, $rootScope, Product, Cart, User) {
    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    $scope.search = '';

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    Product.getAll().then(function (response) {
      $scope.products = response;
    });

    $scope.searchCallback = function (params) {
      return Product.find(params.query);
    };

    $scope.selected = function (product) {
      $scope.singleProduct = product;
    };

    $scope.back = function(){
      $scope.search = '';
      delete $scope.singleProduct;
    };

    $scope.buy = function(productId){
      Cart.update($rootScope.userId, productId).then(function(response){
        $rootScope.$broadcast('alert', 'success', 'The product has been added in the cart correctly');
        $rootScope.user.cart = response;
      });
    };

  });
