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
    'ngTouch'
  ])
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/shop.html',
        controller: 'ShopCtrl',
        controllerAs: 'shop'
      })
      .when('/login', {
        templateUrl: 'views/login.html',
        controller: 'LoginCtrl',
        controllerAs: 'login'
      })
      .when('/register', {
        templateUrl: 'views/register.html',
        controller: 'RegisterCtrl',
        controllerAs: 'register'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl',
        controllerAs: 'about'
      })
      .when('/my-cart', {
        templateUrl: 'views/my-cart.html',
        controller: 'MyCartCtrl',
        controllerAs: 'myCart'
      })
      .when('/my-section', {
        templateUrl: 'views/my-section.html',
        controller: 'MySectionCtrl',
        controllerAs: 'mySection'
      })
      .when('/contact', {
        templateUrl: 'views/contact.html',
        controller: 'ContactCtrl',
        controllerAs: 'contact'
      })
      .when('/admin/login', {
        templateUrl: 'views/admin/login.html',
        controller: 'AdminLoginCtrl',
        controllerAs: 'admin/login'
      })
      .when('/admin/dashboard', {
        templateUrl: 'views/admin/dashboard.html',
        controller: 'AdminDashboardCtrl',
        controllerAs: 'admin/dashboard'
      })
      .when('/admin/administrator', {
        templateUrl: 'views/admin/administrator.html',
        controller: 'AdminAdministratorCtrl',
        controllerAs: 'admin/administrator'
      })
      .when('/admin/product', {
        templateUrl: 'views/admin/product.html',
        controller: 'AdminProductCtrl',
        controllerAs: 'admin/product'
      })
      .when('/admin/user', {
        templateUrl: 'views/admin/user.html',
        controller: 'AdminUserCtrl',
        controllerAs: 'admin/user'
      })
      .otherwise({
        redirectTo: '/'
      });
  });
