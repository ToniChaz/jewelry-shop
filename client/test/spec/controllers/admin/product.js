'use strict';

describe('Controller: AdminProductCtrl', function () {

  // load the controller's module
  beforeEach(module('jewelryShopApp'));

  var AdminProductCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AdminProductCtrl = $controller('AdminProductCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(AdminProductCtrl.awesomeThings.length).toBe(3);
  });
});
