'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.login
 * @description
 * # login
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('login', function () {
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
