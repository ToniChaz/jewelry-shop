'use strict';

/**
 * @ngdoc directive
 * @name jewelryShopApp.directive:liveSearch
 * @description
 * # liveSearch
 */
angular.module('jewelryShopApp')
  .directive('liveSearch', function ($compile, $timeout) {
    return {
      restrict: 'E',
      replace: true,
      scope: {
        liveSearchCallback: '=',
        liveSearchSelect: '=?',
        liveSearchItemTemplate: '@',
        liveSearchWaitTimeout: '=?',
        liveSearchMaxResultSize: '=?',
        liveSearchSelected: '='
      },
      template: '<input ng-blur="onBlur()" ng-focus="onFocus()" type="text" />',
      link: function (scope, element, attrs) {
        var timeout;

        scope.results = [];
        scope.visible = false;
        scope.selectedIndex = -1;

        scope.onBlur = function () {
          $timeout(function () {
            scope.visible = false;
          }, 200);
        };

        scope.onFocus = function () {
          if (scope.results.length > 0) {
            scope.visible = true;
          }
        };

        scope.select = function (index) {
          scope.selectedIndex = index;
          scope.visible = false;
        };

        scope.isSelected = function (index) {
          return (scope.selectedIndex === index);
        };

        scope.$watch('selectedIndex', function (newValue) {
          var item = scope.results[newValue];
          if (item) {
            if (attrs.liveSearchSelect) {
              element.val(item[attrs.liveSearchSelect]);
            } else {
              element.val(item);
            }
            scope.liveSearchSelected(item);
            scope.results = [];
          }
        });

        scope.$watch('visible', function (newValue) {
          if (newValue === false) {
            return;
          }
          scope.width = element[0].clientWidth;
          var offset = getPosition(element[0]);
          scope.top = offset.y + element[0].clientHeight + 1 + 'px';
          scope.left = offset.x + 'px';
        });

        element[0].onkeydown = function (e) {
          //keydown
          if (e.keyCode === 40) {
            if (scope.selectedIndex + 1 === scope.results.length) {
              scope.selectedIndex = 0;
            } else {
              scope.selectedIndex++;
            }
          }
          //keyup
          else if (e.keyCode === 38) {
            if (scope.selectedIndex === 0) {
              scope.selectedIndex = scope.results.length - 1;
            } else if (scope.selectedIndex === -1) {
              scope.selectedIndex = 0;
            } else {
              scope.selectedIndex--;
            }
          }
          //keydown or keyup
          if (e.keyCode === 13) {
            scope.visible = false;
          }

          //unmanaged code needs to force apply
          scope.$apply();
        };

        element[0].onkeyup = function (e) {
          if (e.keyCode === 13 || e.keyCode === 37 || e.keyCode === 38 || e.keyCode === 39 || e.keyCode === 40) {
            return false;
          }
          var target = element;
          // Set Timeout
          $timeout.cancel(timeout);
          // Set Search String
          var vals = target.val().split(',');
          var searchString = vals[vals.length - 1].trim();
          // Do Search
          if (searchString.length < 3 || searchString.length > 9) {
            scope.visible = false;
            //unmanaged code needs to force apply
            scope.$apply();
            return;
          }
          timeout = $timeout(function () {
            var results = [];
            var promise = scope.liveSearchCallback.call(null, {query: searchString});
            promise.then(function (dataArray) {
              if (dataArray) {
                results = dataArray.slice(0, (scope.liveSearchMaxResultSize || 20) - 1);
              }
              scope.visible = true;
            });
            promise.finally(function () {
              scope.selectedIndex = -1;
              scope.results = results.filter(function (elem, pos) {
                return results.indexOf(elem) === pos;
              });
            });
          }, scope.liveSearchWaitTimeout || 100);
        };

        var getPosition = function (element) {
          var xPosition = 0;
          var yPosition = 0;

          while (element) {
            xPosition += (element.offsetLeft - element.scrollLeft + element.clientLeft);
            yPosition += (element.offsetTop - element.scrollTop + element.clientTop);
            element = element.offsetParent;
          }
          return {x: xPosition, y: yPosition};
        };

        var itemTemplate = element.attr('live-search-item-template') || '{{result}}';
        var template = '<ul ng-show="visible" ng-style=\'{"top":top,"left":left,"width":width}\' class="searchresultspopup"><li ng-class=\'{ "selected" : isSelected($index) }\' ng-click="select($index)" ng-repeat="result in results">' + itemTemplate + '</li></ul>';
        var searchPopup = $compile(template)(scope);
        document.body.appendChild(searchPopup[0]);
      }
    };
  });
