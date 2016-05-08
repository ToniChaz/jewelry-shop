'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.administrator
 * @description
 * # administrator
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('administrator', function () {
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
