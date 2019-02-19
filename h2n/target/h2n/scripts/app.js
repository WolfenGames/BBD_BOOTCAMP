'use strict';

angular.module('h2n',['ngRoute','ngResource'])
  .config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/',{templateUrl:'views/landing.html',controller:'LandingPageController'})
      .when('/Cars',{templateUrl:'views/Car/search.html',controller:'SearchCarController'})
      .when('/Cars/new',{templateUrl:'views/Car/detail.html',controller:'NewCarController'})
      .when('/Cars/edit/:CarId',{templateUrl:'views/Car/detail.html',controller:'EditCarController'})
      .when('/Celebrities',{templateUrl:'views/Celebrity/search.html',controller:'SearchCelebrityController'})
      .when('/Celebrities/new',{templateUrl:'views/Celebrity/detail.html',controller:'NewCelebrityController'})
      .when('/Celebrities/edit/:CelebrityId',{templateUrl:'views/Celebrity/detail.html',controller:'EditCelebrityController'})
      .otherwise({
        redirectTo: '/'
      });
  }])
  .controller('LandingPageController', function LandingPageController() {
  })
  .controller('NavController', function NavController($scope, $location) {
    $scope.matchesRoute = function(route) {
        var path = $location.path();
        return (path === ("/" + route) || path.indexOf("/" + route + "/") == 0);
    };
  });
