'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:ShopCtrl
 * @description
 * # ShopCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('ShopCtrl', function ($scope, Product) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    Product.get().then(function (response) {
      $scope.products = response;
    });

  });
