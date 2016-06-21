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

    Cart.update = function (userId, productId) {

      var request = {
        method: 'PUT',
        url: '/cart/' + userId,
        data: productId
      };
      return Interceptor.call(request);
    };

    Cart.removeProductFromCart = function (userId, productId) {

      var request = {
        method: 'PUT',
        url: '/cart/remove/' + userId,
        data: productId
      };
      return Interceptor.call(request);
    };

    Cart.transactionComplete = function (userId) {

      var request = {
        method: 'PUT',
        url: '/cart/complete/' + userId
      };
      return Interceptor.call(request);
    };

    /*-------------------------------------
     | Return                             |
     -------------------------------------*/
    return Cart;

  });
