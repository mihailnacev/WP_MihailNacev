/**
 * Created by 141142 on 12/13/2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .controller('CoursesController', CoursesController);

  CoursesController.$inject = ['$log', 'GroupService'];

  /* @ngInject */
  function CoursesController($log, CoursesService) {
    var vm = this;
    vm.title = 'Course';
    vm.save = save;
    vm.clear = clear;
    vm.edit=edit;
    vm.remove= remove;
    vm.entity = {};
    vm.entities=[];
    vm.courses=[];
    loadCourses();

    function loadCourses(){
      CoursesService.query(function(data) {
        // do something which you want with response
        vm.entities=data;
        vm.courses=data;
      });
    }

    function save() {
      var entity=vm.entity;
      if(entity.id!=null) {editEntity(entity);
        return;}
      CoursesService.create(vm.entity ,function(){
        loadCourses();
        clear();
      });
    }

    function clear() {
      vm.entity = {};
    }

    function editEntity(entity){
     CoursesService.update({id: entity.id},entity,function () {
        loadCourses();
      });
    }

    function edit(entity){
      vm.entity = {};
      angular.extend(vm.entity, entity);
    }

    function remove(entity) {
      CoursesService.remove({id: entity.id},function () {
        loadCourses();
      });
    }
  }

})(angular);
