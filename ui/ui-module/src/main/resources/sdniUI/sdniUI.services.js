/*
 * Copyright (c) 2015 Tata Consultancy services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * @author Himanshu Yadav 
 * @description : This js provides services common all modules in SdniUI 
*/


define(['app/sdniUI/sdniUI.module'],function(sdniUIApp) {


  sdniUIApp.register.factory('sdniUISvc', function($http,$q,Restangular,$cacheFactory) {
  	  var cache = $cacheFactory('servicesCache');
	  var serviceUrls = cache.get("services");
	  
	  return {
		  
		  	getServiceUrlsFromCache: function() {
		  		var defer = $q.defer();
			  if (serviceUrls == undefined){
				 this.getSeviceApi().then(function(data) {
					  serviceUrls = data;
					  cache.put("services",data);
					  defer.resolve(serviceUrls);
				  });
			  }
			  else
				   defer.resolve(serviceUrls);
			  
			  return defer.promise;
			},

			getSeviceApi: function() {
							    	  var defer = $q.defer();
							    	  $http.get("src/app/sdniUI/assets/data/service_properties.json").then(function(properties) {
							    		  defer.resolve(properties.data);
										});
										return defer.promise;
		      						},
		    
		      						
		      	getService: function(service) {
		      		var defer = $q.defer();
					this.getServiceUrlsFromCache().then(function(serviceUrlsFromCache) {
		      		Restangular.all(serviceUrlsFromCache[service]).getList().then(function(response) {
		      				defer.resolve(response.data);
		      				},function(response) {
					    	    defer.reject(response);
		      				});
					
					});
					 return defer.promise;
				},
				
				postService: function(service,postJson) {
					var defer = $q.defer();
					this.getServiceUrlsFromCache().then(function(serviceUrlsFromCache) {
			      		Restangular.all(serviceUrlsFromCache[service]).post(('postdata',postJson)).then(function(response) {
		      				defer.resolve(response.data.output);
	      				},function(response) {
				    	    defer.reject(response);
					      });
					 
					});
					return defer.promise;
				}
		    }

  });



});
