'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.Access
 * @description
 * # Access
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('Access', function ($rootScope, $location, $sessionStorage, Interceptor, User) {
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
          email: loginData.email,
          password: loginData.password
        }
      };
      return Interceptor.call(request).then(function (response) {
        $rootScope.setData(response);

        if (loginData.session) {
          $rootScope.setSession(response);
        }

        User.get($rootScope.userId).then(function(response){
          $rootScope.setUserData(response);
          $rootScope.setUserToSession(response);
        });

      });
    };

    Access.logout = function () {

      var request = {
        method: 'GET',
        url: '/logout'
      };
      return Interceptor.call(request).then(function () {
        $rootScope.cleanSession();
        $rootScope.initData();
        $location.path('/');
      });
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return Access;
  });
