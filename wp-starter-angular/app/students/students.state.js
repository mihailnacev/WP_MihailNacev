/**
 * Created by Nacev on 16.10.2016.
 */
(function (angular){
  'use strict';

  angular
    .module('wp-angular-starter')
    .config(registerState);

  registerState.$inject=['$stateProvider'];

  function registerState($stateProvider) {
    $stateProvider.state('students',{
      url:'/students',
      templateUrl:'app/students/students.view.html',
      controller:'StudentsController',
      controllerAs:'vm'
    });
  }
})(angular);
