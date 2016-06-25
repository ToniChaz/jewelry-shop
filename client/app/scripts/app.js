'use strict';

/**
 * @ngdoc overview
 * @name jewelryShopApp
 * @description
 * # jewelryShopApp
 *
 * Main module of the application.
 */
angular
  .module('jewelryShopApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ngStorage',
    'ui.bootstrap',
    'chart.js',
    'config'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/home.html',
        controller: 'HomeCtrl'
      })
      .when('/shop', {
        templateUrl: 'views/shop.html',
        controller: 'ShopCtrl'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl'
      })
      .when('/register', {
        templateUrl: 'views/register.html',
        controller: 'RegisterCtrl'
      })
      .when('/my-cart', {
        templateUrl: 'views/my-cart.html',
        controller: 'MyCartCtrl'
      })
      .when('/my-cart/:cartId', {
        templateUrl: 'views/my-cart.html',
        controller: 'MyCartCtrl'
      })
      .when('/my-section', {
        templateUrl: 'views/my-section.html',
        controller: 'MySectionCtrl'
      })
      .when('/contact', {
        templateUrl: 'views/contact.html',
        controller: 'ContactCtrl'
      })
      .when('/admin/dashboard', {
        templateUrl: 'views/admin/dashboard.html',
        controller: 'AdminDashboardCtrl'
      })
      .when('/admin/administrator', {
        templateUrl: 'views/admin/administrator.html',
        controller: 'AdminAdministratorCtrl'
      })
      .when('/admin/product', {
        templateUrl: 'views/admin/product.html',
        controller: 'AdminProductCtrl'
      })
      .when('/admin/user', {
        templateUrl: 'views/admin/user.html',
        controller: 'AdminUserCtrl'
      })
      .otherwise({
        redirectTo: function () {
          window.location.replace('/404.html');
        }
      });
  })
  .run(function ($rootScope, $sessionStorage, User, Cart) {

    // Global variables
    $rootScope.hideHeaderFooter = false;
    $rootScope.loaded = true;

    $rootScope.$on('$locationChangeStart', function (event, next) {
      var currentPath = next.split('/').pop();
      $rootScope.hideHeaderFooter = currentPath !== 'login' && currentPath !== 'register';

    });

    function initData(){
      $rootScope.user = {};
      $rootScope.user.cart = {};
      $rootScope.user.orders = {};
      $rootScope.userId = '';
      $rootScope.accessToken = '';
      $rootScope.isLogged = false;
      $rootScope.isAdministrator = false;
    }

    function setData(data){
      $rootScope.userId = data.userId;
      $rootScope.accessToken = data.accessToken;
      $rootScope.isLogged = data.isLogged;
      $rootScope.isAdministrator = data.isAdministrator;
    }

    function setSession(data){
      $sessionStorage.session = {
        isLogged: data.isLogged,
        isAdministrator: data.isAdministrator,
        accessToken: data.accessToken,
        userId: data.userId
      };
    }

    function recoverSession(){
      $rootScope.userId = $sessionStorage.session.userId;
      $rootScope.isLogged = $sessionStorage.session.isLogged;
      $rootScope.isAdministrator = $sessionStorage.session.isAdministrator;
      $rootScope.accessToken = $sessionStorage.session.accessToken;
      $rootScope.user = $sessionStorage.session.user;
    }

    function cleanSession(){
      delete $sessionStorage.session;
    }

    function setUserData(userData){
      $rootScope.user = userData;
    }

    // Return functions
    $rootScope.initData = initData;
    $rootScope.setData = setData;
    $rootScope.setSession = setSession;
    $rootScope.recoverSession = recoverSession;
    $rootScope.cleanSession = cleanSession;
    $rootScope.setUserData = setUserData;

    initData();

    if($sessionStorage.session !== undefined){
      recoverSession();
    }

    if ($rootScope.isLogged && $rootScope.user === undefined) {
      debugger
      User.get($rootScope.userId).then(function (response) {
        setUserData(response);
        Cart.get($rootScope.userId).then(function (response) {
          $rootScope.user.cart = response;
        });
      });
    }

  });
