'use strict';

describe('Directive: liveSearch', function () {

  // load the directive's module
  beforeEach(module('jewelryShopApp'));

  var element,
    scope;

  beforeEach(inject(function ($rootScope) {
    scope = $rootScope.$new();
  }));

  it('should make hidden element visible', inject(function ($compile) {
    element = angular.element('<live-search></live-search>');
    element = $compile(element)(scope);
    expect(element.text()).toBe('this is the liveSearch directive');
  }));
});
