'use strict';

describe('Service: interceptor', function () {

  // load the service's module
  beforeEach(module('jewelryShopApp'));

  // instantiate service
  var interceptor;
  beforeEach(inject(function (_interceptor_) {
    interceptor = _interceptor_;
  }));

  it('should do something', function () {
    expect(!!interceptor).toBe(true);
  });

});
