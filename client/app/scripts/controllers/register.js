'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:RegisterCtrl
 * @description
 * # RegisterCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('RegisterCtrl', function ($scope, $rootScope, $location, User, Access) {
    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    function isLogged(){
      if($rootScope.isLogged){
        $location.path('/');
      }
    }

    $scope.register = function(registerData){
      if(!registerData || !registerData.name || !registerData.surname || !registerData.email || !registerData.password || !registerData.address || !registerData.bankAccount){
        $rootScope.$broadcast('alert', 'danger', 'All data is required to register as client or your e-mail is invalid.');
        return false;
      }

      delete registerData.terms;

      User.add(registerData).then(function(response){
        Access.login(response).then(function(){
          $rootScope.$broadcast('alert', 'success', 'Welcome to the Jewelry Shop! Your registration process has been completed successfully.');
          $location.path('/');
        });
      });
    };

    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLogged();
  });
