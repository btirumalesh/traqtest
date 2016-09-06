

angular.module('nsfTraqtionApp').controller('productSpecificationCtrl', ['$scope', '$state', '$rootScope', 'nsfTraqtionFactory', function ($scope, $state, $rootScope, nsfTraqtionFactory) {
        $('#productSpecUL li span:nth-child(2)').css('display', 'none');
        setProductContentArea();

        $scope.submenuRevealed = false;
        $scope.revealSubmenu = function ($this) {



            $("#productSpecUL li").animate({
                width: "100%"
            }, {
                duration: 300,
                complete: function () {
                    $('#productSpecUL li span:nth-child(2)').css('display', 'block');
                    $('.productSpecSubMenu').css('overflow-y', 'auto');
                    $('.productSpecSubMenu').css('background', '#BAC425');
                    $('.productSpecSubMenu').mCustomScrollbar();
                }
            });
            $scope.submenuRevealed = true;

        };
        $scope.closeSubmenu = function ($this) {


            $('#productSpecUL li span:nth-child(2)').css('display', 'none');
            $('.productSpecSubMenu').css('background', 'transparent');
            $('.productSpecSubMenu').mCustomScrollbar("destroy");
            $('.productSpecSubMenu').css('overflow-y', 'hidden');
            $("#productSpecUL li").animate({
                width: "60px"
            }, {
                duration: 300,
                complete: function () {

                }
            });
            $scope.submenuRevealed = false;

        };



        $scope.$watch("submenuRevealed", function () {

            if ($scope.submenuRevealed === false) {

                $('#productSpecUL li:not(:first-child)').hover(
                        function (event) {
                            $('#productSpecUL li:not(:first-child) span:nth-child(2)').css('display', 'none');
                     
                            $(event.currentTarget).animate({
                                width: "100%"
                            }, {
                                duration: 300,
                                complete: function () {

                                }
                            });
                            $(event.currentTarget).find('span:nth-child(2)').css('display', 'block');
                        },
                        function (event) {

                            $(event.currentTarget).animate({
                                width: "60px"
                            }, {
                                duration: 300,
                                complete: function () {

                                }
                            });
                            $(event.currentTarget).find('span:nth-child(2)').css('display', 'none');
                        }
                );
            } else {
                $('#productSpecUL li:not(:first-child)').unbind('mouseenter mouseleave');

            }

        });

        $state.go('productSpec.createProductSpecification');
    }]);


$(window).resize(function () {
    setProductContentArea();
});

function setProductContentArea() {
    var contentHeight = Number(($(window).height()) - 270);
    $('.productContent').css('height', contentHeight);
    $('.productSpecSubMenu').css('height', contentHeight);
}

$(document).on("click", "#productSpecUL li:not(:first-child)", function (event) {
    $("#productSpecUL li").removeClass('active');
    $("#productSpecUL li i").removeClass('activeMenu');
    $("#productSpecUL li span:nth-child(2)").removeClass('activeMenu');
    $(event.currentTarget).addClass('active');
    $(event.currentTarget).find('span:nth-child(2)').addClass('activeMenu');
    $(event.currentTarget).find('i').addClass('activeMenu');
});









