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
    'angular-carousel',
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
      .when('/my-section', {
        templateUrl: 'views/my-section.html',
        controller: 'MySectionCtrl'
      })
      .when('/contact', {
        templateUrl: 'views/contact.html',
        controller: 'ContactCtrl'
      })
      .when('/admin/login', {
        templateUrl: 'views/admin/login.html',
        controller: 'AdminLoginCtrl'
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
  .run(function ($rootScope, $sessionStorage) {

    // Global variables
    $rootScope.hideHeaderFooter = false;

    $rootScope.$on("$locationChangeStart", function (event, next) {
      var currentPath = next.split('/').pop();
      $rootScope.hideHeaderFooter = currentPath !== 'login' && currentPath !== 'register';
    });

    $rootScope.isLogged = false;
    $rootScope.isAdministrator = false;
    $rootScope.accessToken = '';
    $rootScope.loaded = true;

    if($sessionStorage.session !== undefined){
      $rootScope.isLogged = $sessionStorage.session.isLogged;
      $rootScope.isAdministrator = $sessionStorage.session.isAdministrator;
      $rootScope.accessToken = $sessionStorage.session.accessToken;
    }

  });
