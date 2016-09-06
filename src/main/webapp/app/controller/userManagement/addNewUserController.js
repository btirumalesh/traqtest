//'use strict';

//angular.module('nsfTraqtionApp')
//.controller('nsfTraqtion_addNewUserCtrl', ['$scope', '$state', '$rootScope', 'nsfTraqtionFactory', function ($scope, $state, $rootScope, nsfTraqtionFactory) {}]);

angular
        .module('nsfTraqtionApp')
        .controller(
                'nsfTraqtion_addNewUserCtrl',
                [
                    '$scope',
                    '$state',
                    '$rootScope',
                    'userManagementFactory',
                    function ($scope, $state, $rootScope,
                            userManagementFactory) {


                        setContentArea();

                        $scope.showSupplier = false;
                        $scope.showServiceProvider = false;

                        $scope.user = {
                            jobTitleId: {},
                            languageId: {},
                            serviceProviderId: {},
                            supplierId: {},
                            rolesList: [],
                            companyTypeId: [],
                            categoriesList: [],
                            businessList: [],
                            supplierfacilityList: [],
                            serviceProviderList: []
                        };

                        $scope.user.statusCodes = "NO REPLY";

                        var clientID = 800;
                        var businessID = 1;
                        var supplierID = 1;
                        var srvPrvdrId = 1;

                        userManagementFactory
                                .get_JobTitleList(clientID)
                                .then(
                                        function Success(data) {
                                            if (data.isSuccess) {
                                                $scope.JobTitleList = {
                                                    dataTextField: "name",
                                                    dataValueField: "id",
                                                    optionLabel: "Select Job Title",
                                                    dataSource: {
                                                        data: data.data
                                                    }
                                                };
                                            }
                                        }, function Error() {
                                    $scope.JobTitleList = {
                                        dataTextField: "title",
                                        dataValueField: "id",
                                        optionLabel: "Select Job Title",
                                        dataSource: {
                                            data: []
                                        }
                                    };
                                });

                        userManagementFactory
                                .get_CompanyTypeList()
                                .then(
                                        function Success(data) {
                                            if (data.isSuccess) {
                                                $scope.CompanyTypeList = {
                                                    dataTextField: "name",
                                                    dataValueField: "id",
                                                    optionLabel: "Select Company Type",
                                                    dataSource: {
                                                        data: data.data
                                                    }
                                                };
                                            }
                                        }, function Error() {
                                    $scope.CompanyTypeList = {
                                        dataTextField: "name",
                                        dataValueField: "id",
                                        optionLabel: "Select Company Type",
                                        dataSource: {
                                            data: []
                                        }
                                    };
                                });

                        userManagementFactory
                                .get_UserRoleList(clientID)
                                .then(
                                        function Success(data) {
                                            if (data.isSuccess) {
                                                $scope.UserRoleList = {
                                                    placeholder: "Select Role", // Only for kendo-multi-select
                                                    dataTextField: "name",
                                                    dataValueField: "id",
                                                    optionLabel: "Select Role",
                                                    dataSource: {
                                                        data: data.data
                                                    }
                                                };
                                            }
                                        }, function Error() {
                                    $scope.UserRoleList = {
                                        placeholder: "Select Role", // Only for kendo-multi-select
                                        dataTextField: "name",
                                        dataValueField: "id",
                                        optionLabel: "Select Role",
                                        dataSource: {
                                            data: []
                                        }
                                    };
                                });

                        userManagementFactory
                                .get_LanguageList(clientID)
                                .then(
                                        function Success(data) {
                                            if (data.isSuccess) {
                                                $scope.LanguageList = {
                                                    dataTextField: "name",
                                                    dataValueField: "id",
                                                    optionLabel: "Select Language",
                                                    dataSource: {
                                                        data: data.data
                                                    }
                                                };
                                            }
                                        }, function Error() {
                                    $scope.LanguageList = {
                                        dataTextField: "name",
                                        dataValueField: "id",
                                        optionLabel: "Select Language",
                                        dataSource: {
                                            data: []
                                        }
                                    };
                                });

                        userManagementFactory
                                .get_BusinessList(clientID)
                                .then(
                                        function Success(data) {
                                            console.log("BusinessList : " + data);
                                            if (data.isSuccess) {
                                                $scope.BusinessList = {
                                                    dataTextField: "name",
                                                    dataValueField: "id",
                                                    optionLabel: "Select Business",
                                                    dataSource: {
                                                        data: data.data
                                                    }
                                                };
                                            }
                                        }, function Error(response) {
                                    $scope.BusinessList = {
                                        dataTextField: "name",
                                        dataValueField: "id",
                                        optionLabel: "Select Business",
                                        dataSource: {
                                            data: []
                                        }
                                    };
                                });

                        userManagementFactory
                                .get_CategoryList(clientID)
                                .then(
                                        function Success(data) {
                                            if (data.isSuccess) {
                                                $scope.CategoryList = {
                                                    dataTextField: "name",
                                                    dataValueField: "id",
                                                    optionLabel: "Select Category",
                                                    dataSource: {
                                                        data: data.data
                                                    }
                                                };
                                            }
                                        }, function Error() {
                                    $scope.CategoryList = {
                                        dataTextField: "name",
                                        dataValueField: "id",
                                        optionLabel: "Select Category",
                                        dataSource: {
                                            data: []
                                        }
                                    };
                                });

                        userManagementFactory
                                .get_BusinessBased_CategoryList(businessID)
                                .then(
                                        function Success(data) {
                                            if (data.isSuccess) {
                                                $scope.BusinessBased_CategoryList = {
                                                    dataTextField: "name",
                                                    dataValueField: "id",
                                                    optionLabel: "Select Category",
                                                    dataSource: {
                                                        data: data.data
                                                    }
                                                };
                                            }
                                        }, function Error() {
                                    $scope.BusinessBased_CategoryList = {
                                        dataTextField: "name",
                                        dataValueField: "id",
                                        optionLabel: "Select Category",
                                        dataSource: {
                                            data: []
                                        }
                                    };
                                });

                        userManagementFactory
                                .get_SupplierList(clientID)
                                .then(
                                        function Success(data) {
                                            if (data.isSuccess) {
                                                $scope.SupplierList = {
                                                    dataTextField: "name",
                                                    dataValueField: "id",
                                                    optionLabel: "Select Supplier",
                                                    dataSource: {
                                                        data: data.data
                                                    }
                                                };
                                            }
                                        }, function Error() {
                                    $scope.SupplierList = {
                                        dataTextField: "name",
                                        dataValueField: "id",
                                        optionLabel: "Select Supplier",
                                        dataSource: {
                                            data: []
                                        }
                                    };
                                });

                        userManagementFactory
                                .get_FacilityList(supplierID)
                                .then(
                                        function Success(data) {
                                            if (data.isSuccess) {
                                                $scope.FacilityList = {
                                                    dataTextField: "name",
                                                    dataValueField: "id",
                                                    optionLabel: "Select Facility",
                                                    dataSource: {
                                                        data: data.data
                                                    }
                                                };
                                            }
                                        }, function Error() {
                                    $scope.FacilityList = {
                                        dataTextField: "name",
                                        dataValueField: "id",
                                        optionLabel: "Select Facility",
                                        dataSource: {
                                            data: []
                                        }
                                    };
                                });

                        userManagementFactory
                                .get_ServiceProviderList(clientID)
                                .then(
                                        function Success(data) {
                                            if (data.isSuccess) {
                                                $scope.ServiceProviderList = {
                                                    dataTextField: "name",
                                                    dataValueField: "id",
                                                    optionLabel: "Select Service Provider",
                                                    dataSource: {
                                                        data: data.data
                                                    }
                                                };
                                            }
                                        }, function Error() {
                                    $scope.ServiceProviderList = {
                                        dataTextField: "name",
                                        dataValueField: "id",
                                        optionLabel: "Select Service Provider",
                                        dataSource: {
                                            data: []
                                        }
                                    };
                                });

                        userManagementFactory
                                .get_ServiceTypeList(srvPrvdrId)
                                .then(
                                        function Success(data) {
                                            if (data.isSuccess) {
                                                $scope.ServiceTypeList = {
                                                    dataTextField: "name",
                                                    dataValueField: "id",
                                                    optionLabel: "Select Service Type",
                                                    dataSource: {
                                                        data: data.data
                                                    }
                                                };
                                            }
                                        }, function Error() {
                                    $scope.ServiceTypeList = {
                                        dataTextField: "name",
                                        dataValueField: "id",
                                        optionLabel: "Select Service Type",
                                        dataSource: {
                                            data: []
                                        }
                                    };
                                });

                        $scope.selectCompany = function () {

                            if ($scope.user.companyTypeId == 1) {
                            } else if ($scope.user.companyTypeId == 2) {
                                $scope.showSupplier = true;
                                $scope.showServiceProvider = false;
                            } else if ($scope.user.companyTypeId == 3) {
                                $scope.showSupplier = false;
                                $scope.showServiceProvider = true;
                            } else {
                                $scope.showSupplier = false;
                                $scope.showServiceProvider = false;
                            }
                        }

                        $scope.CreateUser = function () {
                            console.log($scope.value);
                            console.log($scope.dateString); //{{dateString}} => 8/24/2016
                            console.log($scope.dateObject); //{{ dateObject | date:"EEEE, MMMM d, yyyy" }} => Friday, August 19, 2016
                        };

                        $scope.validate = function (event) {
                            event.preventDefault();

                            if ($scope.validator.validate()) {

                                if ($scope.dateString) {
                                    $scope.user['assignTemporaryTo'] = $scope.dateString;
                                }

                                //alert(JSON.stringify($scope.user));

                                //Popup Window for showing Successful User Creation Message
                                /*
                                 $scope.successMsg = "New user successfully created";
                                 $scope.DlgOptions = {
                                 width: 550,
                                 height: 200,
                                 title: "New User Confirmation",
                                 visible: false,
                                 actions: [
                                 "Maximize",
                                 "Close"
                                 ]
                                 };
                                 
                                 $scope.successMsgWin.setOptions($scope.DlgOptions);
                                 $scope.successMsgWin.center();  // open dailog in center of screen
                                 $scope.successMsgWin.open();*/

                                $scope.user.clientId = {
                                    "id": 1
                                };
                                $scope.user.rolesList = $scope.selectedRole;
                                //$scope.user.companyTypeId = $scope.selectedCompanyType;
                                $scope.user.categoriesList = $scope.selectedCategory;
                                $scope.user.businessList = $scope.selectedBusiness;
                                $scope.user.supplierfacilityList = $scope.selectedFacility;
                                $scope.user.serviceProviderList = $scope.selectedServiceType;

                                console.log($scope.user);

                                //User Creation Section
                                userManagementFactory.addUser($scope.user)
                                        .then(function (data) {
                                            alert(JSON.stringify(data));
                                        });

                            } else {
                                $scope.validationMessage = "Oops! There is invalid data in the form.";
                                $scope.validationClass = "invalid";
                            }
                        };

                        $scope.addUserConfirm = function () {
                            $scope.successMsgWin.close();
                            userManagementFactory.addUser($scope.user)
                                    .then(function (data) {
                                        alert(JSON.stringify(data));
                                    });
                        };

                        $scope.addUserCancel = function () {
                            $scope.successMsgWin.close();
                        };


                        function setContentArea() {
                            var contentHeight = Number(($(window).height()) - 270);
                            $('.addUser').css('height', contentHeight);
                        }

                        $(window).resize(function () {
                            setContentArea();
                        });


                    }]);


 