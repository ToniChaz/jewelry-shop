'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.interceptor
 * @description
 * # interceptor
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('Interceptor', function ($q, $http, $log, $rootScope, ENVIRONMENT) {

    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    var Interceptor = {},
      urlBase = ENVIRONMENT.apiEndpoint;

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    function errorInterceptor(response) {
      $rootScope.$broadcast('alert', 'danger', 'An error occurred. Please try again later. Reason: ' + response.status + ' - ' + response.data);
      $log.error('Service Error: ', response);
    }

    Interceptor.call = function (request) {

      if (!request.noLoader) {
        $rootScope.loaded = false;
      }

      var deferred = $q.defer();

      request.url = urlBase + request.url;

      if ($rootScope.accessToken) {
        request.headers = {
          AccessToken: $rootScope.accessToken
        };
      }

      $http(request)
        .then(function successCallback(response) {
          deferred.resolve(response.data);
          $rootScope.loaded = true;
        }, function errorCallback(response) {
          errorInterceptor(response);
          deferred.reject(response);
          $rootScope.loaded = true;
        });

      return deferred.promise;
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return Interceptor;
  });
