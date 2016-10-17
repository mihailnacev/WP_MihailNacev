/**
 * Created by Nacev on 07.10.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .factory('GroupService', GroupServiceFn);

  GroupServiceFn.$inject = ['$log','$timeout','$q'];

  /* @ngInject */
  function GroupServiceFn($log,$timeout,$q) {
    var groupsList=[];
    var groupIdSequence=0;

    var service = {
      save: saveFn,
      update: updateFn,
      getById: getByIdFn,
      getAll: getAllFn,
      remove: removeFn
    };


    return service;


    function saveFn(groupEntity) {
       var entityForSave, invalidMessage;
       var deferred=$q.defer();
      if(groupEntity.id===undefined){
        $timeout(function () {
          entityForSave=angular.copy(groupEntity);
          invalidMessage = validateGroup(entityForSave);
          if(invalidMessage===null){
            entityForSave.id=++groupIdSequence;
            groupsList.push(entityForSave);
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
        return updateFn(groupEntity);
      }
      $log.debug('in save fn');
    }

    function validateGroup(entity) {
      if (entity.name === null
        || entity.name === undefined
        || typeof entity.name !== 'string'
        || entity.name.length === 0) {
        return 'Invalid name for group';
      }
      return null;
    }

    function updateFn(groupEntity) {
      var defered=$q.defer();
      if(groupEntity.id===undefined){
         return saveFn(groupEntity);
       }
       else{
          $timeout(function(){
            getByIdFn(groupEntity.id)
              .then(function (savedEntity) {
                angular.extend(savedEntity,groupEntity);
                $log.debug("merged entity", savedEntity);
                $log.debug('updating', savedEntity);
                defered.resolve(savedEntity);
              });

          },100);
        return defered.promise;

       }
    }

    function getByIdFn(groupId) {
      var index = findIndexById(groupId);
      var defered=$q.defer();

      $timeout(function(){
        if(index===-1){
          return defered.resolve(null);
        }
        else{
          return defered.resolve(groupsList[index]);
        }
      },100);
      return defered.promise;

    }



    function getAllFn() {
       var defered=$q.defer();
      $timeout(function(){
        $log.debug('getAll');
        defered.resolve(angular.copy(groupsList));
      },100);
      return defered.promise;
    }

    function removeFn(groupEntity) {
      var defered=$q.defer();
      $timeout(function(){
        var index = findIndexById(groupEntity.id);
        if (index !== -1) {
          groupsList.splice(index, 1);
        }
        $log.debug('remove', groupEntity);
        defered.resolve();
      },100);
      return defered.promise;
    }

    function findIndexById(groupId) {
      var result = -1, item;

      $log.debug('get index by id: ', groupId);
      for (var i = 0; i < groupsList.length; i++) {
        item = groupsList[i];
        if (item.id === groupId) {
          result = i;
          break;
        }
      }
      return result;
    }

  }
})(angular);
