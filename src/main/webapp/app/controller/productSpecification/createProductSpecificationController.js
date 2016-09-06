

angular.module('nsfTraqtionApp').controller('createProductSpecificationCtrl', ['$scope', '$state', '$compile', '$rootScope', 'productSpecificationFactory', 'nsfTraqtionService', 'nsfTraqtionConstants', function ($scope, $state, $compile, $rootScope, productSpecificationFactory, nsfTraqtionService, nsfTraqtionConstants) {

        var productHeaderData = nsfTraqtionService.productHeaderData;
//                    alert('success --- ' + JSON.stringify(productHeaderData));

        $('#btn_createnewSpec').removeClass('visibility-hidden');
        setProductContentArea();
        $scope.createProdspecification = {};
        var dialog = $("#newProductSpecDialog").data("kendoWindow");
        $scope.createProdspecification.productSpecificationId = "";
        $scope.createProdspecification.businsessId = "";
        $scope.createProdspecification.version = "0.001";
        $scope.createProdspecification.active = true;
        $scope.createProdspecification.specificationStatus = "Client Draft";
        $scope.createProdspecification.commercialStatus = "In-Progress";

        productSpecificationFactory.getProductSpecBusinessNameDropdownList().then(function (data) {

            $scope.createProdBusinessName = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "business",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };
        },
                function () {
                    $scope.createProdBusinessName = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "business",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });


        productSpecificationFactory.getProductSpecCategoryDropdownList().then(function (data1) {

            $scope.createProdSpecCategory = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "category",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data1,
                dataBound: function (e) {
                    var categoryDropdownList = $("#createProdSpec_category").data("kendoDropDownList");

                    if (nsfTraqtionConstants.createSpecificationType === "GEN") {
                        $(".buisinessNameBlock").css("display", "none");
                        categoryDropdownList.enable(true);
                    } else if (nsfTraqtionConstants.createSpecificationType === "COUPLED") {
                        $(".buisinessNameBlock").css("display", "block");
                        categoryDropdownList.enable(false);
                    } else if (nsfTraqtionConstants.createSpecificationType === "DECOUPLED") {
                        $(".buisinessNameBlock").css("display", "block");
                        categoryDropdownList.enable(true);
                    }
                }
            };


        },
                function () {
                    $scope.createProdSpecCategory = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "category",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });

        productSpecificationFactory.getProductSpecBrandDropdownList().then(function (data) {
            $scope.createProdSpecBrand = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "brand",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };
        },
                function () {
                    $scope.createProdSpecBrand = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "brand",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });

        productSpecificationFactory.getProductSpecTypeDropdownList().then(function (data) {
            $scope.createProdSpecType = {
                //placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "SpecType",
                dataValueField: "id",
                optionLabel: "please select",
                enable: false,
                dataSource: data
            };
        },
        function(){
             $scope.createProdSpecType = {
                //placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "SpecType",
                dataValueField: "id",
                optionLabel: "please select",
                enable: false,
                dataSource: []
            };
        });

        productSpecificationFactory.getProductSpecOwnerDropdownList().then(function (data) {
            $scope.createProdSpecOwner = {
                //placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "SpecOwner",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };


        },
        function(){
             $scope.createProdSpecOwner = {
                //placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "SpecOwner",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: []
            };
        });


        $scope.changeCategory = function (option) {
            var specTypeDropdownList = $("#createProdSpec_specificationType").data("kendoDropDownList");
            if (option.id === "") {
                specTypeDropdownList.enable(false);
            } else {
                specTypeDropdownList.enable(true);
            }
        };
        $scope.changeBusinessName = function (option) {
            var categoryDropdownList = $("#createProdSpec_category").data("kendoDropDownList");
            if (nsfTraqtionConstants.createSpecificationType === "COUPLED") {

                if (option.id === "") {
                    categoryDropdownList.enable(false);
                } else {
                    categoryDropdownList.enable(true);
                }
            } else {
                categoryDropdownList.enable(true);
            }
        };
        $("#newProductSpecDialog").kendoWindow({
            title: "Customer 000 details",
            height: 160,
            width: 400,
            visible: false,
            modal: true
        });
        $scope.createnewSpecification = function () {


            $scope.ProdSpecOwnerName = $scope.selectedOwner.SpecOwner;
            dialog.center();
            dialog.open();
            dialog.title('Create New Primary Specification');
            var prodSpectPopup = '<br/><div class="row">' +
                    '<div class="col-lg-12 col-sm-12 col-md-12">' +
                    '<span>A new Primary Specification for ' + $scope.createProdspecification.productTitle + ' will now be created.</span><br/>' +
                    '</div>' +
                    '<div class="col-lg-12 col-sm-12 col-md-12">' +
                    '<span>' + $scope.ProdSpecOwnerName + ' will be the Product owner.</span><br/>' +
                    '</div>' +
                    '<div class="col-lg-12 col-sm-12 col-md-12">' +
                    '<span>Do you want to Proceed?</span><br/><br/>' +
                    '</div>' +
                    '<div class="col-lg-12 col-sm-12 col-md-12">' +
                    '<div class="row">' +
                    '<div class="col-lg-2 col-sm-2 col-md-2"></div>' +
                    '<div class="col-lg-4 col-sm-4 col-md-4">' +
                    '<button ng-click="conformNewSpecification()" class="k-primary btn_primary kendoBtn">Confirm</button>' +
                    '</div>' +
                    '<div class="col-lg-4 col-sm-4 col-md-4">' +
                    '<button ng-click="cancelNewSpecification()" class="k-primary btn_primary kendoBtn">Cancel</button>' +
                    '</div>' +
                    '<div class="col-lg-2 col-sm-2 col-md-2"></div>' +
                    '</div>' +
                    '</div>' +
                    '</div>';
            var prodSpectPopupTemplate = $compile(prodSpectPopup)($scope);
            dialog.content(prodSpectPopupTemplate);
        };
        $scope.conformNewSpecification = function () {
            dialog.close();
            productSpecificationFactory.addNewProductSpecification($scope.createProdspecification).then(function (data) {


                dialog.center();
                dialog.open();
                dialog.title('New Primary Specification Created');
                var prodSpectPopup = '<br/><div class="row">' +
                        '<div class="col-lg-12 col-sm-12 col-md-12">' +
                        '<span>A new Primary Specification for ' + $scope.createProdspecification.productTitle + ' is created.</span><br/>' +
                        '</div>' +
                        '<div class="col-lg-12 col-sm-12 col-md-12">' +
                        '<span>' + $scope.ProdSpecOwnerName + ' will be the Product owner.</span><br/>' +
                        '</div>' +
                        '<div class="col-lg-12 col-sm-12 col-md-12"><br/>' +
                        '<div class="row">' +
                        '<div class="col-lg-12 col-sm-12 col-md-12 text-center">' +
                        '<button ng-click="dismissCreatedSpecification()" style="width: 60px;" class="k-primary btn_primary kendoBtn">OK</button>' +
                        '</div>' +
                        '</div>' +
                        '</div>' +
                        '</div>';
                var prodSpectPopupTemplate = $compile(prodSpectPopup)($scope);
                dialog.content(prodSpectPopupTemplate);
                $('.newSpecheaderIcons').removeClass('visibility-hidden');
                $('#btn_createnewSpec').addClass('visibility-hidden');
            });
        };
        $scope.cancelNewSpecification = function () {
            dialog.close();
        };
        $scope.dismissCreatedSpecification = function () {
            dialog.close();
        };
    }]);
$(window).resize(function () {
    setProductContentArea();
});
function setProductContentArea() {
    var contentHeight = Number(($(window).height()) - 270);
    $('.productContent').css('height', contentHeight);
    $('.productSpecSubMenu').css('height', contentHeight);
}
