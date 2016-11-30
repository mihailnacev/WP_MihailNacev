/**
 * Created by Nacev on 16.10.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .controller('StudentsController',StudentsController);

  StudentsController.$inject=['$log', 'StudentsService', 'GroupService'];

  function StudentsController($log, StudentsService, GroupService){
    var vm=this;
    vm.title='Students';
    vm.entity={};
    vm.group={};
    vm.groups=[];
    vm.save = save;
    vm.clear = clear;
    vm.edit=edit;
    vm.remove= remove;
    vm.entity = {};
    vm.entities=[];
    vm.rowCollection={};
    vm.saveOkMsg = null;
    vm.saveErrMsg = null;
    vm.itemsByPage=2;
    vm.displayedPages=5;
    getAllGroups();
    loadStudents();


    function getAllGroups() {
      GroupService.query(function(data) {
        // do something which you want with response
        vm.groups=data;
      });
    }

    function loadStudents(){
      StudentsService.getAll().then(function (data) {
        vm.entities = data;
        vm.rowCollection=data;
      });
    }

    function save() {
      vm.saveOkMsg = null;
      vm.saveErrMsg = null;

      var promise=StudentsService.save(vm.entity);
      promise.then(successCallback, errorCallback);
      function successCallback(data) {
        loadStudents();
        vm.saveOkMsg = "Group with id " + data.id + " is saved";
        clear();
      }

      function errorCallback(data) {
        vm.saveErrMsg = "Saving error occurred: " + data.message;
      }

    }

    function clear() {
      vm.entity = {};
    }

    function edit(entity){
      vm.entity = {};
      angular.extend(vm.entity, entity);
    }

    function remove(entity){
      StudentsService.remove(entity).then(function(data){
        loadStudents();
      });
    }
  }
})(angular);
