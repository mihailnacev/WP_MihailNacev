/**
 * Created by Nacev on 24.10.2016.
 */
(function(angular){
  'use strict';

  function WpInputController($attrs,$log){
    var vm=this;
    vm.label=$attrs.wpLabel;
    vm.wpType=$attrs.wpType;
    vm.wpFocus=$attrs.wpFocus;
    console.log($attrs);
  }

  WpInputController.$inject = ['$attrs','$log'];

  angular.
  module('wp-angular-starter')
    .component('wpInput', {
    template:
    '<div class="form-group">'+
    '<label>{{$ctrl.label}}</label>'+
    '<input class="form-control" type="{{$ctrl.wpType}}" ng-model="$ctrl.wpModel" min="1" max="40" step="1" ng-focus="true" ng-cloak>'+
    '</div>',
    controller: WpInputController,
      bindings: {
        wpModel: '='
      }
  });
})(angular);
