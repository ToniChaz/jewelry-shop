'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:LoginCtrl
 * @description
 * # LoginCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('LoginCtrl', function ($scope, $rootScope, $location, Access) {
    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    function isLogged(){
      if($rootScope.isLogged){
        $location.path('/');
      }
    }

    $scope.login = function(loginData){
      if(!loginData || !loginData.email || !loginData.password){
        $rootScope.$broadcast('alert', 'danger', 'E-mail or password they may not be empty');
        return false;
      }
      Access.login(loginData).then(function(){
        $location.path('/');
      });
    };

    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLogged();
  });
