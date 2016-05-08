'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.logout
 * @description
 * # logout
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('logout', function () {
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
