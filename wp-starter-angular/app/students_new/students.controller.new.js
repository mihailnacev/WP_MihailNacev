/**
 * Created by Nacev on 13.12.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .controller('StudentsControllerNew', StudentsControllerNew);

  StudentsControllerNew.$inject = ['$log', 'StudentsServiceNew'];

  /* @ngInject */
  function StudentsControllerNew($log, StudentsServiceNew) {
    var vm = this;
    vm.title = 'Student';
    vm.save = save;
    vm.clear = clear;
    vm.edit=edit;
    vm.remove= remove;
    vm.entity = {};
    vm.entities=[];
    loadStudents();

    function loadStudents(){
      StudentsServiceNew.query(function(data) {
        // do something which you want with response
        vm.entities=data;
      });
    }

    function save() {
      var entity=vm.entity;
      if(entity.index!=null) {editEntity(entity);
        return;}
      StudentsServiceNew.create(vm.entity ,function(){
        loadStudents();
        clear();
      });
    }

    function clear() {
      vm.entity = {};
    }

    function editEntity(entity){
      StudentsServiceNew.update({id: entity.index},entity,function () {
        loadStudents();
      });
    }

    function edit(entity){
      vm.entity = {};
      angular.extend(vm.entity, entity);
    }

    function remove(entity) {
     StudentsServiceNew.remove({id: entity.index},function () {
        loadStudents();
      });
    }
  }

})(angular);
