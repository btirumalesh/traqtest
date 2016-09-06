package com.nsf.traqtion.mapper.usermgmt;

import java.util.ArrayList;
import java.util.List;

import com.nsf.traqtion.data.entity.Client;
import com.nsf.traqtion.data.entity.ClientBusiness;
import com.nsf.traqtion.data.entity.CompanyType;
import com.nsf.traqtion.data.entity.JobTitle;
import com.nsf.traqtion.data.entity.Language;
import com.nsf.traqtion.data.entity.Role;
import com.nsf.traqtion.data.entity.ServiceProvider;
import com.nsf.traqtion.data.entity.ServiceProviderType;
import com.nsf.traqtion.data.entity.Status;
import com.nsf.traqtion.data.entity.Supplier;
import com.nsf.traqtion.data.entity.SupplierSite;
import com.nsf.traqtion.data.entity.User;
import com.nsf.traqtion.data.entity.UserBusinessCategory;
import com.nsf.traqtion.data.entity.UserDetail;
import com.nsf.traqtion.data.entity.UserMapping;
import com.nsf.traqtion.data.entity.UserRole;
import com.nsf.traqtion.data.entity.UserSpType;
import com.nsf.traqtion.data.entity.UserSuppSite;
import com.nsf.traqtion.model.common.LookupDTO;
import com.nsf.traqtion.model.common.UserBusinessCategoryDTO;
import com.nsf.traqtion.model.usermgmt.ClientDTO;
import com.nsf.traqtion.model.usermgmt.UserDetailsDTO;
import com.nsf.traqtion.util.DateUtil;

public class UserMapper {

	public static User userDTOToEntityMapper(UserDetailsDTO userDtlDto) {

		UserDetail userDetail = null;
		UserMapping userMapping = null;
		User user = null;

		if (null != userDtlDto) {

			// Creating User entity
			user = new User();

			user.setLoginId(userDtlDto.getEmailId());
			user.setCreationDate(DateUtil.getCurrentTimeStamp());
			user.setUpdatedDate(DateUtil.getCurrentTimeStamp());

			
			// creating userDetail
			userDetail = new UserDetail();
			userDetail.setFirstName(userDtlDto.getFirstName());
			userDetail.setLastName(userDtlDto.getLastName());
			userDetail.setMiddleName(userDtlDto.getMiddleName());
			userDetail.setEmailId(userDtlDto.getEmailId());
			userDetail.setJobTitle(userDtlDto.getJobTitleTxt());
			userDetail.setMobilePhone(userDtlDto.getMobilePhone());
			userDetail.setWorkPhone(userDtlDto.getWorkPhone());
			if (null != userDtlDto.getLanguage()) {
				Language lang = new Language();
				lang.setLanguagesId(userDtlDto.getLanguage().getId());
				userDetail.setLanguage(lang);
			}
			if (null != userDtlDto.getJobTitle()) {
				JobTitle jobTitle = new JobTitle();
				jobTitle.setJobTitleId(userDtlDto.getJobTitle().getId());
				userDetail.setJobTitleBean(jobTitle);
			}
			userDetail.setCreationDate(DateUtil.getCurrentTimeStamp());
			userDetail.setUpdatedDate(DateUtil.getCurrentTimeStamp());

			// creating user mapping entity
			userMapping = new UserMapping();

			if (null != userDtlDto.getClient()) {
				Client client = new Client();
				client.setClientId(userDtlDto.getClient().getClientId());
				userMapping.setClient(client);
			}
			if (null != userDtlDto.getCompanyType()) {
				CompanyType companyType = new CompanyType();
				companyType.setCompanyTypeId(userDtlDto.getCompanyType().getId());
				userMapping.setCompanyType(companyType);
			}
			if (null != userDtlDto.getSupplier()) {
				Supplier supplier = new Supplier();
				supplier.setSupplierId(userDtlDto.getSupplier().getId());
				userMapping.setSupplier(supplier);
			}
			if (null != userDtlDto.getServiceProvider()) {
				ServiceProvider sp = new ServiceProvider();
				sp.setServiceProvidersId(userDtlDto.getServiceProvider().getId());
				userMapping.setServiceProvider(sp);
			}
			if (null != userDtlDto.getStatus()) {
				Status status = new Status();
				status.setStatusId(userDtlDto.getStatus().getId());
				userMapping.setStatus(status);
			}
			userMapping.setCreationDate(DateUtil.getCurrentTimeStamp());
			userMapping.setUpdatedDate(DateUtil.getCurrentTimeStamp());
			// TODO convert string to timestamp
			// userMapping.setAssignTemporaryFrom(userDtlDto.getAssignTemporaryFrom());
			// userMapping.setAssignTemporaryTo(userDtlDto.getAssignTemporaryFrom());
			// Creating user Roles
			List<UserRole> userRolesList = new ArrayList<UserRole>();
			if (null != userDtlDto.getRolesList()) {
				for (LookupDTO roles : userDtlDto.getRolesList()) {
					UserRole userRole = new UserRole();
					Role role = new Role();
					role.setRoleId(roles.getId());
					userRole.setRole(role);
					userRole.setUserMapping(userMapping);
					userRole.setCreationDate(DateUtil.getCurrentTimeStamp());
					userRole.setUpdatedDate(DateUtil.getCurrentTimeStamp());
					userRolesList.add(userRole);
				}
			}

			userMapping.setUserRoles(userRolesList);
			
			List<UserSpType> userSpTypes = new ArrayList<>();
			if(null!=userDtlDto.getUserSpTypes()){
				for(LookupDTO ld : userDtlDto.getUserSpTypes()){
					UserSpType userSpType = new UserSpType();
					ServiceProviderType serType = new ServiceProviderType();
					serType.setServiceProviderTypeId(ld.getId());
					userSpType.setServiceProviderType(serType);
					userSpType.setUserMapping(userMapping);
					userSpType.setCreationDate(DateUtil.getCurrentTimeStamp());
					userSpType.setUpdatedDate(DateUtil.getCurrentTimeStamp());
					userSpTypes.add(userSpType);
					
				}
			}
			userMapping.setUserSpTypes(userSpTypes);
			
			// Setting category list
			List<UserBusinessCategory> userBussCategoryList = new ArrayList<>();
			if(null != userDtlDto.getCategoriesList()){
				for(LookupDTO cat : userDtlDto.getCategoriesList()){
				UserBusinessCategory category = new UserBusinessCategory();
				Client client = new Client();
				client.setClientId(userDtlDto.getClient().getClientId());
				category.setClient(client);
				category.setCategoriesId(cat.getId());
				userBussCategoryList.add(category);
				}
			}
			
			// setting business list
			if(null != userDtlDto.getBusinessList()){
				for(LookupDTO buss : userDtlDto.getBusinessList()){
				UserBusinessCategory business = new UserBusinessCategory();
				Client client = new Client();
				client.setClientId(userDtlDto.getClient().getClientId());
				business.setClient(client);
				ClientBusiness cb = new ClientBusiness();
				cb.setClientBusinessId(buss.getId());
				business.setClientBusiness(cb);
				userBussCategoryList.add(business);
				}
			}
			
			// setting business category list
			if(null != userDtlDto.getBusinessCategoryList()){
				for(UserBusinessCategoryDTO bc : userDtlDto.getBusinessCategoryList()){
				UserBusinessCategory businessCat = new UserBusinessCategory();
				Client client = new Client();
				client.setClientId(userDtlDto.getClient().getClientId());
				businessCat.setClient(client);
				ClientBusiness cb = new ClientBusiness();
				cb.setClientBusinessId(bc.getBusinessId());
				businessCat.setClientBusiness(cb);
				businessCat.setCategoriesId(bc.getCategoryId());
				userBussCategoryList.add(businessCat);
				}
			}
			
			List<UserSuppSite> userSuppSites = new ArrayList<>();
			if(null!=userDtlDto.getUserSuppSites()){
				for(LookupDTO ld : userDtlDto.getUserSuppSites()){
					UserSuppSite userSuppSite = new UserSuppSite();
					SupplierSite supplierSite = new SupplierSite();
					supplierSite.setSupplierSitesId(ld.getId());
					userSuppSite.setSupplierSite(supplierSite);
					userSuppSite.setUserMapping(userMapping);
					userSuppSite.setCreationDate(DateUtil.getCurrentTimeStamp());
					userSuppSite.setUpdatedDate(DateUtil.getCurrentTimeStamp());
					userSuppSites.add(userSuppSite);				
					
				}
			}
			userMapping.setUserSuppSites(userSuppSites);		
			
			List<UserDetail> userDetailList = new ArrayList<UserDetail>();
			userDetail.setUser(user);
			userDetailList.add(userDetail);

			List<UserMapping> userMappinglist = new ArrayList<UserMapping>();
			userMapping.setUser(user);
			userMappinglist.add(userMapping);
			user.setUserMappings(userMappinglist);
			user.setUserDetails(userDetailList);
		}
		return user;
	}

	public static UserDetailsDTO userEntityToDTOMapper(User userEntity) {

		UserDetailsDTO userDetailDto = null;

		if (null != userEntity) {
			userDetailDto = new UserDetailsDTO();
			userDetailDto.setUserId(userEntity.getUserId());
			if(null != userEntity.getUserMappings()){
				
				for(UserMapping userMapping: userEntity.getUserMappings()){
					
					
					if(null != userMapping.getClient()){
					ClientDTO client = new ClientDTO();
					client.setClientId(userMapping.getClient().getClientId());
					client.setClientName(userMapping.getClient().getCompanyName());
					client.setClientCategoryName(userMapping.getClient().getCompanyCode());
					userDetailDto.setClient(client);
					}
					
					if(null != userMapping.getCompanyType()){
					LookupDTO companyType = new LookupDTO();
					companyType.setId(userMapping.getCompanyType().getCompanyTypeId());
					companyType.setName(userMapping.getCompanyType().getCode());
					userDetailDto.setCompanyType(companyType);
					}
					
					if(null != userMapping.getSupplier()){
					LookupDTO supplier = new LookupDTO();
					supplier.setId(userMapping.getSupplier().getSupplierId());
					supplier.setName(userMapping.getSupplier().getSupplierName());
					userDetailDto.setSupplier(supplier);
					}
					
					if(null != userMapping.getServiceProvider()){
					LookupDTO serviceProvider = new LookupDTO();
					serviceProvider.setId(userMapping.getServiceProvider().getServiceProvidersId());
					serviceProvider.setName(userMapping.getServiceProvider().getCompanyName());
					userDetailDto.setServiceProvider(serviceProvider);
					}
					
					
					LookupDTO status = new LookupDTO();
					status.setId(userMapping.getStatus().getStatusId());
					status.setName(userMapping.getStatus().getCode());
					status.setCode(userMapping.getStatus().getDiscription());
					userDetailDto.setStatus(status);
					
					
					List<UserDetail> userDtlList = userEntity.getUserDetails();
					if(null != userDtlList){
						for(UserDetail userDtl : userDtlList){
							
							userDetailDto.setFirstName(userDtl.getFirstName());
							userDetailDto.setLastName(userDtl.getLastName());
							userDetailDto.setMiddleName(userDtl.getMiddleName());
							userDetailDto.setEmailId(userDtl.getEmailId());
							userDetailDto.setJobTitleTxt(userDtl.getJobTitle());
							//TODO get jobTitle object
							LookupDTO jobTitle = new LookupDTO();
							jobTitle.setId(userDtl.getJobTitleBean().getJobTitleId());
							jobTitle.setName(userDtl.getJobTitleBean().getJobName());
							userDetailDto.setJobTitle(jobTitle);
							
							//TODO get Language object
							if(null != userDtl.getLanguage()){
							LookupDTO language = new LookupDTO();
							language.setId(userDtl.getLanguage().getLanguagesId());
							language.setName(userDtl.getLanguage().getLanguageName());
							language.setCode(userDtl.getLanguage().getLanguageCode());
							userDetailDto.setLanguage(language);
							}
							userDetailDto.setMobilePhone(userDtl.getMobilePhone());
							userDetailDto.setWorkPhone(userDtl.getWorkPhone());
							userDetailDto.setEmailId(userDtl.getEmailId());
						}
					}

					// Creating user Roles
					List<LookupDTO> userRolesDtoList = new ArrayList<LookupDTO>();
					if (null != userMapping.getUserRoles()) {
						for (UserRole roles : userMapping.getUserRoles()) {
							LookupDTO userRole = new LookupDTO();
							if(null != roles.getRole()){
								userRole.setId(roles.getRole().getRoleId());
								userRole.setName(roles.getRole().getRoleName());
								userRolesDtoList.add(userRole);
							}
						}
					}
					userDetailDto.setRolesList(userRolesDtoList);
					
					List<LookupDTO> userSpTypesList = new ArrayList<>();
					if(null!=userMapping.getUserSpTypes()){
						for(UserSpType userSpType:userMapping.getUserSpTypes()){
							LookupDTO userSpLookup = new LookupDTO();
							if(null!=userSpType.getServiceProviderType()){
								userSpLookup.setId(userSpType.getServiceProviderType().getServiceProviderTypeId());
								userSpLookup.setName(userSpType.getServiceProviderType().getCode());
								userSpTypesList.add(userSpLookup);								
							}
						}
					}
					userDetailDto.setUserSpTypes(userSpTypesList);
					
					List<LookupDTO> userSuppList = new ArrayList<>();
					if(null!=userMapping.getUserSuppSites()){
						for(UserSuppSite suppSite : userMapping.getUserSuppSites()){
							LookupDTO lookupDTO = new LookupDTO();
							if(null!=suppSite.getSupplierSite()){
								lookupDTO.setId(suppSite.getSupplierSite().getSupplierSitesId());
								lookupDTO.setName(suppSite.getSupplierSite().getSiteCode());
								userSuppList.add(lookupDTO);
							}
						}
					}
					userDetailDto.setUserSuppSites(userSuppList);
					
					if(null != userMapping.getUserBusinessCategories()){
						List<LookupDTO> categoryList = new ArrayList<LookupDTO>();
						List<LookupDTO> businessList = new ArrayList<LookupDTO>();
						List<UserBusinessCategoryDTO> businessCategoryList = new ArrayList<UserBusinessCategoryDTO>();
						
						for(UserBusinessCategory ubc: userMapping.getUserBusinessCategories()){
							
							if(null != ubc.getCategoriesId() && null == ubc.getClientBusiness()){
								// Get Category List;
								LookupDTO category = new LookupDTO();
								category.setId(ubc.getCategoriesId());
								categoryList.add(category);
							}else if(null == ubc.getCategoriesId() && null != ubc.getClientBusiness()){
								// get Business List
								LookupDTO business = new LookupDTO();
								business.setId(ubc.getClientBusiness().getClientBusinessId());
								businessList.add(business);
							}else{
								// get business category list
								UserBusinessCategoryDTO ubcObj = new UserBusinessCategoryDTO();
								ubcObj.setCategoryId(ubc.getCategoriesId());
								ubcObj.setBusinessId(ubc.getClientBusiness().getClientBusinessId());
								ubcObj.setBusinessName(ubc.getClientBusiness().getBusinessCode());
								ubcObj.setClientId(ubc.getClient().getClientId());
								ubcObj.setUserId(ubc.getUserMapping().getUserMappingId());
								businessCategoryList.add(ubcObj);
							}
						}
						userDetailDto.setCategoriesList(categoryList);
						userDetailDto.setBusinessList(businessList);
						userDetailDto.setBusinessCategoryList(businessCategoryList);
						
					
					}
					
				}
			}
		}
		return userDetailDto;
	}

}