'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:AlertCtrl
 * @description
 * # AlertCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('AlertCtrl', function ($scope, $rootScope){
    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    $scope.alerts = [];

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    $scope.addAlert = function(type, msg) {
      $scope.alerts.push({ type: type, msg: msg });
    };

    $scope.closeAlert = function(index) {
      $scope.alerts.splice(index, 1);
    };

    /**
     * @ngdoc event
     * @name alert
     * @description alert event to add alert in header of app
     * @param type String [danger|warning|success] default warning
     * @param msg String
     * # Alert event
     * $rootScope.$broadcast('alert', params);
     */
    $rootScope.$on('alert', function(event, type, msg) {
      $scope.addAlert(type, msg);
    });

  });
