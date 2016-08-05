define(['app/sdniUI/sdniUI.module'], function(sdniUIApp) {

	sdniUIApp.register.factory('sdnCtrlServiceFactory', ['$http','$q','Restangular','sdniUISvc',function($http,$q,Restangular,sdniUISvc) {
		
console.log("In sdnControllerServiceFactory services" );

var defer = $q.defer();

console.log("Output in sdnControllerServiceFactory services defer: " + defer);

return defer.promise;


	/*		return
                         {
			        getsdnControllerIpAddr : function(){			
				 var defer = $q.defer();
				 var check ='';
				 sdniUISvc.getSeviceApi().then(function(data) {

						return Restangular.all(data.GET_SDN_CONTROLLERS_IP).post().then(function(res) {
console.log("Output in sdnController services res: " + res);
				    		  check=res.data.output;
console.log("Output in sdnController services: " + check);
				    		  defer.resolve(check);
				      },function(response) {
				    	    defer.reject(response);
				      });
                                           defer.resolve(check);
					});
					return defer.promise;
                     }
		
		} */
		
	}]);
	
});
