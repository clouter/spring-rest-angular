var app = angular.module('sports', [ "ngResource" ]);

app.controller('SportsController', [ '$scope', '$http',
                                     
	function($scope, $http) {
		$scope.getSports = function() {
			$http.get('/sports').success(function(data) {
				$scope.sports = data;
			});
		}
		
		$scope.addSport = function() {
			$http.post('/sports', 
				{
					name : $scope.name,
					players : $scope.players,
				}
			).success(function(data) {
				$scope.msg = 'Sport entry' + data.id + ' has been added.';
				$scope.getSports();
			}).error(function(data) {
				$scope.msg = 'Error: ' + data.error + ' Name and Players fields must not be empty.';
			});
		}
		
		$scope.updateSport = function() {
			$http.put('/sports/' + id, 
				{
					id : $scope.id,
					name : $scope.name,
					players : $scope.players,
				}
			).success(function(data) {
				$scope.msg = 'Sport ' + data.name + ' has been updated.';
				$scope.getSports();
			}).error(function(data) {
				if (data.status == 'NOT_FOUND') {
					$scope.msg = 'Error: ' + data.message;	
				} else {
					$scope.msg = 'Error: ' + data.error + ' Id, Name and Players fields must not be empty.';
				}
			});
		}
		
		
		$scope.delSport = function(id) {
			$http.delete('/sports/' + id, 
				{
					id : $scope.id,
				}
			).success(function(data) {
				$scope.msg = 'Sport' + data.id + ' has been deleted.';
				$scope.getSports();
			}).error(function(data) {
				$scope.msg = 'Error: ' + data.message;
			});
		}
		
		
		$scope.findSport = function(id) {
			$http.get('/sports/' + id, 
				{
					id : $scope.id,
				}
			).success(function(data) {
				$scope.msg = 'Sport found.';
				$scope.getSports();
			}).error(function(data) {
				$scope.msg = 'Error: ' + data.message;
			});
		}
		
} ]);