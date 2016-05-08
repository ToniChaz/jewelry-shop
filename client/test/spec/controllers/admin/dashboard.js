'use strict';

describe('Controller: AdminDashboardCtrl', function () {

  // load the controller's module
  beforeEach(module('jewelryShopApp'));

  var AdminDashboardCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AdminDashboardCtrl = $controller('AdminDashboardCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(AdminDashboardCtrl.awesomeThings.length).toBe(3);
  });
});
