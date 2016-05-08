'use strict';

describe('Controller: AdminAdministratorCtrl', function () {

  // load the controller's module
  beforeEach(module('jewelryShopApp'));

  var AdminAdministratorCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    AdminAdministratorCtrl = $controller('AdminAdministratorCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(AdminAdministratorCtrl.awesomeThings.length).toBe(3);
  });
});
