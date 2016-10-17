/**
 * Created by Nacev on 08.10.2016.
 */
(function (angular) {
  'use strict';

  angular
    .module('wp-angular-starter')
    .config(registerState);


  registerState.$inject = ['$stateProvider'];
   var $log = {
    debug: function (message) {
      if (console && typeof console.log === 'function') {
        console.log(message);
      }
    }
  };
  function registerState($stateProvider) {

    $stateProvider.state('store', {
      url: '/store',
      templateUrl: 'app/AngularGemStore/store.view.html',
      controller: 'StoreController',
      controllerAs: 'vm'
    });

    $log.debug('State store initialized');
  }

})(angular);
