/**
 * Created by Nacev on 24.10.2016.
 */
(function (angular) {
  'use strict';


  angular.module('wp-angular-starter')
    .directive('focusMe', function () {
      return {
        restrict: 'A',
        scope: {
          focusMe: '='
        },
        link: function (scope, elt) {
          scope.$watch('focusMe', function (val) {
            if (val) {
              elt[0].focus();
            }
          });
        }
      };
    });
})(angular);
