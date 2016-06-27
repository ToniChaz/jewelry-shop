'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.dashboard
 * @description
 * # dashboard
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('Dashboard', function (Interceptor) {
    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    var Dashboard = {};

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/

    Dashboard.get = function () {

      var request = {
        method: 'GET',
        url: '/dashboard'
      };
      return Interceptor.call(request);
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return Dashboard;

  });

