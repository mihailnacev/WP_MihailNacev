/**
 * Created by Nacev on 25.10.2016.
 */
(function(angular){
  'use strict';

  function GroupSelectController($attrs,$log,GroupService){
    var vm=this;
    console.log($attrs);
    vm.groups=[];
    GroupService.getAll().then(function (data) {
      vm.groups = data;
    });
  }

  GroupSelectController.$inject = ['$attrs','$log','GroupService'];

  angular.
  module('wp-angular-starter')
    .component('groupSelect', {
      template: '<ui-select ng-model="$ctrl.wpModel" title="Choose group for a student">'+
    '<ui-select-match placeholder="Choose group for a student...">'+
    '<span>{{$select.selected.name}}</span>'+
    '</ui-select-match>'+
  '<ui-select-choices repeat="item in ($ctrl.groups | filter:$select.search )" position="auto">'+
    '{{item.name}}'+
 ' </ui-select-choices>'+
  '</ui-select>',
      controller: GroupSelectController,
      bindings: {
        wpModel: '='
      }
    });
})(angular);
