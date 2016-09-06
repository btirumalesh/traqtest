

angular.module('nsfTraqtionApp').controller('searchProductsCtrl', ['$scope', '$state', '$rootScope', '$compile', 'productSpecificationFactory', 'nsfTraqtionService', function ($scope, $state, $rootScope, $compile, productSpecificationFactory, nsfTraqtionService) {
        setSearchProductContentArea();
        configKendoControls();
        kendo.ui.progress($(document.body), true);
        $('#siteCode').data('kendoMaskedTextBox').readonly();
        $scope.productSearch = {
            categoryType: "myCategory"
        };

        $scope.resetForm = function () {
            $scope.master = {};
            $scope.productSearch = angular.copy($scope.master);
            $scope.productSearch.categoryType = "myCategory";
            if (nsfTraqtionService.gridCreated === true) {
                $("#kendoGrid").remove();

                $("#noResultsFound").text("");
            } else {
                $("#kendoGrid").text("");
            }
        };

        $scope.Language = {
            //placeholder: "Select Job Title...", // Only for kendo-multi-select
            dataTextField: "language",
            dataValueField: "id",
            optionLabel: "Select Language",
            dataSource: {
                data:
                        [
                            {
                                id: "111",
                                language: "English-US"
                            },
                            {
                                id: "112",
                                language: "English-UK"
                            },
                            {
                                id: "113",
                                language: "French"
                            },
                            {
                                id: "114",
                                language: "Spanish"
                            },
                            {
                                id: "115",
                                language: "Japanese"
                            }
                        ]
            }
        };

        productSpecificationFactory.getProductSearchCreatedByDropdownList().then(function (data) {

            $scope.productSearchCreatedBy = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "business",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };
        },
                function () {
                    $scope.productSearchCreatedBy = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "business",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });
        productSpecificationFactory.getProductSearchSpecificationStatusDropdownList().then(function (data) {

            $scope.productSearchSpecificationStatus = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "business",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };
        },
                function () {
                    $scope.productSearchSpecificationStatus = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "business",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });

        productSpecificationFactory.getProductSearchSpecificationTypeDropdownList().then(function (data) {

            $scope.productSearchSpecificationType = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "business",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };
        },
                function () {
                    $scope.productSearchSpecificationType = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "business",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });

        productSpecificationFactory.getProductSearchBrandDropdownList().then(function (data) {

            $scope.productSearchBrand = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "business",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };
        },
                function () {
                    $scope.productSearchBrand = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "business",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });

        productSpecificationFactory.getProductSearchSupplierNameDropdownList().then(function (data) {

            $scope.productSearchSupplierName = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "business",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };
        },
                function () {
                    $scope.productSearchSupplierName = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "business",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });
        productSpecificationFactory.getProductSearchSiteNameDropdownList().then(function (data) {

            $scope.productSearchSiteName = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "business",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };
        },
                function () {
                    $scope.productSearchSiteName = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "business",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });

        productSpecificationFactory.getProductSearchCommercialStatusDropdownList().then(function (data) {

            $scope.productSearchCommercialStatus = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "business",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };
        },
                function () {
                    $scope.productSearchCommercialStatus = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "business",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });

        productSpecificationFactory.getProductSearchBusinessNameDropdownList().then(function (data) {

            $scope.productSearchBusinessName = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "business",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };
        },
                function () {
                    $scope.productSearchBusinessName = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "business",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });

        productSpecificationFactory.getProductCategoryDropdownList().then(function (data) {
            kendo.ui.progress($(document.body), false);
            $scope.productSearchCategory = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                dataTextField: "business",
                dataValueField: "id",
                optionLabel: "please select",
                dataSource: data
            };
        },
                function () {
                    kendo.ui.progress($(document.body), false);
                    $scope.productSearchCategory = {
//placeholder: "Select Job Title...", // Only for kendo-multi-select
                        dataTextField: "business",
                        dataValueField: "id",
                        optionLabel: "please select",
                        dataSource: []
                    };
                });



        $scope.gotoAddnewSpecification = function () {
            $state.go('productSpec.createProductSpecification');
        };

        nsfTraqtionService.gridCreated = false;

        $scope.searchProduct = function () {
            kendo.ui.progress($(document.body), true);
            productSpecificationFactory.searchProductsService($scope.productSearch).then(function (data) {
//                alert('Success --- ' + JSON.stringify(data));
                kendo.ui.progress($(document.body), false);
                var totalCount = data.data.length;
                if (totalCount > 0) {

                    nsfTraqtionService.gridCreated = true;

                    $("#searchResultCount").css("display", "block");
                    $("#resultCount").css("display", "inline-block");
                    if (totalCount > 1) {

                        $("#resultCount").text("Total search found: " + totalCount + " Results");
                    } else if (totalCount === 1) {
                        $("#resultCount").text("Total search found: " + totalCount + " Result");
                    }
//                var data = [{
//                        'productTitle': 'Pancake Mix',
//                        'specificationStatus': 'Approved',
//                        'commercialStatus': 'Active',
//                        'version': '1.0',
//                        'clientProductCode': 'SUP7804521',
//                        'systemProductCode': 'SYS9854215',
//                        'supplierName': 'Tips Food Limited',
//                        'siteName': 'BreakFast unit',
//                        'businessName': '',
//                        'category': 'Mixes',
//                        'specificationOwner': '',
//                        'productDeclaredQuantity': ''
//
//                    },
//                    {
//                        'productTitle': 'cake Mix',
//                        'specificationStatus': 'Approved',
//                        'commercialStatus': 'Active',
//                        'version': '1.0',
//                        'clientProductCode': 'SUP7804521',
//                        'systemProductCode': 'SYS9854215',
//                        'supplierName': 'Tips Food Limited',
//                        'siteName': 'BreakFast unit',
//                        'businessName': '',
//                        'category': 'Mixes',
//                        'specificationOwner': '',
//                        'productDeclaredQuantity': ''
//
//                    }
//                    , {
//                        'productTitle': 'Pancake Mix',
//                        'specificationStatus': 'Approved',
//                        'commercialStatus': 'Active',
//                        'version': '1.0',
//                        'clientProductCode': 'SUP7804521',
//                        'systemProductCode': 'SYS9854215',
//                        'supplierName': 'Tips Food Limited',
//                        'siteName': 'BreakFast unit',
//                        'businessName': '',
//                        'category': 'Mixes',
//                        'specificationOwner': '',
//                        'productDeclaredQuantity': ''
//
//                    },
//                    {
//                        'productTitle': 'Pancake Mix',
//                        'specificationStatus': 'Approved',
//                        'commercialStatus': 'Active',
//                        'version': '1.0',
//                        'clientProductCode': 'SUP7804521',
//                        'systemProductCode': 'SYS9854215',
//                        'supplierName': 'Tips Food Limited',
//                        'siteName': 'BreakFast unit',
//                        'businessName': '',
//                        'category': 'Mixes',
//                        'specificationOwner': '',
//                        'productDeclaredQuantity': ''
//
//                    }
//                ];


                    $('#kendoGrid').text('');

                    $("#kendoGrid").kendoGrid({
                        toolbar: ["excel"],
                        excel: {
                            fileName: "Product_search_Result.xlsx",
                            filterable: true
                        },
                        dataSource: {
                            data: data.data,
                            pageSize: 3
                        },
                        selectable: "row",
                        scrollable: false,
                        sortable: true,
                        columnMenu: true,
                        pageable: true,
                        change: function (kendoEvent) {
                            var grid = kendoEvent.sender;
                            var selectedData = grid.dataItem(grid.select());
                            nsfTraqtionService.productHeaderData = selectedData;

                        },
                        columns: [
                            {field: "productTitle", title: "Product Title"},
                            {field: "specificationStatus", title: "Specification Status"},
                            {field: "commercialStatus", title: "Commercial Status"},
                            {field: "version", title: "Version"},
                            {field: "clientProductCode", title: "Client Product Code"},
                            {field: "systemProductCode", title: "System Product Code"},
                            {field: "supplierName", title: "Supplier Name"},
                            {field: "siteName", title: "Site Name"},
                            {field: "businessName", title: "Business Name"},
                            {field: "category", title: "Category"},
                            {field: "specificationOwner", title: "Specification Owner"},
                            {field: "productDeclaredQuantity", title: "Product Declared Qunantity"}
                        ]
                    });
                    $('#kendoGrid .k-selectable').wrap('<div class="gridContainer"></div>');
                } else {

                    $("#searchResultCount").css("display", "none");
                    $("#resultCount").css("display", "none");
                    if (nsfTraqtionService.gridCreated === true) {
                        $("#kendoGrid").remove();

                        $("#noResultsFound").html("<p style='text-align:center;font-size:14px;color:black;'>No records found.</p>");
                    } else {
                        $("#kendoGrid").html("<p style='text-align:center;font-size:14px;color:black;'>No records found.</p>");
                    }
                }
            }, function () {

                kendo.ui.progress($(document.body), false);
                alert("Please try again after sometime");
            });

        };

        $scope.saveSearchProduct = function () {
            kendo.ui.progress($(document.body), true);
            productSpecificationFactory.saveSearchProductService($scope.productSearch).then(function (data) {
                kendo.ui.progress($(document.body), false);
                alert(data);
                if (data.isSuccess === true) {
                    $("#savedSearchProductDialog").kendoWindow({
                        title: "Message",
                        height: 160,
                        width: 400,
                        visible: false,
                        modal: true
                    });
                    var savedSearchProductDialog = $("#savedSearchProductDialog").data("kendoWindow");
                    savedSearchProductDialog.center();
                    savedSearchProductDialog.open();
                    var savedSearchProductDialogContent = '<br/><div class="row">' +
                            '<div class="col-lg-12 col-sm-12 col-md-12 text-center">' +
                            '<span>Your search is saved.</span>' +
                            '</div><br/><br/>' +
                            '<div class="col-lg-12 col-sm-12 col-md-12 text-center">' +
                            '<button ng-click="closeSavedSearchProductDialog()" class="k-primary btn_primary kendoBtn">OK</button>' +
                            '</div>' +
                            '</div>';
                    var savedSearchProductDialogTemplate = $compile(savedSearchProductDialogContent)($scope);
                    savedSearchProductDialog.content(savedSearchProductDialogTemplate);

                }
            },
                    function () {

                        kendo.ui.progress($(document.body), false);
                        alert("Please try again after sometime");
                    });
        };

        $scope.closeSavedSearchProductDialog = function () {
            var savedSearchProductDialog = $("#savedSearchProductDialog").data("kendoWindow");
            savedSearchProductDialog.close();
        };


    }]);


$(window).resize(function () {
    setSearchProductContentArea();
});

function setSearchProductContentArea() {
    var contentHeight = Number(($(window).height()) - 270);
    $('.searchproductContent').css('height', contentHeight);
}

function configKendoControls() {
    $(":text").kendoMaskedTextBox();
    $('.kendoBtn').kendoButton();
}












