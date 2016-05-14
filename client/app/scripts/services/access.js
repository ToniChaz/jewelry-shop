'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.Access
 * @description
 * # Access
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('Access', function ($rootScope, $location, $sessionStorage, Interceptor) {
    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    var Access = {};

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    Access.login = function (loginData) {

      var request = {
        method: 'POST',
        url: '/login',
        data: {
          "email": loginData.email,
          "password": loginData.password
        }
      };
      return Interceptor.call(request).then(function (response) {
        $rootScope.isLogged = response.isLogged;
        $rootScope.isAdministrator = response.isAdministrator;
        $rootScope.accessToken = response.accessToken;

        if (loginData.session) {
          $sessionStorage.session = {
            isLogged: $rootScope.isLogged,
            isAdministrator: $rootScope.isAdministrator,
            accessToken: $rootScope.accessToken
          }
        }

      });
    };

    Access.logout = function () {

      var request = {
        method: 'GET',
        url: '/logout'
      };
      return Interceptor.call(request).then(function () {
        delete $sessionStorage.session;
        $rootScope.isLogged = false;
        $rootScope.isAdministrator = false;
        $rootScope.accessToken = '';
        $location.path('/');
      });
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return Access;
  });
