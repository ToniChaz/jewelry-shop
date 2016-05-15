'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.product
 * @description
 * # product
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('Product', function (Interceptor) {

    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    var Product = {};

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    Product.getAll = function () {

      var request = {
        method: 'GET',
        url: '/product'
      };
      return Interceptor.call(request);
    };

    Product.get = function (query) {

      var request = {
        method: 'GET',
        url: '/product?query=' + query,
        noLoader: true
      };
      return Interceptor.call(request);
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return Product;

  });
