angular.module('nsfTraqtionApp').controller('dashboardDataCtrl', ['$scope', '$state', '$rootScope', 'nsfTraqtionFactory', function ($scope, $state, $rootScope, nsfTraqtionFactory) {

        $scope.dashboardData = {
        		"myActions": [
	              {
	                  "link": "Dried Batter SP123123123 is ready for approval",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "Your password needs to be updated in 10 days",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "SP567567567 Plain flour specification is ready for approval",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "Dried Batter SP123123123 is now collabarative draft please review",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "SP789789789 Almond Crossiant - has been approved. Update the commercial status",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "Dried Batter SP123123123 is ready for approval",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "Your password needs to be updated in 10 days",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "SP567567567 Plain flour specification is ready for approval",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "Dried Batter SP123123123 is now collabarative draft please review",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "SP789789789 Almond Crossiant - has been approved. Update the commercial status",
	                  "url": "javascript:void(0);"
	              }
	          ],
	          "myActivityHistory": [
	              {
	                  "link": "Created New User for Technician Role",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "New Primary Specification for Pancake mix created",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "Association page modified",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "Created a New User For Technician Role",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "New Primary Specification for Pancake mix created",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "Association page modified",
	                  "url": "javascript:void(0);"
	              }
	          ],
	          "myDashboard": [
	              {
	                  "link": "",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "",
	                  "url": "javascript:void(0);"
	              }
	          ],
	          "myMessages":[
	              {
	                  "link": "You have been added to the Batter mix Product team",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "SP123123123 Self-raising flour specification has been set to superseded",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "The Speciality Bakery categories have been added to your user profile",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "Spillers Bakery - has been technically approved",
	                  "url": "javascript:void(0);"
	              }
	          ],
	          "myFavourites":[
      	              {
      	                  "link": "You have been added to the Batter mix Product team",
      	                  "url": "javascript:void(0);"
      	              },
      	              {
      	                  "link": "SP123123123 Self-raising flour specification has been set to superseded",
      	                  "url": "javascript:void(0);"
      	              },
      	              {
      	                  "link": "The Speciality Bakery categories have been added to your user profile",
      	                  "url": "javascript:void(0);"
      	              },
      	              {
      	                  "link": "Spillers Bakery - has been technically approved",
      	                  "url": "javascript:void(0);"
      	              }
  	          ],
  	          "myQueries":[
      	              {
      	                  "link": "You have been added to the Batter mix Product team",
      	                  "url": "javascript:void(0);"
      	              },
      	              {
      	                  "link": "SP123123123 Self-raising flour specification has been set to superseded",
      	                  "url": "javascript:void(0);"
      	              },
      	              {
      	                  "link": "The Speciality Bakery categories have been added to your user profile",
      	                  "url": "javascript:void(0);"
      	              },
      	              {
      	                  "link": "Spillers Bakery - has been technically approved",
      	                  "url": "javascript:void(0);"
      	              }
	          ],
	          "myNews":[
	              {
	                  "link": "Dear Supplier, You will receive an invoice in April for the annual renewal fee for the website the applicable",
	                  "image": "image/news-img.jpg",
	                  "url": "javascript:void(0);"
	              },
	              {
	                  "link": "Supplier Awards Nominations due",
	                  "image": "image/news-img1.jpg",
	                  "url": "javascript:void(0);"
	              }
	          ]};

            console.log('dashboardData'+$scope.dashboardData);
    }]);