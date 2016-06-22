'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:AdminUserCtrl
 * @description
 * # AdminUserCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('AdminUserCtrl', function ($scope, $rootScope, $location, User) {
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

    User.getAll().then(function (response) {
      $scope.users = response;
    });

    $scope.addUser = function (data) {
      User.add(data).then(function (response) {
        $rootScope.$broadcast('alert', 'success', 'The user has been successfully deleted.');
        $scope.users.push(response);
      });
    };

    $scope.editUser = function (data) {
      User.update(data.id, data).then(function (response) {
        $rootScope.$broadcast('alert', 'success', 'The user has been successfully deleted.');
        $scope.users.splice(data.index, 1, response);

      });
    };

    $scope.deleteUser = function (data) {
      User.delete(data.id).then(function () {
        $rootScope.$broadcast('alert', 'success', 'The user has been successfully deleted.');
        $scope.users.splice(data.index, 1);
      });
    };

    $scope.openModal = function (size, action, UserData, index) {
      if (UserData) {
        UserData.index = index;
      }
      $scope.$broadcast('modal', size, action, UserData, function (data) {
        $scope[action](data);
      });
    };
    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLoggedAndAdministrator();

  });
