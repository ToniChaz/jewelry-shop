'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.user
 * @description
 * # user
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('user', function () {
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
