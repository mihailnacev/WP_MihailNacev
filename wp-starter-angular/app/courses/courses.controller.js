/**
 * Created by 141142 on 12/13/2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .controller('CoursesController', CoursesController);

  CoursesController.$inject = ['$log', 'CoursesService','StudentsCoursesService'];

  /* @ngInject */
  function CoursesController($log, CoursesService, StudentsCoursesService) {
    var vm = this;
    vm.title = 'Course';
    vm.save = save;
    vm.clear = clear;
    vm.edit=edit;
    vm.remove= remove;
    vm.entity = {};
    vm.entities=[];
    vm.courses=[];
    vm.associations=[];
    vm.lista=[];
    vm.check=check;
    loadCourses();
    loadAssociations();

    function loadCourses(){
      CoursesService.query(function(data) {
        // do something which you want with response
        vm.entities=data;
        vm.courses=data;
      });
    }

    function loadAssociations(){
      StudentsCoursesService.query(function(data) {
        // do something which you want with response
        vm.associations=data;
      });
    }

    function save() {
      var entity=vm.entity;
      if(entity.id!=null) {editEntity(entity);
        return;}
      CoursesService.create(vm.entity ,function(){
        loadCourses();
        loadAssociations();
        clear();
      });
    }

    function clear() {
      vm.entity = {};
    }

    function editEntity(entity){
     CoursesService.update({id: entity.id},entity,function () {
        loadCourses();
       loadAssociations();
      });
    }

    function edit(entity){
      vm.entity = {};
      angular.extend(vm.entity, entity);
    }

    function remove(entity) {
      CoursesService.remove({id: entity.id},function () {
        loadCourses();
        loadAssociations();
      });
    }

    function check(entity) {
      vm.lista=[];
      loadAssociations();
      vm.associations.forEach(function (element) {
         if(element.course.name==entity.name){
           vm.lista.push(element);
         }
      })
    }
  }

})(angular);
