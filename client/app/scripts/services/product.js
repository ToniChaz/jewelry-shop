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

    Product.get = function (productId) {

      var request = {
        method: 'GET',
        url: '/product/' + productId
      };
      return Interceptor.call(request);
    };

    Product.find = function (query) {

      var request = {
        method: 'GET',
        url: '/product/find?query=' + query,
        noLoader: true
      };
      return Interceptor.call(request);
    };

    Product.add = function (productData) {

      var request = {
        method: 'POST',
        url: '/product',
        data: productData
      };
      return Interceptor.call(request);
    };

    Product.update = function (productId, productData) {

      delete productData.index;

      var request = {
        method: 'PUT',
        url: '/product/' + productId,
        data: productData
      };
      return Interceptor.call(request);
    };

    Product.delete = function (productId) {

      var request = {
        method: 'DELETE',
        url: '/product/' + productId
      };
      return Interceptor.call(request);
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return Product;

  });
