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
    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    $scope.myInterval = 5000;
    $scope.noWrapSlides = false;
    $scope.active = 0;
    var slides = $scope.slides = [];
    var currIndex = 0;
    $scope.imgNews = 'http://lorempixel.com/350/250/nature/1';
    $scope.imgOffers = 'http://lorempixel.com/350/250/nature/2';
    $scope.imgTopSales = 'http://lorempixel.com/350/250/nature/3';

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    $scope.addSlide = function() {
      var newWidth = 920 + slides.length + 1;
      slides.push({
        image: 'http://lorempixel.com/' + newWidth + '/350/nature',
        text: ['Nice image','Awesome photograph','That is so cool','I love that'][slides.length % 4],
        id: currIndex++
      });
    };

    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    for (var i = 0; i < 5; i++) {
      $scope.addSlide();
    }

  });
