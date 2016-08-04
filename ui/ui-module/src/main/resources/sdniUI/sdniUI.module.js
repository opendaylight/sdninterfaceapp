/*
 * Copyright (c) 2015 Tata Consultancy services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * @author Himanshu Yadav 
 * @description : This js registers and configure all modules in SdniUI 
*/

define(['angularAMD', 'app/routingConfig', 'app/core/core.services', 'common/config/env.module','d3'], function(ng) {
  var sdniUIApp = angular.module('app.sdniUI', 
		  ['app.core', 'ui.router.state','config','pascalprecht.translate','restangular']);

  sdniUIApp.register = sdniUIApp; 

  
  sdniUIApp.factory("sdniLoaderSvc", function ($q) {

      var controllers = [
        'app/sdniUI/sdniUI.controller',
        'app/sdniUI/sdnController/sdnController.controller'
        ];
      var services = [
		'app/sdniUI/sdniUI.services',
	        'app/sdniUI/sdnController/sdnController.services'
        ];
      var directive = [
		'app/sdniUI/utils/js/autocomplete',
		'app/sdniUI/utils/js/formValidator'
      ];
  
      var loaded = $q.defer();

       require([].concat(controllers).concat(services).concat(directive), function () {
     		console.info("sdniLoaderSvc:  completed");
     		loaded.resolve(true);
    	});
 
      return loaded.promise; // return promise to wait for in $state transition
    });
  
  
  sdniUIApp.config(function($stateProvider, $compileProvider, $controllerProvider, $provide, NavHelperProvider, $translateProvider,RestangularProvider) {
    sdniUIApp.register = {
      controller : $controllerProvider.register,
      directive : $compileProvider.directive,
      factory : $provide.factory,
      service : $provide.service

    };
    
    $translateProvider.useStaticFilesLoader({
    			prefix: 'src/app/sdniUI/assets/data/application_properties_',
			    suffix: '.json'
      });
   


    NavHelperProvider.addControllerUrl('app/sdniUI/sdniUI.controller');
    NavHelperProvider.addToMenu('SdniUI', {
     "link" : "#/sdniUI",
     "active" : "main.sdniUI",
     "title" : "Sdni",
     "icon" : "",  // Add navigation icon css class here
     "page" : {
        "title" : "Sdni",
        "description" : "Sdni"
     }
    });

    var access = routingConfig.accessLevels;

    $stateProvider.state('main.sdniUI', {
        url: 'sdniUI',
        access: access.admin,
        views : {
            'content' : {
                templateUrl: 'src/app/sdniUI/sdniUI.tpl.html',
                controller: 'sdniUICtrl'     	
            }
        },
        resolve: {
            dummy: "sdniLoaderSvc"
          }
    });

    $stateProvider.state('main.sdniUI.sdnController', {
        url: '/sdnController',
        access: access.public,
        views : {
            'sdniContent' : {
                templateUrl: 'src/app/sdniUI/sdnController/sdnController.html',
                controller: 'sdniUIControllerCtrl'
            }
           
        }
    });
    
  
    RestangularProvider.setBaseUrl('http://localhost:8181/restconf/');
    RestangularProvider.setDefaultHeaders({'Authorization': 'Basic YWRtaW46YWRtaW4='});
    RestangularProvider.setResponseExtractor(function (response, operation, what) {
        return response;
      });
    RestangularProvider.setFullResponse(true);
    
    RestangularProvider.setErrorInterceptor(function ( response ) {
    	        // DON'T stop promise chain since error is not handled
    	        return true;
    	    
    });


    
  });

  return sdniUIApp;
});
