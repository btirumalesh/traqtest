

angular.module('nsfTraqtionApp').controller('clientContactsCtrl', ['$scope', '$state', '$rootScope', 'nsfclientManagementFactory', function ($scope, $state, $rootScope, nsfclientManagementFactory) {

        //setProductContentArea();
            //$scope.crudServiceBaseUrl = "http://demos.telerik.com/kendo-ui/service";
            $scope.crudServiceBaseUrl = "http://localhost/nsf-traqtion-local/src/main/webapp/data/contacts.json";
	    $scope.dataSource = new kendo.data.DataSource({
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
	      },
	      batch: true,
	      pageSize: 20
	    });
	    $scope.mainGridOptions = {
	      //dataSource: $scope.data,
              dataSource: {
                //data: $scope.data,
                transport: {
                    read: {
                        url: "http://localhost/nsf-traqtion-local/src/main/webapp/data/contacts.json",
                        //data: { intUserId: 0 },  // the parameter I need to send to the server
                        contentType: "application/json; charset=utf-8",
                    }
                },
                pageSize:3
              },
	      sortable: true,
	      selectable:true,
	      pageable: true,
              scrollable: false,
              //detailTemplate: kendo.template($("#template").html()),
	      editable: "inline",
	      toolbar: ["create", "save", "submit"],
	      columns: [
	        { field: "firstName", title: "First Name"/*, width: "120px"*/ },
	        { field: "lastName", title:"Last Name"/*, width: "120px"*/ },
	        { field: "emailAddress", title:"Email Address"/*, width: "120px"*/ },
                { field: "jobTitle", title:"Job Title"/*, width: "120px"*/ },
                { field: "contactType", title:"Contact Type"/*, width: "120px"*/ },
                { field: "phoneNumber", title:"Phone Number"/*, width: "120px"*/ }
            ]
	    };
	
	    $scope.$on("kendoWidgetCreated", function(event, widget){
	      if (widget === $scope.myGrid) {
	        widget.element.find(".k-custom-edit").on("click", function(e){
	          e.preventDefault();
	          var selected = $scope.myGrid.select();
	          if(selected.length == 0){
	            alert('No record selected')
	          } else {
	            $scope.myGrid.editRow(selected);
	          }
	
	        });
	      }
	    });
    $("input[type='text']").kendoMaskedTextBox();
    }]);

