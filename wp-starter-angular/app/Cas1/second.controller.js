/**
 * Created by Nacev on 04.10.2016.
 */
(function (angular) {
  use:'strict'

  angular.module('wp-angular-starter')
    .controller('SecondController',SecondController);
  SecondController.$inject=['$log'];

  function SecondController($log){
    var vm=this;
    vm.name='WP';
    vm.to='Nacev';
  }

})(angular);
