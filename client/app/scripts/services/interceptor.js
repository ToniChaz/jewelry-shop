'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.interceptor
 * @description
 * # interceptor
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('Interceptor', function ($q, $http, $log, ENVIRONMENT) {

    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    var Interceptor = {},
      urlBase = ENVIRONMENT.apiEndpoint;

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    function errorInterceptor(response) {
      $log.error('Service Error: ', response);
    }

    Interceptor.call = function (request) {

      var deferred = $q.defer();

      request.url = urlBase + request.url;

      $http(request)
        .then(function successCallback(response) {
          deferred.resolve(response.data);
        }, function errorCallback(response) {

          errorInterceptor(response);
          deferred.reject(response);
        });

      return deferred.promise;
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return Interceptor;
  });
