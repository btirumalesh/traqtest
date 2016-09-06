angular.module('nsfTraqtionApp').factory('productSpecificationFactory', ['$http', '$q', 'nsfTraqtionConstants', function ($http, $q, nsfTraqtionConstants) {

        var url = '';
        var reqData = '';
        var addNewProductSpecification = function (requestData) {


            var deferred = $q.defer();
            url = nsfTraqtionConstants.url + '/productSpecifications/createProductSpecification';
            reqData = requestData;
            console.log(JSON.stringify(reqData));

            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            };


            if (nsfTraqtionConstants.fetchLiveData === true) {
                $http.post(url, reqData, config)
                        .success(function (data) {
                            console.log(JSON.stringify(data));
                            deferred.resolve(data);
                        }).error(function (data, status) {
                    console.log('err ---  ' + status);
                    deferred.reject(data);
                });
            } else {
                $http.get('data/myTravels.json').success(function (data) {
                    deferred.resolve(data);
                });

            }

            return deferred.promise;
        };

        var getProductSpecBusinessNameDropdownList = function () {
            var deferred = $q.defer();

            var url = nsfTraqtionConstants.dropdownurl + "/business?clientId=1000";
            $http.get(url, reqData)
                    .success(function (data) {
                        console.log(JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };

        var getProductSpecCategoryDropdownList = function () {
            var deferred = $q.defer();
            var data1 = [
                {
                    id: 1,
                    category: "Bevarages"
                },
                {
                    id: 2,
                    category: "Fresh"
                },
                {
                    id: 3,
                    category: "Seasonal"
                }
            ];
            if (data1) {
                deferred.resolve(data1);
            } else {
                deferred.reject(data1);
            }
            return deferred.promise;
        };

        var getProductSpecBrandDropdownList = function () {
            var deferred = $q.defer();
            var data = [
                {
                    id: 1,
                    brand: "Easy Mix range"
                },
                {
                    id: 2,
                    brand: "Sun flower"
                },
                {
                    id: 3,
                    brand: "Nestle"
                }
            ];
            if (data) {
                deferred.resolve(data);
            } else {
                deferred.reject(data);
            }
            return deferred.promise;
        };

        var getProductSpecTypeDropdownList = function () {
            var deferred = $q.defer();
            var data = [
                {
                    id: 1,
                    SpecType: "Food Sweet Mixes"
                },
                {
                    id: 2,
                    SpecType: "Food Savoury Mixes"
                }

            ];
            if (data) {
                deferred.resolve(data);
            } else {
                deferred.reject(data);
            }
            return deferred.promise;
        };

        var getProductSpecOwnerDropdownList = function () {
            var deferred = $q.defer();
            var data = [
                {
                    id: 1,
                    SpecOwner: "Elizabeth Bill"
                },
                {
                    id: 2,
                    SpecOwner: "Mark Perry"
                },
                {
                    id: 3,
                    SpecOwner: "Nicole Robertson"
                }
            ];
            if (data) {
                deferred.resolve(data);
            } else {
                deferred.reject(data);
            }
            return deferred.promise;
        };

        var searchProductsService = function (reqData) {
            var deferred = $q.defer();
            var reqData = JSON.stringify(reqData);
            var url = nsfTraqtionConstants.newurl + "/productSpecifications/search?params=" + reqData;
            $http.get(url)
                    .success(function (data) {
                        console.log('success --- ' + JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };
        var saveSearchProductService = function (reqData) {
            var deferred = $q.defer();
            var url = nsfTraqtionConstants.newurl + "/productSpecifications/savedsearches";
            $http.post(url, reqData)
                    .success(function (data) {
                        console.log(JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };

        var getProductSearchCreatedByDropdownList = function (reqData) {
            var deferred = $q.defer();

            var url = nsfTraqtionConstants.dropdownurl + "/owner?clientId=1000";
            $http.get(url, reqData)
                    .success(function (data) {
                        console.log(JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };
        var getProductSearchSpecificationStatusDropdownList = function (reqData) {
            var deferred = $q.defer();

            var url = nsfTraqtionConstants.dropdownurl + "/specificationType/specificationStatus";
            $http.get(url, reqData)
                    .success(function (data) {
                        console.log(JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };
        var getProductSearchSpecificationTypeDropdownList = function (reqData) {
            var deferred = $q.defer();

            var url = nsfTraqtionConstants.dropdownurl + "/specificationType?categoryId=1000";
            $http.get(url, reqData)
                    .success(function (data) {
                        console.log(JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };
        var getProductSearchBrandDropdownList = function (reqData) {
            var deferred = $q.defer();

            var url = nsfTraqtionConstants.dropdownurl + "/brand?clientId=1000";
            $http.get(url, reqData)
                    .success(function (data) {
                        console.log(JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };
        var getProductSearchSupplierNameDropdownList = function (reqData) {
            var deferred = $q.defer();

            var url = nsfTraqtionConstants.dropdownurl + "/suppliers?clientId=1000";
            $http.get(url, reqData)
                    .success(function (data) {
                        console.log(JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };
        var getProductSearchSiteNameDropdownList = function (reqData) {
            var deferred = $q.defer();

            var url = nsfTraqtionConstants.dropdownurl + "/getSites?clientId=1000";
            $http.get(url, reqData)
                    .success(function (data) {
                        console.log(JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };

        var getProductSearchCommercialStatusDropdownList = function (reqData) {
            var deferred = $q.defer();

            var url = nsfTraqtionConstants.dropdownurl + "/specificationType/commercialStatus";
            $http.get(url, reqData)
                    .success(function (data) {
                        console.log(JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };



        var getProductSearchBusinessNameDropdownList = function (reqData) {
            var deferred = $q.defer();

            var url = nsfTraqtionConstants.dropdownurl + "/business?clientId=1000";
            $http.get(url, reqData)
                    .success(function (data) {
                        console.log(JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };

        var getProductCategoryDropdownList = function (reqData) {
            var deferred = $q.defer();

            var url = nsfTraqtionConstants.dropdownurl + "/categories?clientId=1000";
            $http.get(url, reqData)
                    .success(function (data) {
                        console.log(JSON.stringify(data));
                        deferred.resolve(data);
                    }).error(function (data, status) {
                console.log('err ---  ' + status);
                deferred.reject(data);
            });
            return deferred.promise;
        };


        return {
            addNewProductSpecification: addNewProductSpecification,
            getProductSpecBusinessNameDropdownList: getProductSpecBusinessNameDropdownList,
            getProductSpecCategoryDropdownList: getProductSpecCategoryDropdownList,
            getProductSpecBrandDropdownList: getProductSpecBrandDropdownList,
            getProductSpecTypeDropdownList: getProductSpecTypeDropdownList,
            getProductSpecOwnerDropdownList: getProductSpecOwnerDropdownList,
            searchProductsService: searchProductsService,
            saveSearchProductService: saveSearchProductService,
            getProductSearchCreatedByDropdownList: getProductSearchCreatedByDropdownList,
            getProductSearchSpecificationStatusDropdownList: getProductSearchSpecificationStatusDropdownList,
            getProductSearchSpecificationTypeDropdownList: getProductSearchSpecificationTypeDropdownList,
            getProductSearchBrandDropdownList: getProductSearchBrandDropdownList,
            getProductSearchSupplierNameDropdownList: getProductSearchSupplierNameDropdownList,
            getProductSearchSiteNameDropdownList: getProductSearchSiteNameDropdownList,
            getProductSearchCommercialStatusDropdownList: getProductSearchCommercialStatusDropdownList,
            getProductSearchBusinessNameDropdownList: getProductSearchBusinessNameDropdownList,
            getProductCategoryDropdownList: getProductCategoryDropdownList

        };
    }]);
