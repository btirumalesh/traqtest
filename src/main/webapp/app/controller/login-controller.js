

angular.module('nsfTraqtionApp').controller('nsfTraqtionloginctrl', ['$scope', '$state', '$rootScope', '$window', 'nsfTraqtionFactory', function ($scope, $state, $rootScope, $window, nsfTraqtionFactory) {
	
	/*$scope.headerFile = 'loginHeader';
	$scope.footerFile = 'loginFooter';
	
	/$window.sessionStorage.setItem("showLoginHeader","show");
	$window.sessionStorage.getItem("showLoginHeader");
	$scope.showLoginHeader = true;*/
	
	
	
        $scope.formValues = {};
        $scope.submitForm = function () {
            alert(JSON.stringify($scope.formValues));
            nsfTraqtionFactory.callSampleService($scope.formValues).then(function (data) {

                alert(JSON.stringify(data));


            });
        };
        $scope.gotodashboard = function(){
        	$state.go('dashboard');
        }
    }]); 

$(function () {
    setContentArea();
});


function setContentArea() {
    var contentHeight = Number(($(window).height()) - 260);

    setTimeout(function () {
        $('.formContent').css('height', contentHeight);
    }, 100);

}

$(window).resize(function () {
    setContentArea();
});
	