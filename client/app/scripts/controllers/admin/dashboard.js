'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:AdminDashboardCtrl
 * @description
 * # AdminDashboardCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('AdminDashboardCtrl', function ($scope, $rootScope, $location) {
    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    $scope.labelsSells = ["January", "February", "March", "April", "May", "June", "July"];
    $scope.seriesSells = ['Gold Ring', 'Platinum Ring'];
    $scope.dataSells = [
      [65, 59, 80, 81, 56, 55, 40],
      [28, 48, 40, 19, 86, 27, 90]
    ];
    $scope.labelsClients = ['2010', '2011', '2012', '2013', '2014', '2015', '2016'];
    $scope.seriesClients = ['John Demo', 'Erika Johnson'];
    $scope.dataClients = [
      [65, 59, 80, 81, 56, 55, 40],
      [28, 48, 40, 19, 86, 27, 90]
    ];

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

