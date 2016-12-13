/**
 * Created by Nacev on 13.12.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('StudentsServiceNew', StudentsServiceNewFn);

  StudentsServiceNewFn.$inject = ['$resource'];

  /* @ngInject */
  function StudentsServiceNewFn($resource) {
    var groupsList=[];
    var groupIdSequence=0;

    return $resource('/api/students/:id', {id: '@id'}, {
      query: { method: "GET", isArray: true },
      create: { method: "POST"},
      get: { method: "GET"},
      remove: { method: "DELETE",isArray: false},
      update: { method: "PUT"}
    });


  }
})(angular);
