/**
 * Created by 141142 on 12/13/2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('CoursesService', CoursesServiceFn);

  CoursesServiceFn.$inject = ['$resource'];

  /* @ngInject */
  function CoursesServiceFn($resource) {
    var groupsList=[];
    var groupIdSequence=0;

    return $resource('/api/courses/:id', {id: '@id'}, {
      query: { method: "GET", isArray: true },
      create: { method: "POST"},
      get: { method: "GET"},
      remove: { method: "DELETE",isArray: false},
      update: { method: "PUT"}
    });


  }
})(angular);
