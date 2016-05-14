'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:HeaderCtrl
 * @description
 * # HeaderCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('HeaderCtrl', function ($scope, $location) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];

    $scope.isActive = function (viewLocation) {
      return viewLocation === $location.path();
    };
  });
