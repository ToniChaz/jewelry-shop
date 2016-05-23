'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.administrator
 * @description
 * # administrator
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('Administrator', function (Interceptor) {
    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    var Administrator = {};

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    Administrator.getAll = function () {

      var request = {
        method: 'GET',
        url: '/administrator'
      };
      return Interceptor.call(request);
    };

    Administrator.get = function (userId) {

      var request = {
        method: 'GET',
        url: '/administrator/' + userId
      };
      return Interceptor.call(request);
    };

    Administrator.add = function (registerData) {

      var request = {
        method: 'POST',
        url: '/administrator',
        data: registerData
      };
      return Interceptor.call(request);
    };

    Administrator.update = function (userId, userData) {

      var request = {
        method: 'PUT',
        url: '/administrator/' + userId,
        data: userData
      };
      return Interceptor.call(request);
    };

    Administrator.delete = function (userId) {

      var request = {
        method: 'DELETE',
        url: '/administrator/' + userId
      };
      return Interceptor.call(request);
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return Administrator;

  });
