'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.product
 * @description
 * # product
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('product', function () {
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
