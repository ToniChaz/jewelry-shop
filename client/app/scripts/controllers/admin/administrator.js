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
    function isLoggedAndAdministrator() {
      if (!$rootScope.isLogged && !$rootScope.isAdministrator) {
        $location.path('/login');
      }
    }

    Administrator.getAll().then(function (response) {
      $scope.administrators = response;
    });

    $scope.addAdministrator = function (data) {
      Administrator.add(data).then(function (response) {
        $scope.administrators.push(response);
      });
    };

    $scope.editAdministrator = function (data) {
      Administrator.update(data.id, data).then(function (response) {
        $scope.administrators.splice(data.index, 1, response);

      });
    };

    $scope.deleteAdministrator = function (data) {
      Administrator.delete(data.id).then(function () {
        $scope.administrators.splice(data.index, 1);
      });
    };

    $scope.openModal = function (size, action, userData, index) {
      if (userData) {
        userData.index = index;
      }
      $scope.$broadcast('modal', size, action, userData, function (data) {
        $scope[action](data);
      });
    };
    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLoggedAndAdministrator();

  });

