angular.module('nsfTraqtionApp', [ 'ui.router', 'ngResource',
		"kendo.directives" ]);

angular
		.module('nsfTraqtionApp')
		.config(
				[
						'$stateProvider',
						'$urlRouterProvider',
						function($stateProvider, $urlRouterProvider) {
							$stateProvider
									.state(
											'login',
											{
												url : '/login',
												views : {
													'mainContent@' : {

														controller : 'nsfTraqtionloginctrl',
														templateUrl : 'app/views/common/login.html'
													/*controller: 'nsfTraqtion_addNewUserCtrl'
													  templateUrl: 'app/views/User_Management/addNewUser.html'*/

													}
												}

											})
									.state(
											'adduser',
											{
												url : '/adduser',
												views : {
													'mainContent@' : {
														/*controller: 'nsfTraqtionloginctrl',
														templateUrl: 'app/views/form.html'*/
														//controller: 'nsfTraqtion_addNewUserCtrl',
														controller : '',
														templateUrl : 'app/views/userManagement/addNewUser.html'

													}
												}

											})
									.state(
											'edituser',
											{
												url : '/edituser',
												views : {
													'mainContent@' : {
														//controller: 'nsfTraqtion_editUserDetailsCtrl',
														controller : '',
														templateUrl : 'app/views/userManagement/editUserDetails.html'
													}
												}

											})
									.state(
											'searchProducts',
											{
												views : {
													url : '/searchProducts',
													'mainContent@' : {
														controller : 'searchProductsCtrl',
														templateUrl : 'app/views/productSpecification/searchProducts.html'
													}
												}
											})
									.state(
											'productSpec',
											{
												url : '/productSpecification',
												views : {
													'mainContent@' : {
														controller : 'productSpecificationCtrl',
														templateUrl : 'app/views/productSpecification/productSpec.html'
													}
												}
											})
									.state(
											'productSpec.createProductSpecification',
											{

												parent : 'productSpec',
												views : {
													'ProductSubContents@productSpec' : {
														controller : 'createProductSpecificationCtrl',
														templateUrl : 'app/views/productSpecification/createProductSpecification.html'
													}
												}
											})
									.state(
											'productSpec.storageDistribution',
											{
												parent : 'productSpec',
												views : {
													'ProductSubContents@productSpec' : {
														controller : 'storageDistributionCtrl',
														templateUrl : 'app/views/productSpecification/storageDistribution.html'
													}
												}
											})
									.state(
											'productSpec.Associations',
											{
												parent : 'productSpec',
												views : {
													'ProductSubContents@productSpec' : {
														controller : 'associationsCtrl',
														templateUrl : 'app/views/productSpecification/associations.html'
													}
												}
											})
									.state(
											'dashboard',
											{
												url : '/dashboard',
												views : {
													'mainContent@' : {
														controller : 'dashboardDataCtrl',
														templateUrl : 'app/views/common/dashboard.html'
													}
												}
											})
									.state(
											'clientInfo',
											{
												url : '/clientInfo',
												views : {
													'mainContent@' : {
														controller : 'clientInfo',
														templateUrl : 'app/views/clientManagement/clientInfo.html'
													}
												}
											})
									.state(
											'clientInfo.clientContacts',
											{
												parent : 'clientInfo',
												views : {
													'clientContents@clientInfo' : {
														controller : 'clientContactsCtrl',
														templateUrl : 'app/views/clientManagement/clientContacts.html'
													}
												}
											})
									.state(
											'clientInfo.clientSites',
											{
												parent : 'clientInfo',
												views : {
													'clientContents@clientInfo' : {
														controller : 'clientSitesCtrl',
														templateUrl : 'app/views/clientManagement/clientSites.html'
													}
												}
											});

							$urlRouterProvider.otherwise('/login');

						} ]);

angular.module('nsfTraqtionApp').controller(
		'nsfTraqtionAppMainctrl',
		[ '$scope', '$state', '$rootScope',
				function($scope, $state, $rootScope) {
					setContentArea();
					
					$scope.headerFile = 'loginHeader';
					$scope.footerFile = 'loginFooter';
					$state.go('login');
					
					
					function setContentArea() {
						var contentHeight = Number(($(window).height()) - 260);
						$('.mainContent').css('height', contentHeight);
					}

					$(window).resize(function() {
						setContentArea();
					});
					
				} ]);

/*$(function() {
	setContentArea();
});

function setContentArea() {
	var contentHeight = Number(($(window).height()) - 260);
	$('.mainContent').css('height', contentHeight);
}

$(window).resize(function() {
	setContentArea();
});*/