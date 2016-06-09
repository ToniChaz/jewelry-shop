'use strict';

/**
 * @ngdoc function
 * @name jewelryShopApp.controller:ModalCtrl
 * @description
 * # ModalCtrl
 * Controller of the jewelryShopApp
 */
angular.module('jewelryShopApp')
  .controller('ModalCtrl', function ($scope, $uibModal, $log) {

    $scope.animationsEnabled = true;

    function setLargeModal(action) {
      if (action.indexOf('Administrator') > 0) {
        return 'views/modal/administrator-modal.html';
      } else if (action.indexOf('Product') > 0) {
        return 'views/modal/product-modal.html';
      } else {
        return 'views/modal/user-modal.html';
      }
    }

    function setTemplateOfModal(size, action) {
      switch (size) {
        case 'lg':
          return setLargeModal(action);
          break;
        case 'sm':
          return 'views/modal/confirm-modal.html';
          break;
        default:
          return 'views/modal/error-modal.html';
          break;
      }
    }

    $scope.open = function (size, action, modalData, callback) {

      var modalInstance = $uibModal.open({
        animation: $scope.animationsEnabled,
        templateUrl: setTemplateOfModal(size, action),
        controller: 'ModalInstanceCtrl',
        size: size,
        resolve: {
          action: function () {
            return action;
          },
          modalData: function () {
            return modalData;
          }
        }
      });

      modalInstance.result.then(function (data) {
        callback(data);
      }, function () {
        $log.info('Modal dismissed at: ' + new Date());
      });
    };

    $scope.$on('modal', function (event, size, action, modalData, callback) {
      $scope.open(size, action, modalData, callback);
    });

  });

// Please note that $uibModalInstance represents a modal window (instance) dependency.
// It is not the same as the $uibModal service used above.

angular.module('jewelryShopApp')
  .controller('ModalInstanceCtrl', function ($scope, $rootScope, $uibModalInstance, action, modalData) {

    $scope.modalData = modalData;
    $scope.formError = false;

    $scope.ok = function () {
      if ($scope.modalDataForm.$valid || $scope.modalData.password === undefined) {
        $uibModalInstance.close($scope.modalData);
      } else {
        $scope.formError = true;
      }
    };

    $scope.confirm = function () {
      $uibModalInstance.close($scope.modalData);
    };

    $scope.close = function () {
      $scope.formError = false;
    };

    $scope.cancel = function () {
      $uibModalInstance.dismiss('cancel');
    };

    function setModalTitle() {
      $scope.title = action.replace(/([A-Z])/g, ' $1').replace(/^./, function (str) {
        return str.toUpperCase();
      });
    }

    setModalTitle();

  });
