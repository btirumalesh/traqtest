angular
        .module('nsfTraqtionApp')
        .factory(
                'userManagementFactory',
                [
                    '$http',
                    '$q',
                    'nsfTraqtionConstants',
                    function ($http, $q, nsfTraqtionConstants) {

                        //Getting List of Job Titles
                        var get_JobTitleList = function (clientID) {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.addNewUerURL
                                    + 'jobTitle?clientId=' + clientID;
                            var request = "";

                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('get_JobTitleList => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        //Getting List of Roles
                        var get_UserRoleList = function (clientID) {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.addNewUerURL
                                    + 'getRole?clientId=' + clientID;
                            var request = "";

                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('get_UserRoleList => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        //Getting List of Languages
                        var get_LanguageList = function (clientID) {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.addNewUerURL
                                    + 'languages?clientId=' + clientID;
                            var request = "";

                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('get_LanguageList => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        //Getting List of Category
                        var get_CategoryList = function (clientID) {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.addNewUerURL
                                    + 'categories?clientId=' + clientID;
                            var request = "";

                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('get_CategoryList => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        //Getting List of Business
                        var get_BusinessList = function (clientID) {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.addNewUerURL
                                    + 'business?clientId=' + clientID;
                            var request = "";

                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('get_BusinessList => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        //Getting Business Based Category List
                        var get_BusinessBased_CategoryList = function (businessID) {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.addNewUerURL
                                    + 'catgrybusiness?businessId=' + businessID;
                            var request = "";

                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('get_BusinessBased_CategoryList => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        //Getting List of Company Types
                        var get_CompanyTypeList = function () {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.addNewUerURL
                                    + 'companies';
                            var request = "";

                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('get_CompanyTypeList => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        //Getting List of Suppliers
                        var get_SupplierList = function (clientID) {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.addNewUerURL
                                    + 'suppliers?clientId=' + clientID;
                            var request = "";

                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('get_SupplierList => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        //Getting List of Facility
                        var get_FacilityList = function (supplierID) {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.addNewUerURL
                                    + 'facilities?supplierId=' + supplierID;
                            var request = "";

                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('get_FacilityList => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        //Getting List of Service Providers
                        var get_ServiceProviderList = function (clientID) {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.addNewUerURL
                                    + 'servProvider?clientId=' + clientID;
                            var request = "";

                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('get_ServiceProviderList => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        //Getting List of Service Type
                        var get_ServiceTypeList = function (srvPrvdrId) {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.addNewUerURL
                                    + 'servTypes?srvPrvdrId=' + srvPrvdrId;
                            var request = "";

                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('get_ServiceTypeList => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        //Getting List of Corporate
                        var get_CorporateList = function (requestData) {

                        };

                        //Getting List of User Status
                        var get_UserStatusList = function (clientID) {

                        };

                        //Getting Status of User EMail ID
                        var check_EmailAvailability = function (clientID) {

                        };

                        //Getting User Info
                        var get_UserInfo = function (requestData) {

                        };

                        //Update User Info
                        var editUser = function (requestData) {

                        };

                        //Create New User
                        var addUser = function (requestData) {
                            var deferred = $q.defer();
                            var url = nsfTraqtionConstants.url + '/users';
                            var request = requestData;
                            $http.get(url, request, {
                                headers: {
                                    'Access-Control-Allow-Origin': '*',
                                    'Content-Type': 'application/json'
                                }
                            }).success(function (data) {
                                console.log(JSON.stringify(data));
                                //deferred.resolve(data);
                            }).error(function (data, status) {
                                console.log('addUser => Error : ' + status);
                                deferred.reject(data);
                            });
                            return deferred.promise;
                        };

                        return {
                            get_JobTitleList: get_JobTitleList,
                            check_EmailAvailability: check_EmailAvailability,
                            get_UserStatusList: get_UserStatusList,
                            get_UserRoleList: get_UserRoleList,
                            get_LanguageList: get_LanguageList,
                            get_CategoryList: get_CategoryList,
                            get_BusinessList: get_BusinessList,
                            get_BusinessBased_CategoryList: get_BusinessBased_CategoryList,
                            get_CompanyTypeList: get_CompanyTypeList,
                            get_SupplierList: get_SupplierList,
                            get_CorporateList: get_CorporateList,
                            get_FacilityList: get_FacilityList,
                            get_ServiceProviderList: get_ServiceProviderList,
                            get_ServiceTypeList: get_ServiceTypeList,
                            addUser: addUser,
                            get_UserInfo: get_UserInfo,
                            editUser: editUser
                        };
                    }]);
