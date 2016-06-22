'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:AdminProductCtrl
 * @description
 * # AdminProductCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('AdminProductCtrl', function ($scope, $rootScope, $location, Product) {
    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    function isLoggedAndAdministrator(){
      if(!$rootScope.isLogged && !$rootScope.isAdministrator){
        $location.path('/login');
      }
    }

    Product.getAll().then(function (response) {
      $scope.products = response;
    });

    $scope.addProduct = function (data) {
      Product.add(data).then(function (response) {
        $rootScope.$broadcast('alert', 'success', 'The product has been successfully deleted.');
        $scope.products.push(response);
      });
    };

    $scope.editProduct = function (data) {
      Product.update(data.id, data).then(function (response) {
        $rootScope.$broadcast('alert', 'success', 'The product has been successfully deleted.');
        $scope.products.splice(data.index, 1, response);
      });
    };

    $scope.deleteProduct = function (data) {
      Product.delete(data.id).then(function () {
        $rootScope.$broadcast('alert', 'success', 'The product has been successfully deleted.');
        $scope.products.splice(data.index, 1);
      });
    };

    $scope.openModal = function (size, action, productData, index) {
      if (productData) {
        productData.index = index;
      }
      $scope.$broadcast('modal', size, action, productData, function (data) {
        $scope[action](data);
      });
    };
    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLoggedAndAdministrator();

  });
