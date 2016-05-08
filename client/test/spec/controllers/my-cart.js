'use strict';

describe('Controller: MyCartCtrl', function () {

  // load the controller's module
  beforeEach(module('jewelryShopApp'));

  var MyCartCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    MyCartCtrl = $controller('MyCartCtrl', {
      $scope: scope
      // place here mocked dependencies
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(MyCartCtrl.awesomeThings.length).toBe(3);
  });
});
