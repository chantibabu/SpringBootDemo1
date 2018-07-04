var app = angular.module('app', []);
app.controller('postcontroller', function($scope, $http, $location) {
	$scope.submitForm = function(){
		var url = $location.absUrl() + "postcustomer";
		
		var config = {
                headers : {
                    'Accept': 'text/plain'
                }
        }
		var data = {
            name: $scope.name,
            doorNo: $scope.doorNo,
            city:$scope.city,
            district:$scope.district,
            state:$scope.state
        };
		
		$http.post("/api/saveValues", data).then(function (response) {
			$scope.postResultMessage = response.data;
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
		
	}
});
 
app.controller('getcontroller', function($scope, $http, $location) {
	$scope.getfunction = function(){
		$http.get("/api/getValues").then(function (response) {
			$scope.response = response.data
		}, function error(response) {
			$scope.postResultMessage = "Error with status: " +  response.statusText;
		});
	}
});