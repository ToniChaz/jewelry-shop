'use strict';

describe('Controller: MySectionCtrl', function () {

  // load the controller's module
  beforeEach(module('jewelryShopApp'));

  var MySectionCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    MySectionCtrl = $controller('MySectionCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(MySectionCtrl.awesomeThings.length).toBe(3);
  });
});
