'use strict';

/**
 * @ngdoc service
 * @name jewelryShopApp.cart
 * @description
 * # cart
 * Factory in the jewelryShopApp.
 */
angular.module('jewelryShopApp')
  .factory('Cart', function (Interceptor) {

    /*-------------------------------------
     | Variables                          |
     -------------------------------------*/
    var Cart = {};

    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    Cart.get = function (cartId) {

      var request = {
        method: 'GET',
        url: '/cart/' + cartId
      };
      return Interceptor.call(request);
    };

    Cart.create = function (userId, cartData) {

      var request = {
        method: 'POST',
        url: '/cart/' + userId,
        data: cartData
      };
      return Interceptor.call(request);
    };

    Cart.update = function (userId, productId) {

      var request = {
        method: 'PUT',
        url: '/cart/' + userId,
        data: productId
      };
      return Interceptor.call(request);
    };

    Cart.delete = function (userId) {

      var request = {
        method: 'DELETE',
        url: '/cart/' + userId
      };
      return Interceptor.call(request);
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return Cart;

  });
