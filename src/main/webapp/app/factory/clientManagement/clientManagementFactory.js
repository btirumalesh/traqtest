angular.module('nsfTraqtionApp').factory('nsfclientManagementFactory', ['$http', '$q', 'nsfTraqtionConstants', function ($http, $q, nsfTraqtionConstants) {


        var callSampleService = function (requestData) {


            var deferred = $q.defer();
            var url = nsfTraqtionConstants.url + '/users';
            var request = requestData;



            $http.post(url, request,
                    {
                        headers: {
                            'Access-Control-Allow-Origin': '*',
                            'Content-Type': 'application/json'
                        }
                    }
            ).success(function (data) {
                console.log(JSON.stringify(data));
//            deferred.resolve(data);
            }).error(function (data, status) {
                console.log('error'+status);
                deferred.reject(data);
            });
            return deferred.promise;
        };


        return {
            callSampleService: callSampleService
        };
    }]);
