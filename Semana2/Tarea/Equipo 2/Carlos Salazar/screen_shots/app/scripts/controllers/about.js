'use strict';

/**
 * @ngdoc function
 * @name sinosApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the sinosApp
 */
angular.module('sinosApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
