'use strict';

describe('Controller: AdminLoginCtrl', function () {

  // load the controller's module
  beforeEach(module('jewelryShopApp'));

  var AdminLoginCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AdminLoginCtrl = $controller('AdminLoginCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(AdminLoginCtrl.awesomeThings.length).toBe(3);
  });
});
