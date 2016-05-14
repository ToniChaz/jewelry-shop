'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:AdminAdministratorCtrl
 * @description
 * # AdminAdministratorCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('AdminAdministratorCtrl', function ($rootScope, $location) {
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
    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLoggedAndAdministrator();

  });

