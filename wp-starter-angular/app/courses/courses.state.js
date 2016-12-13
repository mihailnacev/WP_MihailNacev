/**
 * Created by 141142 on 12/13/2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .config(registerState);


  registerState.$inject = ['$stateProvider'];

  function registerState($stateProvider) {

    $stateProvider.state('courses', {
      url: '/courses',
      templateUrl: 'app/courses/courses.view.html',
      controller: 'CoursesController',
      controllerAs: 'vm'
    });
  }

})(angular);
