'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:HeaderCtrl
 * @description
 * # HeaderCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('HeaderCtrl', function ($scope, $rootScope, $location, Access) {
    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    $scope.isActive = function (viewLocation) {
      return viewLocation === $location.path();
    };

    $scope.login = function(loginData){
      if(!loginData || !loginData.email || !loginData.password){
        $rootScope.$broadcast('alert', 'danger', 'E-mail or password they may not be empty');
        return false;
      }
      Access.login(loginData);
    };

    $scope.logout = function(){
      Access.logout();
    };
  });
