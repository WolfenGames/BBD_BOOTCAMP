
angular.module('h2n').controller('NewCarController', function ($scope, $location, locationParser, flash, CarResource ) {
    $scope.disabled = false;
    $scope.$location = $location;
    $scope.car = $scope.car || {};
    

    $scope.save = function() {
        var successCallback = function(data,responseHeaders){
            var id = locationParser(responseHeaders);
            flash.setMessage({'type':'success','text':'The car was created successfully.'});
            $location.path('/Cars');
        };
        var errorCallback = function(response) {
            if(response && response.data) {
                flash.setMessage({'type': 'error', 'text': response.data.message || response.data}, true);
            } else {
                flash.setMessage({'type': 'error', 'text': 'Something broke. Retry, or cancel and start afresh.'}, true);
            }
        };
        CarResource.save($scope.car, successCallback, errorCallback);
    };
    
    $scope.cancel = function() {
        $location.path("/Cars");
    };
});