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

    User.get = function (query) {

      var request = {
        method: 'GET',
        url: '/user' + query
      };
      return Interceptor.call(request);
    };

    User.add = function (registerData) {

      var request = {
        method: 'POST',
        url: '/user',
        data: {
          "name": registerData.firstName,
          "surname": registerData.surname,
          "email": registerData.email,
          "password": registerData.password,
          "bankAccount": registerData.bankAccount,
          "address": registerData.address
        }
      };
      return Interceptor.call(request);
    };

    User.update = function (userData, userId) {

      var request = {
        method: 'PUT',
        url: '/user' + userId,
        data: {
          "name": userData.firstName,
          "surname": userData.surname,
          "email": userData.email,
          "password": userData.password,
          "bankAccount": userData.bankAccount,
          "address": userData.address
        }
      };
      return Interceptor.call(request);
    };

    User.delete = function (userId) {

      var request = {
        method: 'DELETE',
        url: '/user' + userId
      };
      return Interceptor.call(request);
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return User;

  });

