'use strict';

describe('Controller: AdminUserCtrl', function () {

  // load the controller's module
  beforeEach(module('jewelryShopApp'));

  var AdminUserCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AdminUserCtrl = $controller('AdminUserCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(AdminUserCtrl.awesomeThings.length).toBe(3);
  });
});
