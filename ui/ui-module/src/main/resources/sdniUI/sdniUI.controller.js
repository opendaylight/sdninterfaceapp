/*
 * Copyright (c) 2015 Tata Consultancy services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * @author Himanshu Yadav 
 * description : This js provides control functions common to all modules in SdniUI
*/

define(['app/sdniUI/sdniUI.module','app/sdniUI/sdniUI.services'], function(sdniUIApp) {

  sdniUIApp.register.controller('sdniUICtrl', ['$scope', '$rootScope', 'sdniUISvc', function($scope, $rootScope, sdniUISvc) {

    $rootScope['section_logo'] = "sdninterfaceapp"; 
    $scope.sdniUIInfo = {};
    $scope.data = "Sdni";

  }]);


});
