define(['app/sdniUI/sdniUI.module'], function(sdniUIApp) {
		
			sdniUIApp.register.service('filteredDashboardListService', function () {
		    
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
		    
		    this.searched = function (valLists, toSearch) {
		        return _.filter(valLists, function (i) {
		            return searchUtil(i, toSearch);
		        });
		    };
		    
		    function searchUtil(item, toSearch) {
				if(item.title != '' && item.title !=undefined && item.title !=null )
					return ((item.title).toLowerCase().indexOf(toSearch.toLowerCase()) > -1) ? true : false;
				
		    	return true;
			}
		    
		    this.deleteDashboard = function (valLists, deletedDashboard) {
		        return _.without(valLists, _.findWhere(valLists, {title: deletedDashboard}));
		    };
		
		});


});
