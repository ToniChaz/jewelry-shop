'use strict';

describe('Service: administrator', function () {

  // load the service's module
  beforeEach(module('jewelryShopApp'));

  // instantiate service
  var administrator;
  beforeEach(inject(function (_administrator_) {
    administrator = _administrator_;
  }));

  it('should do something', function () {
    expect(!!administrator).toBe(true);
  });

});
