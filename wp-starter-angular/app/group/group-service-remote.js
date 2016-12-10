/**
 * Created by Nacev on 28.11.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('GroupService', GroupServiceFn);

  GroupServiceFn.$inject = ['$resource'];

  /* @ngInject */
  function GroupServiceFn($resource) {
    var groupsList=[];
    var groupIdSequence=0;

    return $resource('/api/groups/:id', {id: '@id'}, {
      query: { method: "GET", isArray: true },
      create: { method: "POST"},
      get: { method: "GET"},
      remove: { method: "DELETE",isArray: false},
      update: { method: "PUT"}
    });


  }
})(angular);
