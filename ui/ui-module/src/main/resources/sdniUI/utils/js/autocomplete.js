/*
 * Copyright (c) 2015 Tata Consultancy services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * @author Himanshu Yadav 
 * @description : This js provides utility functions for SdniUI query search
*/
define(['app/sdniUI/sdniUI.module'], function(sdniUIApp) {
	sdniUIApp.register.directive('query',function () {

	    return {
	        restrict: 'EA',
	        scope: {
	            "id": "@id",
	            "placeholder": "@placeholder",
	            "selectedObject": "=selectedobject",
	            "url": "@url",
	            "titleField": "@titlefield",
	            "inputClass": "@inputclass",
	            "userPause": "@pause",
	            "localData": "=localdata",
	            "searchFields": "@searchfields",
	            "minLengthUser": "@minlength",
	            "queryString":"=querystr",
	            	"searchStr":"=querystr"
	        },
	        template: '<div class="autocomplete-holder"><input id="{{id}}_value" ng-model="searchStr" type="text" placeholder="{{placeholder}}" class="{{inputClass}}" style="width: 650px;height: 30px;" ng-keyup="keyPressed($event)"/><div id="{{id}}_dropdown" class="autocomplete-dropdown" style="width: 650px;" ng-if="showDropdown"><div class="autocomplete-searching" ng-show="searching">Searching...</div><div class="autocomplete-searching" ng-show="!searching && (!results || results.length == 0)">No results found</div><div class="autocomplete-row" ng-repeat="result in results" ng-click="selectResult(result)" ng-mouseover="hoverRow()" ng-class="{\'autocomplete-selected-row\': $index == currentIndex}"><div>{{result.title}}</div></div></div></div>',
	        controller: function ( $scope ) {
	            $scope.currentIndex = null;
	            $scope.searchTimer = null;
	            $scope.searching = false;
	            $scope.spaceFound = false;
	            $scope.optionSelected = false;
	            $scope.pause = 500;
	            $scope.minLength = 3;
	            $scope.queryString ='';
	            $scope.searchStr ='';
	
	            if ($scope.minLengthUser && $scope.minLengthUser != "") {
	                $scope.minLength = $scope.minLengthUser;
	            }
	
	            if ($scope.userPause) {
	                $scope.pause = $scope.userPause;
	            }
	
	            $scope.processResults = function(responseData) {
	                if (responseData && responseData.length > 0) {
	                    $scope.results = [];
	
	                    var titleFields = [];
	                    if ($scope.titleField && $scope.titleField != "") {
	                        titleFields = $scope.titleField.split(",");
	                    }
	
	                    for (var i = 0; i < responseData.length; i++) {
	                        var titleCode = "";
	
	                        for (var t = 0; t < titleFields.length; t++) {
	                            if (t > 0) {
	                                titleCode = titleCode +  " + ' ' + ";
	                            }
	                            titleCode = titleCode + "responseData[i]." + titleFields[t];
	                        }
	
	                        var resultRow = {
	                            title: eval(titleCode),
	                        }
	
	                        $scope.results[$scope.results.length] = resultRow;
	                    }
	
	
	                } else {
	                    $scope.results = [];
	                }
	            }
	
	            $scope.searchTimerComplete = function(str) {
	
	                if (str.length >= $scope.minLength) {
	                    if ($scope.localData) {
	                        var searchFields = $scope.searchFields.split(",");
	
	                        var matches = [];
	
	                        for (var i = 0; i < $scope.localData.length; i++) {
	                            var match = false;
	
	                            for (var s = 0; s < searchFields.length; s++) {
	                                var evalStr = 'match = match || ($scope.localData[i].' + searchFields[s] + '.toLowerCase().indexOf("' + str.toLowerCase() + '") >= 0)';
	                                eval(evalStr);
	                            }
	
	                            if (match) {
	                                matches[matches.length] = $scope.localData[i];
	                            }
	                        }
	
	                        $scope.searching = false;
	                        $scope.processResults(matches);
	                        $scope.$apply();
	
	
	                    } else {
	                        $http.get($scope.url + str, {}).
	                            success(function(responseData, status, headers, config) {
	                                $scope.searching = false;
	                                $scope.processResults(responseData);
	                            }).
	                            error(function(data, status, headers, config) {
	                                console.log("error");
	                            });
	                    }
	                }
	
	            }
	
	            $scope.hoverRow = function(index) {
	                $scope.currentIndex = index;
	            }
	
	            $scope.keyPressed = function(event) {
	                if (!(event.which == 38 || event.which == 40 || event.which == 13)) {
	                    if (!$scope.searchStr || $scope.searchStr == "") {
	                        $scope.showDropdown = false;
	                    } else {
	                    	if(event.which == 32 )
					$scope.spacefound=true;
	                    	var currentSearchStr = $scope.searchStr;
	                    	if($scope.searchStr.lastIndexOf(' ') >= 0 && $scope.optionSelected){
	                    		$scope.queryString = $scope.searchStr;
	                    		$scope.spacefound = true;
	                    		currentSearchStr = $scope.searchStr.substr(($scope.searchStr.lastIndexOf(' ')+1),($scope.searchStr.length)); 
	                    	}
	                    	
	                        if (currentSearchStr.length >= $scope.minLength) {
	                        	if((!$scope.optionSelected || $scope.spacefound)){
	                        		$scope.showDropdown = true;
						$scope.queryString = $scope.searchStr;
	                        	}
	                        	
	                        	
	                            $scope.currentIndex = -1;
	                            $scope.results = [];
	
	                            if ($scope.searchTimer) {
	                                clearTimeout($scope.searchTimer);
	                            }
	
	                            $scope.searching = true;
	
	                            $scope.searchTimer = setTimeout(function() {
	                                $scope.searchTimerComplete(currentSearchStr);
	                            }, $scope.pause);
	                        }
	
	
	                    }
	
	                } else {
	                    event.preventDefault();
	                }
	            }
	
	            $scope.selectResult = function(result) {
	            	$scope.queryString = $scope.queryString.substr(0,($scope.queryString.lastIndexOf(' ')+1));
	                $scope.searchStr =result.title;
	                $scope.queryString = $scope.queryString + $scope.searchStr;
	                $scope.searchStr = $scope.queryString;
	                $scope.selectedObject = result;
	                $scope.showDropdown = false;
	                $scope.optionSelected = true;
	                $scope.results = [];
	            }
	        },
	
	        link: function($scope, elem, attrs, ctrl) {
	        	
	            elem.bind("keyup", function (event) {
	                if(event.which === 40) {
	                    if (($scope.currentIndex + 1) < $scope.results.length) {
	                        $scope.currentIndex ++;
	                        $scope.$apply();
	                        event.preventDefault;
	                        event.stopPropagation();
	                    }
	
	                    $scope.$apply();
	                } else if(event.which == 38) {
	                    if ($scope.currentIndex >= 1) {
	                        $scope.currentIndex --;
	                        $scope.$apply();
	                        event.preventDefault;
	                        event.stopPropagation();
	                    }
	
	                } else if (event.which == 13) {
	                    if ($scope.currentIndex >= 0 && $scope.currentIndex < $scope.results.length) {
	                        $scope.selectResult($scope.results[$scope.currentIndex]);
	                        $scope.$apply();
	                        event.preventDefault;
	                        event.stopPropagation();
	                    } else {
	                        $scope.results = [];
	                        $scope.$apply();
	                        event.preventDefault;
	                        event.stopPropagation();
	                    }
	
	                } else if (event.which == 27) {
	                    $scope.results = [];
	                    $scope.showDropdown = false;
	                    $scope.$apply();
	                } else if (event.which == 8) {
	                    $scope.selectedObject = null;
	                    $scope.$apply();
	                }
	            });
	
	
	        }
	    };
	});
});
