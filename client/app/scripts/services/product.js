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
    Product.get = function () {

      var request = {
        method: 'GET',
        url: '/product'
      };
      return Interceptor.call(request);
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return Product;

  });
