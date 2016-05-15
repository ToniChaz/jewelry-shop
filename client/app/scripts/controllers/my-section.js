'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:MySectionCtrl
 * @description
 * # MySectionCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('MySectionCtrl', function ($scope, $rootScope, $location, User) {
    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    $scope.updateData = $rootScope.user;
    $scope.updateData.firstName = $rootScope.user.name;

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    function isLogged(){
      if(!$rootScope.isLogged){
        $location.path('/login');
      }
    }

    $scope.update = function(updateData){
      if(!updateData || !updateData.firstName || !updateData.surname || !updateData.email || !updateData.password || !updateData.address || !updateData.bankAccount){
        $rootScope.$broadcast('alert', 'danger', 'All data is required to register as client or your e-mail is invalid.');
        return false;
      }

      updateData.name = updateData.firstName;

      User.update($rootScope.userId, updateData).then(function(response){
        angular.extend($rootScope.user, response);
        updateData.firstName = $rootScope.user.name;
        $rootScope.$broadcast('alert', 'success', 'Your data has been updated successfully.');
      });
    };

    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLogged();

  });
