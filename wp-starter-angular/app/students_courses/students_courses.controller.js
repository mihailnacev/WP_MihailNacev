/**
 * Created by Nacev on 14.12.2016.
 */

(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .controller('StudentsCoursesController', StudentsCoursesController);

  StudentsCoursesController.$inject = ['$log', 'StudentsCoursesService','StudentsServiceNew','CoursesService'];

  /* @ngInject */
  function StudentsCoursesController($log, StudentsCoursesService,StudentsServiceNew,CoursesService) {
    var vm = this;
    vm.title = 'StudentCourse';
    vm.save = save;
    vm.clear = clear;
    vm.edit=edit;
    vm.remove= remove;
    vm.entity = {};
    vm.entities=[];
    vm.courses=[];
    vm.students=[];
    loadAll();
    loadStudents();
    loadCourses();

    function loadAll(){
      StudentsCoursesService.query(function(data) {
        // do something which you want with response
        vm.entities=data;
      });
    }

    function loadStudents() {
      StudentsServiceNew.query(function(data) {
        // do something which you want with response
        vm.students=data;
      });
    }

    function loadCourses(){
      CoursesService.query(function(data) {
        // do something which you want with response
        vm.courses=data;
      });
    }

    function save() {
      var entity=vm.entity;
      if(entity.id!=null) {editEntity(entity);
        return;}
      StudentsCoursesService.create(vm.entity ,function(){
        loadAll();
        clear();
      });
    }

    function clear() {
      vm.entity = {};
    }

    function editEntity(entity){
      StudentsCoursesService.update({id: entity.id},entity,function () {
        loadAll();
      });
    }

    function edit(entity){
      vm.entity = {};
      angular.extend(vm.entity, entity);
    }

    function remove(entity) {
      StudentsCoursesService.remove({id: entity.id},function () {
        loadAll();
      });
    }
  }

})(angular);
