'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:MySectionCtrl
 * @description
 * # MySectionCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('MySectionCtrl', function ($rootScope, $location) {
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
