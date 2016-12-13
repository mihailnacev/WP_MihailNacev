/**
 * Created by Nacev on 13.12.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .config(registerState);


  registerState.$inject = ['$stateProvider'];

  function registerState($stateProvider) {

    $stateProvider.state('students_new', {
      url: '/students_new',
      templateUrl: 'app/students_new/students.view.new.html',
      controller: 'StudentsControllerNew',
      controllerAs: 'vm'
    });
  }

})(angular);
