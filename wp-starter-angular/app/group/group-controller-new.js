/**
 * Created by Nacev on 28.11.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .controller('GroupController', GroupController);

  GroupController.$inject = ['$log', 'GroupService'];

  /* @ngInject */
  function GroupController($log, GroupService) {
    var vm = this;
    vm.title = 'Group';
    vm.save = save;
    vm.clear = clear;
    vm.edit=edit;
    vm.remove= remove;
    vm.entity = {};
    vm.entities=[];
    vm.saveOkMsg = null;
    vm.saveErrMsg = null;
    vm.availableSizes = [20, 40];
    vm.criterium='';
    vm.SortCriterium=SortCriterium;
    loadGroups();

    function loadGroups(){
      GroupService.query(function(data) {
        // do something which you want with response
        vm.entities=data;
      });
    }

    function SortCriterium(val) {
      if(val==='name')
        vm.criterium='-name';
      else if(val==='noTerms'){
        vm.criterium='-noTerms';
      }
      else{
        vm.criterium='';
      }
    }

    function save() {
      var entity=vm.entity;
      if(entity.id!=null) {editEntity(entity);
      return;}
      GroupService.create(vm.entity ,function(){
        loadGroups();
        clear();
      });
    }

    function clear() {
      vm.entity = {};
    }

    function editEntity(entity){
      GroupService.update({id: entity.id},entity);
      loadGroups();
    }

    function edit(entity){
      vm.entity = {};
      angular.extend(vm.entity, entity);
    }

    function remove(entity) {
      GroupService.remove({id: entity.id});
      loadGroups();
    }
  }

})(angular);
