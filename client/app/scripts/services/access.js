'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.Access
 * @description
 * # Access
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('Access', function ($rootScope, $location, Interceptor, User, Administrator) {
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
        url: '/access/login',
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

        if ($rootScope.isAdministrator){
            Administrator.get($rootScope.userId).then(function(response){
                $rootScope.setUserData(response);
                //$rootScope.setUserToSession(response);
              });
        } else {
            User.get($rootScope.userId).then(function(response){
                $rootScope.setUserData(response);
                //$rootScope.setUserToSession(response);
              });
        }


      },function(response){
          $rootScope.$broadcast('alert', 'danger', response.status + ' - ' + response.data);
      });
    };

    Access.logout = function () {

      var request = {
        method: 'GET',
        url: '/access/logout/'
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
