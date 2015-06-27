'use strict';

/**
 * @ngdoc function
 * @name sinosApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the sinosApp
 */
angular.module('sinosApp')
  .controller('IndexCtrl', function ($scope, $location) {
    $scope.isActive = function(route){
      return route === $location.path();
    }
  });
