
angular.module('nsfTraqtionApp').controller('clientInfo', ['$scope', '$state', '$rootScope', '$http', 'nsfclientManagementFactory', function ($scope, $state, $rootScope, $http, nsfclientManagementFactory) {
        $scope.serverBaseUrl = "http://localhost:7070/NSFTraqtion/restservice/clients/1000";
        /*$scope.dataSource = new kendo.data.DataSource({
         transport: {
         read:  {
         url: $scope.crudServiceBaseUrl,
         dataType: "jsonp"
         },
         update: {
         url: $scope.crudServiceBaseUrl + "/Products/Update",
         dataType: "jsonp"
         },
         destroy: {
         url: $scope.crudServiceBaseUrl + "/Products/Destroy",
         dataType: "jsonp"
         },
         create: {
         url: $scope.crudServiceBaseUrl + "/Products/Create",
         dataType: "jsonp"
         },
         parameterMap: function(options, operation) {
         if (operation !== "read" && options.models) {
         return {models: kendo.stringify(options.models)};
         }
         }
         }
         });*/

        /*$http.get('http://localhost:7070/NSFTraqtion/restservice/clients/1000').success(function (data) {
         console.log(JSON.stringify('asdasd'+data));
         }).then(function (data) {
         $scope.clientInfo = data;
         console.log('succ '+JSON.stringify(data));
         },function (data) {
         console.log('dfkdk '+JSON.stringify(data.data));
         
         });*/
        $http.get('http://localhost:7070/NSFTraqtion/restservice/clients/1000/', {
            headers: {
                'Content-Type': 'application/json'
            }
        }).success(function (data) {
            console.log(JSON.stringify(data));
        }).error(function (data, status) {
            console.log('get_UserRoleList => Error : ' + status);
            $scope.clientInfo = data;
        }).then(function (data, status) {
            console.log('ipo varuvala' + JSON.stringify(data));
        });
        /*$scope.clientInfo = {
         "isStatus":true,
         "statusMsg":null,
         "errorCode":null,
         "errorMsg":null,
         "data":{
         "clientId":1,
         "anfOtlm":"4",
         "appliedDate":"06-Sep-2014 14:05:15",
         "businessGroup":"GRP-BusinessBus",
         "clientCategoryName":"CAT",
         "clientCode":"001",
         "clientContactName":"Name1",
         "clientContactType":"Ty",
         "clientName":"Name-Client",
         "clientParent":{
         "companyId":125,
         "companyName":"ParentCompany"
         },
         "commnets":"333",
         "contactEmail":"emai@email.com",
         "createdBy":{
         "userId":14,
         "userName":"User-Name1"
         },
         "creationDate":"07-Sep-2014 14:05:15",
         "dropDate":"09-Sep-2014",
         "emailAddress":"qaddr@gamil.com",
         "entryDate":"07-Sep-2014 14:05:15",
         "faxNo":"2324340",
         "hoursClosing":"3",
         "language":"EN-US",
         "listedDate":"07-Sep-2014 14:05:15",
         "paymentPlan":"RE",
         "store":"STR",
         "timeZone":"3",
         "unlistDate":"07-Sep-2014 14:05:15",
         "updatedBy":{
         "userId":14,
         "userName":"User-Name1"
         },
         "updatedDate":"08-Sep-2014 14:05:15",
         "clientParentName":"parent name",
         "phoneNo":2324340,
         "selfRegistrationUrl":"http://google.com",
         "addressLine1":"address line 1",
         "addressLine2":"address line 2",
         "clientCity": "City name",
         "clientState": "State name",
         "clientCountry": "Country name",
         "clientZip": 123123,
         "webAddress":"http://google.com"
         }
         };*/

        $('.infoPanelBar').kendoPanelBar();
        /*var infoPanelBar = $("#panelbar").data("kendoPanelBar");
         infoPanelBar.expand();*/
        
        $scope.saveChanges = function(){
            
        }

        $('#productSpecUL li span:nth-child(2)').css('display', 'none');
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
        $("input[type='text']").kendoMaskedTextBox();
    }]);