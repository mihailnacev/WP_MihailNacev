/**
 * Created by Nacev on 15.10.2016.
 */
(function (angular){
    use:'strict';

  angular
    .module('wp-angular-starter')
    .config(registerState);

  registerState.$inject=['$stateProvider'];

  function registerState($stateProvider) {
    $stateProvider.state('defaultPage',{
      url:'/',
      templateUrl:'app/default-page/default-page.view.html'
    });
  }

})(angular);
