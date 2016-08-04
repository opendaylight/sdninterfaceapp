/*
 * Copyright (c) 2015 Tata Consultancy services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * @author Himanshu Yadav 
 * @description : This js provides utility functions for SdniUI 
*/

define(['app/sdniUI/sdniUI.module'], function(sdniUIApp) {
		
			sdniUIApp.register.service('filteredListService', function () {
		
		    this.searched = function (valLists, toSearch) {
		        return _.filter(valLists,
		        function (i) {
		            return searchUtil(i, toSearch);
		        });
		    };
		    
		    this.deleteAlert = function (valLists, deletedAlert) {
		        return _.without(valLists, _.findWhere(valLists, {alertName: deletedAlert}));
		    };
		    
		    this.deleteStream = function (valLists, deletedStream) {
		        return _.without(valLists, _.findWhere(valLists, {title: deletedStream}));
		    };
		    
		    this.paged = function (valLists, pageSize) {
		        retVal = [];
		        for (var i = 0; i < valLists.length; i++) {
		            if (i % pageSize === 0) {
		                retVal[Math.floor(i / pageSize)] = [valLists[i]];
		            } else {
		                retVal[Math.floor(i / pageSize)].push(valLists[i]);
		            }
		        }
		        return retVal;
		    };
		    
		    this.searchItem = function (valLists, toSearch, property) {
		    	 for (var i = 0; i < valLists.length; i++) {
		    		 var obj = valLists[i];
		    		 if(obj[property] == toSearch)
		    		 	return valLists[i];
		    	 }
		    };
		
		});

		
		function searchUtil(item, toSearch) {
			if(item.alertName != '' && item.alertName !=undefined && item.alertName !=null )
				return ((item.alertName).toLowerCase().indexOf(toSearch.toLowerCase()) >  -1) ? true : false;
			if(item.title != '' && item.title !=undefined && item.title !=null )
			    return ((item.title).toLowerCase().indexOf(toSearch.toLowerCase()) > -1 ) ? true : false;
			if(item.field != '' && item.field !=undefined && item.field !=null )
			    return ((item.field).toLowerCase().indexOf(toSearch.toLowerCase()) > -1 ) ? true : false;
		
		}



});
