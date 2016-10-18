/**
 * Created by Nacev on 16.10.2016.
 */

(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('StudentsService',StudentsService);

  StudentsService.$inject=['$log','$timeout','$q','$localStorage'];

  /* @ngInject */
  function StudentsService($log,$timeout,$q,$localStorage){

    $localStorage.studentsList= $localStorage.studentsList || [];
    var studentsIdSequence=0;

    var service = {
      save: saveFn,
      update: updateFn,
      getById: getByIdFn,
      getAll: getAllFn,
      remove: removeFn
    };

    return service;

    function saveFn(studentEntity){
      var entityForSave, invalidMessage;
      var deferred=$q.defer();
      if(studentEntity.id===undefined){
        $timeout(function () {
          entityForSave=angular.copy(studentEntity);
          invalidMessage = validateStudent(studentEntity);
          if(invalidMessage===null){
            entityForSave.id=++studentsIdSequence;
            $localStorage.studentsList.push(entityForSave);
            $log.debug('saving', entityForSave);
            deferred.resolve(entityForSave);
          }
          else{
            $log.debug('saving invalid',invalidMessage);
            deferred.reject({
              message:invalidMessage
            });
          }
        },100);
        return deferred.promise;
      }
      else{
        return updateFn(studentEntity);
      }
      $log.debug('in save fn');
    }

    function validateStudent(entity) {
      if (entity.name === null
        || entity.name === undefined
        || typeof entity.name !== 'string'
        || entity.name.length === 0) {
        return 'Invalid name for group';
      }
      return null;
    }

    function updateFn(studentEntity){
      var defered=$q.defer();
      if(studentEntity.id===undefined){
        return saveFn(studentEntity);
      }
      else{
        $timeout(function(){
          getByIdFn(studentEntity.id)
            .then(function (savedEntity) {
              angular.extend(savedEntity,studentEntity);
              $log.debug("merged entity", savedEntity);
              $log.debug('updating', savedEntity);
              defered.resolve(savedEntity);
            });

        },100);
        return defered.promise;

      }
    }

    function getByIdFn(studentId){
      var index = findIndexById(studentId);
      var defered=$q.defer();

      $timeout(function(){
        if(index===-1){
          return defered.resolve(null);
        }
        else{
          return defered.resolve( $localStorage.studentsList[index]);
        }
      },100);
      return defered.promise;
    }

    function getAllFn(){
      var defered=$q.defer();
      $timeout(function(){
        $log.debug('getAll');
        defered.resolve(angular.copy( $localStorage.studentsList));
      },100);
      return defered.promise;
    }

    function removeFn(studentEntity){
      var defered=$q.defer();
      $timeout(function(){
        var index = findIndexById(studentEntity.id);
        if (index !== -1) {
          $localStorage.studentsList.splice(index, 1);
        }
        $log.debug('remove', studentEntity);
        defered.resolve();
      },100);
      return defered.promise;
    }

    function findIndexById(groupId) {
      var result = -1, item;

      $log.debug('get index by id: ', groupId);
      for (var i = 0; i <  $localStorage.studentsList.length; i++) {
        item =  $localStorage.studentsList[i];
        if (item.id === groupId) {
          result = i;
          break;
        }
      }
      return result;
    }
  }

})(angular);
