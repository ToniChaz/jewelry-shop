'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:HomeCtrl
 * @description
 * # HomeCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('HomeCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
    $scope.images = [];
    $scope.imgNews = 'http://lorempixel.com/350/250/nature/1';
    $scope.imgOffers = 'http://lorempixel.com/350/250/nature/2';
    $scope.imgTopSales = 'http://lorempixel.com/350/250/nature/3';


    function addImagesToCarousel(){
      for (var i=0; i<5; i++){
        $scope.images.push('http://lorempixel.com/920/350/nature/' + i);
      }
    }

    addImagesToCarousel();

  });
