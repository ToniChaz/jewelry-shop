'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.cart
 * @description
 * # cart
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('cart', function () {
    // Service logic
    // ...

    var meaningOfLife = 42;

    // Public API here
    return {
      someMethod: function () {
        return meaningOfLife;
      }
    };
  });
