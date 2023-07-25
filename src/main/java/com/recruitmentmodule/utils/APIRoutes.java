package com.recruitmentmodule.utils;

/**
 * @author AKSHAY
 */
public class APIRoutes {

	public static final String BASE_API_URL = "/api/v1";

	// Dashboard
	public static final String DASHBOARD_BASE_URL = BASE_API_URL + "/dashboard";
	public static final String DEPARTMENT_MEMBERS = "/department/members";
	public static final String DEPARTMENT_MEMBERS_COUNT = "/department/members/Count";
	public static final String UPCOMING_HOLIDAYS = "/upcoming/holidays";
	public static final String USER_LIFE_EVENTS = "/user/life/events";
	public static final String NEWLY_HIRED_USER = "/newly/hired/user";
	public static final String CARDS_DATA = "/cardsData";

	// User URL's
	public static final String USER_BASE_URL = BASE_API_URL + "/user";
	public static final String LOGIN = "/login";
	public static final String REFRESH_TOKEN = "/refreshToken";
	public static final String FORGET_PASSWORD = "/forgetPassword";
	public static final String RESET_PASSWORD = "/resetPassword";
	public static final String CHANGE_PASSWORD = "/changePassword";
	public static final String LOGOUT = "/logout";

	// onboarding URL's
	public static final String ONBOARDING_BASE_URL = BASE_API_URL + "/onBoarding";
	public static final String INITIATE = "/initiate";
	public static final String ALL_USER = "/all/user";
	public static final String APPROVAL_DOCUMENTATION = "/approval/documention/{userId}";
	public static final String DELETE_ONBOARDINGEMPLOYEE = "/delete/{userId}";

	public static final String USER_PROFILE_BASE_URL = BASE_API_URL + "/user/profile";
	public static final String SAVE = "/save";
	public static final String FETCH = "/fetch";
	public static final String ALL_ROLES = "/all/roles";
	public static final String ALL_DESIGNATION = "/all/designation";
	public static final String UPLOAD_DOCUMENTS = "/upload/documents";
	public static final String REPORTING_MANAGERS = "/reportingTo/employees";
	public static final String EDIT_EMPLOYEE = "/edit/{userId}";

	public static final String USER_LEAVE_BASE_URL = BASE_API_URL + "/leave";
	public static final String APPLY_NOW = "/applyNow";
	public static final String DETAILS = "/details";
	public static final String PENDING_APPROVAL_REQUESTS = "/pendingApprovalRequests";
	public static final String CLOSE_RAISED_TICKET = "/approvalPending/closeRaisedTicket";

	// userOfficialDocuments URLs
	public static final String USER_OFFICIALDOCUMENTS_BASE_URL = BASE_API_URL + "/officialDocuments";
	public static final String DOWNLOAD_OFFICIAL_DOCUMENTS = "/download/official/documents/{userId}";

	// employeeTimesheet Urls
	public static final String EMPLOYEE_TIMESHEET_BASE_URL = BASE_API_URL + "/timesheet";
	public static final String EMP_TIMESHEET_SAVE_URL = "/employeesave/{userId}";
	public static final String EMP_TIMESHEET_GET_URL = "/employeeget/{userId}";
	public static final String EMP_TIMESHEET_EXPORT = "/export/{userId}";

	// Asset Module URLs
	public static final String ASSET_MODULE = BASE_API_URL + "/asset";
	public static final String ADD_ASSETS = "/save";
	public static final String FIND_ASSETS = "/get/{id}";
	public static final String REMOVE_ASSETS = "/delete/{id}";
	public static final String UPDATE_ASSETS = "/update/{id}";
	public static final String ALL_ASSETS = "/all";

	// Holiday URls 
	public static final String HOLIDAY_BASE_URL = BASE_API_URL + "/holiday";
	public static final String UPLOAD_HOLIDAYS = "/upload/official/file";
	public static final String GET_ADDITIONAL_HOLIDAYS ="/additional/get/{year}";
	public static final String ADD_ADDITIONAL_HOLIDAY ="/additional/save";
	public static final String GET_YEARS ="/get/years";
	
	// Asset Category URLs
	public static final String ASSET_CATEGEORY_BASE_URL = BASE_API_URL + "/asset/category";
	public static final String ASSET_CATEGEORY_ADD_URL = "/add";
	public static final String ASSET_CATEGEORY_GETALL_URL = "/all";
	public static final String ASSET_CATEGEORY_UPDATE_URL = "/update/{id}";
	public static final String ASSET_CATEGEORY_DELETE_URL = "/delete/{id}";
	public static final String ASSET_CATEGEORY_GETBYID_URL = "/get/{id}";

	//	TimeSheetV URLs
	public static final String TIMESHEET_BASE_URL = BASE_API_URL + "/v2/timesheet/";
	public static final String EMPLOYEE_TIMESHEET_SAVE_API = "/save/{userId}";
	public static final String EMPLOYEE_TIMESHEET_GET_API = "/get/{userId}";
	public static final String EMPLOYEE_TIMESHEET_EXPORT_API = "/export/{userId}";
	
	
	private APIRoutes() {

	}

}
