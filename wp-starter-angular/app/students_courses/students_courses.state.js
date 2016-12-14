/**
 * Created by Nacev on 14.12.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .config(registerState);


  registerState.$inject = ['$stateProvider'];

  function registerState($stateProvider) {

    $stateProvider.state('studentscourses', {
      url: '/association',
      templateUrl: 'app/students_courses/students_courses.view.html',
      controller: 'StudentsCoursesController',
      controllerAs: 'vm'
    });
  }

})(angular);
