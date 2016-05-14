'use strict';

describe('Service: Access', function () {

  // load the service's module
  beforeEach(module('jewelryShopApp'));

  // instantiate service
  var Access;
  beforeEach(inject(function (_access_) {
    Access = _access_;
  }));

  it('should do something', function () {
    expect(!!Access).toBe(true);
  });

});
