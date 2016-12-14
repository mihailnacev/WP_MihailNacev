/**
 * Created by Nacev on 14.12.2016.
 */
/**
 * Created by Nacev on 13.12.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('StudentsCoursesService', StudentsCoursesServiceFn);

  StudentsCoursesServiceFn.$inject = ['$resource'];

  /* @ngInject */
  function StudentsCoursesServiceFn($resource) {
    var groupsList=[];
    var groupIdSequence=0;

    return $resource('/api/studentscourses/:id', {id: '@id'}, {
      query: { method: "GET", isArray: true },
      create: { method: "POST"},
      get: { method: "GET"},
      remove: { method: "DELETE",isArray: false},
      update: { method: "PUT"}
    });


  }
})(angular);
