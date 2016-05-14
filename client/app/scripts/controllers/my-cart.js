'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:MyCartCtrl
 * @description
 * # MyCartCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('MyCartCtrl', function ($rootScope, $location) {
    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    function isLogged(){
      if(!$rootScope.isLogged){
        $location.path('/login');
      }
    }
    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLogged();

  });

