'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:MySectionCtrl
 * @description
 * # MySectionCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('MySectionCtrl', function ($scope, $rootScope, $location, User, Cart) {
    /*-------------------------------------
     | Functions                          |
     -------------------------------------*/
    function isLogged() {
      if (!$rootScope.isLogged) {
        $location.path('/login');
      }
    }

    $scope.convertToDate = function (stringDate){
      var dateOut = new Date(stringDate);
      dateOut.setDate(dateOut.getDate() + 1);
      return dateOut;
    };

    $scope.update = function (updateData) {
      if (!updateData || !updateData.name || !updateData.surname || !updateData.email || !updateData.address || !updateData.bankAccount) {
        $rootScope.$broadcast('alert', 'danger', 'All data is required to register as client or your e-mail is invalid.');
        return false;
      }

      var dataToUpdate = {
        name: updateData.name,
        surname: updateData.surname,
        email: updateData.email,
        address: updateData.address,
        bankAccount: updateData.bankAccount
      };

      if (updateData.password !== '') {
        dataToUpdate.password = updateData.password;
      }

      User.update($rootScope.userId, dataToUpdate).then(function (response) {
        angular.extend($rootScope.user, response);
        $rootScope.$broadcast('alert', 'success', 'Your data has been updated successfully.');
      });
    };

    $scope.buy = function (productId) {
      Cart.update($rootScope.userId, productId).then(function (response) {
        $rootScope.$broadcast('alert', 'success', 'The product has been added in the cart correctly');
        $rootScope.user.cart = response;
      });
    };

    /*-------------------------------------
     | Init                               |
     -------------------------------------*/
    isLogged();

  });
