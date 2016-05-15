'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.User
 * @description
 * # User
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('User', function (Interceptor) {

    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    var User = {};

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    User.getAll = function () {

      var request = {
        method: 'GET',
        url: '/user'
      };
      return Interceptor.call(request);
    };

    User.get = function (userId) {

      var request = {
        method: 'GET',
        url: '/user/' + userId
      };
      return Interceptor.call(request);
    };

    User.add = function (registerData) {

      var request = {
        method: 'POST',
        url: '/user',
        data: registerData
      };
      return Interceptor.call(request);
    };

    User.update = function (userId, userData) {

      var request = {
        method: 'PUT',
        url: '/user/' + userId,
        data: userData
      };
      return Interceptor.call(request);
    };

    User.delete = function (userId) {

      var request = {
        method: 'DELETE',
        url: '/user/' + userId
      };
      return Interceptor.call(request);
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return User;

  });

