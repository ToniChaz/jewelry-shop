'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:AdminAdministratorCtrl
 * @description
 * # AdminAdministratorCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('AdminAdministratorCtrl', function ($scope, $rootScope, $location, Administrator) {
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
    Administrator.getAll().then(function (response) {
      $scope.administrators = response;
    });

    $scope.openModal = function(size, action, userData){
      $scope.$broadcast('modal', size, action, userData);
    };
    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLoggedAndAdministrator();

  });

