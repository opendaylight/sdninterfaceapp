/*
 * Copyright (c) 2015 Tata Consultancy services and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 * @author Himanshu Yadav 
 * @description : This js provides utility functions for client side Form validations
*/
define(['app/sdniUI/sdniUI.module'], function(sdniUIApp) {
	var ALERT_CONDITION_INTEGER_REGEXP = /^\-?\d+$/;
	sdniUIApp.register.directive('validBusinessInt',function () {
		return {
			    require: 'ngModel',
			    scope :{
			    	'validationMsg' = '@validationMsg'
			    },
			    
			    link: function(scope, elm, attrs, ctrl) {
			      ctrl.$validators.integer = function(modelValue, viewValue) {
			        if (ctrl.$isEmpty(modelValue)) {
			          //valid as its not empty
			          return true;
			        }
			        
			        if (ctrl.$isEmpty(modelValue)) {
					     if(modelValue > 0)
				          return true;
				        }
			        
			        if (ALERT_CONDITION_INTEGER_REGEXP.test(viewValue)) {
			          // it is valid as its satisfying to be integer condition
			          return true;
			        }

			        // otherwise its invalid value
			        return false;
			      };
			    }
			  };
	});
});
