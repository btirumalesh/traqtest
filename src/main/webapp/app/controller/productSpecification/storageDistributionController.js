

angular.module('nsfTraqtionApp').controller('storageDistributionCtrl', ['$scope', '$state', '$rootScope', 'nsfTraqtionFactory', function ($scope, $state, $rootScope, nsfTraqtionFactory) {

        setProductContentArea();


    }]);


$(window).resize(function () {
    setProductContentArea();
});

function setProductContentArea() {
    var contentHeight = Number(($(window).height()) - 270);
    $('.productContent').css('height', contentHeight);
    $('.productSpecSubMenu').css('height', contentHeight);
}