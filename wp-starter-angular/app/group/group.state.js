/**
 * Created by Nacev on 07.10.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .config(registerState);


  registerState.$inject = ['$stateProvider'];

  function registerState($stateProvider) {

    $stateProvider.state('group', {
      url: '/groups',
      templateUrl: 'app/group/group.view.html',
      controller: 'GroupController',
      controllerAs: 'vm'
    });
  }

})(angular);
