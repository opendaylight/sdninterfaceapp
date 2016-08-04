define(['app/sdniUI/sdniUI.module'], function(sdniUIApp) {
	sdniUIApp.register.controller('sdniUIControllerCtrl',['$scope','$state','$filter','$timeout','$translate','sdnCtrlServiceFactory','sdniUISvc',function($scope,$state,$filter,$timeout,$translate,sdnCtrlServiceFactory,sdniUISvc){

      console.log("In sdnController controller");
		$scope.submitted = false;
		$scope.successMsg='';
		$scope.controllerIpAddr = function() {
			sdniUISvc.getService("GET_SDN_CONTROLLERS_IP").then(function(res) {

console.log("in controller res 2: " , res['sdn-controllers']['sdnController']);

$scope.ctrlList = res['sdn-controllers']['sdnController'];
      console.log("in controller res $scope.ctrlList[0] : " , $scope.ctrlList[0]);
		    		
		    },function(response) {
		    	if(response.status!=404){
		    		console.log("Error with status code in controller", response.status);
					$translate('ERROR_RETRIEVE_STREAMS').then(function (translations) {
			    		 $scope.successMsg =  translations;
			    	 });
					$scope.submitSuccess =false;
					$scope.submitted = true;
		    	}else{
		    		$translate('NO_STREAMS_FOUND').then(function (translations) {
			    		 $scope.successMsg =  translations;
			    	 });
		    		$scope.submitSuccess =true;
					$scope.submitted = true;
		    	}
		    });
		};


 $scope.controllerIpAddr();	
  }]);
});
