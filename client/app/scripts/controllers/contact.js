'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:ContactCtrl
 * @description
 * # ContactCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('ContactCtrl', function ($scope, $rootScope) {
    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    $scope.register = function (contactData) {
      if (!contactData || !contactData.firstName || !contactData.email || !contactData.subject || !contactData.message) {
        $rootScope.$broadcast('alert', 'danger', 'All data is required to sed de form or your e-mail is invalid.');
        return false;
      }

      $rootScope.$broadcast('alert', 'success', 'Your message has been successfully submitted. We will contact you as soon as possible.');
      $scope.contactData = {};

    };
  });
