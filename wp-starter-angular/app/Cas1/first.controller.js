/**
 * Created by Nacev on 02.10.2016.
 */
(function (angular) {
  'use strict';
  angular.module('wp-angular-starter')
    .controller('FirstController',FirstController);
  FirstController.$inject=['$scope','$log'];

  function FirstController($scope,$log) {
    var vm=this;

   vm.helloDivClicked=function () {
    $log.debug('Hello Div clicked from vm!');
   };

   vm.clearTo=function(){
     $scope.to=null;
   };

    $scope.name = 'Riste';
    vm.name = 'Darko';

    $scope.helloDivClicked = function () {
      $log.debug('Hello Div clicked!');
      $log.debug('to: ', $scope.to);
    };

    $log.debug('Initializing First controller!');
    $log.debug('to: ', $scope.to);

  }
})(angular);
