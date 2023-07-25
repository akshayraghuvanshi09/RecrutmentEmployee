package com.recruitmentmodule.utils;

/**
 * @author AKSHAY
 */
public class Constants {

	/*----------------------------------Email-----------------------*/
	public static final String MAIL_HOST_KEY = "mail.smtp.host";
	public static final String MAIL_PORT_KEY = "mail.smtp.port";
	public static final String MAIL_AUTH_KEY = "mail.smtp.auth";
	public static final String MAIL_DEBUG_KEY = "mail.smtp.debug";
	public static final String MAIL_SSL_ENABLE_KEY = "mail.smtp.ssl.enable";
	public static final String MAIL_DEBUG = "true";

	/*---------------------------------Date Patterns Constants*---------------------------------*/
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String DD_MM_YYYY = "MM-dd-yyyy";
	public static final String MM_DD = "MM-dd";
	public static final String FILE_SUFFIX_DATE_FORMAT = "yyyyMMddHHmmss";

	/*------------------------------------Prefix and Suffix----------------------------*/
	public static final String EMP_CODE_PREFIX = "ITS";
	public static final String TOKEN_PREFIX = "Bearer";

	/*---------------------------------URLs & URIs-------------------------*/
	public static final String FRONT_END_API_URL = "http://13.127.84.143:8083/#/reset-password/";
	public static final String BASE_URL = "/api/v1";
	public static final String DASHBOARD_CONTROLLER_BASE_URI = "/api/v1/dashboard";
	public static final String TEXT_OR_HTML = "text/html; charset=utf-8";

	/*------------------------------------Paths-----------------------*/
	public static final String DOCUMENT_DIR = "/home/ec2-user/apache-tomcat-9.0.65/webapps/emp_portal/user_documents/";
//	public static final String DOCUMENT_DIR = "D:\\documents\\";
	public static final String DOCUMENT_GLOBAL_PATH = "http://13.127.84.143:8080/emp_portal/user_documents/";

	public static final String ATTACHMENT_GLOBAL_PATH = "http://13.127.84.143:8080/emp_portal/user_attachments/";
	public static final String ATTACHMENT_DIR = "/home/ec2-user/apache-tomcat-9.0.65/webapps/emp_portal/user_attachments/";
//	public static final String ATTACHMENT_DIR = "D:\\attchment\\";

	public static final String USER_PROFILE_IMAGE_DIR = "/home/ec2-user/apache-tomcat-9.0.65/webapps/emp_portal/user_profile_images/";
//	public static final String USER_PROFILE_IMAGE_DIR = "D:\\userProfileImage\\";
	public static final String PROFILE_IMAGE_GLOBAL_PATH = "http://13.127.84.143:8080/emp_portal/user_profile_images/";
	
	public static final String OFFICIAL_DOCUMENT_DIR = "/home/ec2-user/apache-tomcat-9.0.65/webapps/emp_portal/user_official_documents/";
//	public static final String OFFICIAL_DOCUMENT_DIR = "D:/";
	public static final String OFFICIAL_DOCUMENT_GLOBAL_PATH = "http://13.127.84.143:8080/emp_portal/user_official_documents/";
	
	//logo urls
	public static final String CAKE_LOGO = "http://13.127.84.143:8080/ROOT/cake.gif";
	
	public static final String INTELLIATECH_LOGO = "http://13.127.84.143:8080/ROOT/logo.png";

	/*-----------------------------------Document Labels-------------------------------*/
	public static final String AADHAR_CARD_KEY = "aadharCard";
	public static final String PAN_CARD_KEY = "panCard";
	public static final String RELIEVING_LETTER_KEY = "relivingLetter";
	public static final String EXPERIENCE_CERTIFICATE_KEY = "experienceCertificate";
	public static final String SECONDARY_MARKSHEET_KEY = "secondaryMarksheet";
	public static final String HIGHER_SECONDARY_MARKSHEET_KEY = "higherSecondaryMarksheet";
	public static final String PROVISIONAL_CERTIFICATE_KEY = "provisionalCertificate";
	public static final String OFFER_LETTER_KEY = "offerLetter";

	public static final String PAY_SLIP_KEY = "paySlip" ;

	/*-------------------------------User Profile Constants--------------------------------*/
	public static final String USER_FAMILY_DETAILS = "Family Details";
	public static final String USER_REFERENCE_DETAILS = "Reference Details";
	public static final String USER_DETAILS = "User Details ";

	/*--------------------------File Extension Constants------------------------*/
	public static final String XLSX_FILE_EXTENSION_NAME = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	public static final String PDF_FILE_EXTENSION_NAME = "application/pdf";
	public static final String CSV_FILE_EXTENSION_NAME = "csv";
	public static final String XLS_FILE_EXTENSION_NAME = "application/vnd.ms-excel";

	// Events
	public static final String USER_MARRIED_ANNIVERSAY_EVENT = "marriedAnniversary";
	public static final String USER_WORK_ANNIVERSARY_EVENT = "workAnniversary";
	public static final String USER_BIRTHDAY_EVENT = "birthday";

	// Special character
	public static final String DOT = ".";
	public static final String UNDERSCORE = "_";

	/*-------------------Number as String value----------------------------*/
	public static final String ZERO_AS_STRING = "0";
	public static final String ONE_AS_STRING = "1";
	public static final String TWO_AS_STRING = "2";
	public static final String THREE_AS_STRING = "3";
	public static final String FOUR_AS_STRING = "4";
	public static final String FIVE_AS_STRING = "5";
	public static final String SIX_AS_STRING = "6";
	public static final String SEVEN_AS_STRING = "7";
	public static final String EIGHT_AS_STRING = "8";
	public static final String NINE_AS_STRING = "9";
	public static final String TEN_AS_STRING = "10";
	public static final String ELEVEN_AS_STRING = "11";
	public static final String TWELVE_AS_STRING = "12";

	/*------------------Number as Integer value--------------------------*/
	public static final Integer ZERO_AS_INTEGER = 0;
	public static final Integer ONE_AS_INTEGER = 1;
	public static final Integer NEGATIVE_ONE_AS_INTEGER = -1;
	public static final Integer TWO_AS_INTEGER = 2;
	public static final Integer THREE_AS_INTEGER = 3;
	public static final Integer FOUR_AS_INTEGER = 4;
	public static final Integer FIVE_AS_INTEGER = 5;
	public static final Integer SIX_AS_INTEGER = 6;
	public static final Integer SEVEN_AS_INEGER = 7;
	public static final Integer EIGHT_AS_INTEGER = 8;
	public static final Integer NINE_AS_INTEGER = 9;
	public static final Integer TEN_AS_INTEGER = 10;
	public static final Integer ELEVEN_AS_INTEGER = 11;
	public static final Integer TWELVE_AS_INTEGER = 12;

	/*-------------------------KEYS VALUE---------------------------------*/
	public static final String BIRTHDAYS_KEY = "birthdays";
	public static final String WORK_ANNIVERSARIES_KEY = "workAnniversaries";
	public static final String MARRIED_ANNIVERSARIES_KEY = "marriedAnniversaries";
	public static final String GLOBAL_KEY = "global";
	public static final String HEADER_KEY = "header";
	public static final String JWT_KEY = "JWT";
	public static final String ACCESS_EVERTHING_KEY = "accessEverything";
	public static final String PROFILE_IMAGE_KEY = "profileImage";
	public static final String USER_ID_KEY = "userId";
	public static final String REQUESTOR_ID_KEY = "requestorId";
	public static final String UNAUTHORIZED_KEY = "Unauthorized";
	public static final String PASSWORD_KEY = "password";
	public static final String AUTHORIZATION_HEADER_KEY = "Authorization";
	public static final String AUTHORIZATION_REFERESH_KEY = "AuthorizationRefresh";
	public static final String DATE_OF_BIRTHDAY_KEY = "dateOfBirth";
	public static final String DATE_OF_JOINING_KEY = "dateOfJoining";
	public static final String DATE_OF_MARRIAGE_KEY = "dateOfMarriage";
	public static final String EVENT_TYPE_KEY = "EVENT_TYPE";
	public static final String EVENT_DATE_KEY = "EVENT_DATE";
	public static final String EVENT_DAY_KEY = "EVENT_DAY";
	public static final String USER_KEY = "user";
	public static final String RESET_TOKEN_KEY = "resetToken";
	public static final String USERNAME_KEY = "username";
	public static final String STATUS_KEY = "status";
	public static final String REQUESTER_ID = "requesterId";
	public static final String PDF_KEY = "pdf";
	public static final String REPORTING_MANAGER_KEY = "reportingManager";
	public static final String REASON_KEY = "reasonOfLeave";
	public static final String LEAVE_TYPE = "typeOfLeave";
	public static final String FROM_DATE = "fromDate";
	public static final String TO_DATE = "toDate";
	public static final String ATTACHMENT_KEY = "attachment";
	public static final String LEAVE_ATTACHEMENT_KEY = "leaveAttachment";
	public static final String JUNIOR_KEY = "JUNIOR";
	public static final String SENIOR_KEY = "SENIOR";

	/*------------------HTTP Status Codes--------------------*/
	// 1xx Informational
	public static final Integer CONTINUE_HTTP_STATUS_CODE = 100;
	public static final Integer SWITCHING_PROTOCOLS_HTTP_STATUS_CODE = 101;
	public static final Integer PROCESSING_HTTP_STATUS_CODE = 102;
	// 2XX SUCCESS
	public static final Integer OK = 200;
	public static final Integer CREATED_HTTP_STATUS_CODE = 201;
	public static final Integer ACCEPTED_HTTP_STATUS_CODE = 202;
	public static final Integer NO_CONTENT_HTTP_STATUS_CODE = 204;
	public static final Integer RESET_CONTENT_HTTP_STATUS_CODE = 205;
	public static final Integer PARTIAL_HTTP_STATUS_CODE = 206;
	public static final Integer ALREADY_REPORTED_HTTP_STATUS_CODE = 208;
	// 3XX REDIRECTION
	public static final Integer MULTIPLE_HTTP_STATUS_CODE = 300;
	public static final Integer MOVED_PERMANENTLY_HTTP_STATUS_CODE = 301;
	public static final Integer FOUND_HTTP_STATUS_CODE = 302;
	public static final Integer SEE_OTHER_HTTP_STATUS_CODE = 303;
	public static final Integer NOT_MODIFIED_HTTP_STATUS_CODE = 304;
	public static final Integer USE_PROXY_HTTP_STATUS_CODE = 305;
	public static final Integer UNUSED_HTTP_STATUS_CODE = 306;
	public static final Integer TEMPORARY_REDIRECT_HTTP_STATUS_CODE = 307;
	public static final Integer PERMANENT_REDIRECT_HTTP_STATUS_CODE = 308;
	// 4XX CLIENT ERROR
	public static final Integer BAD_REQUEST_HTTP_STATUS_CODE = 400;
	public static final Integer UNAUTHORIZED_HTTP_STATUS_CODE = 401;
	public static final Integer PAYMENT_REQUIRED_HTTP_STATUS_CODE = 402;
	public static final Integer FORBIDDEN_HTTP_STATUS_CODE = 403;
	public static final Integer NOT_FOUND = 404;
	public static final Integer METHOD_NOT_ALLOWED_HTTP_STATUS_CODE = 405;
	public static final Integer NOT_ACCEPTABLE_HTTP_STATUS_CODE = 406;
	public static final Integer PROXY_AUTHENTICATION_REQUIRED_HTTP_STATUS_CODE = 407;
	public static final Integer REQUEST_TIMEOUT_HTTP_STATUS_CODE = 408;
	public static final Integer CONFLICT_HTTP_STATUS_CODE = 409;
	public static final Integer GONE_HTTP_STATUS_CODE = 410;
	public static final Integer LENGTH_REQUIRED_HTTP_STATUS_CODE = 411;
	public static final Integer PRECONDITION_FAILED_HTTP_STATUS_CODE = 412;
	public static final Integer REQUEST_ENTITY_TOO_LARGE_HTTP_STATUS_CODE = 413;
	public static final Integer REQUEST_URI_TOO_LONG_HTTP_STATUS_CODE = 414;
	public static final Integer UNSUPPORTED_MEDIA_TYPE_HTTP_STATUS_CODE = 415;
	public static final Integer REQUESTED_RANGE_NOT_SATISFIABLE_HTTP_STATUS_CODE = 416;
	public static final Integer EXPECTATION_FAILED_HTTP_STATUS_CODE = 417;
	public static final Integer LOCKED_HTTP_STATUS_CODE = 423;
	public static final Integer UPAGRADE_REQUIRED_HTTP_STATUS_CODE = 426;
	public static final Integer TOO_MANY_REQUESTS_HTTP_STATUS_CODE = 429;
	public static final Integer REQUEST_HEADER_FIELD_TOO_LARGE_HTTP_STATUS_CODE = 431;
	public static final Integer NO_RESPONSE_HTTP_STATUS_CODE = 444;
	public static final Integer RETRY_WITH_HTTP_STATUS_CODE = 449;
	// 5xx server error
	public static final Integer ERROR = 500;
	public static final Integer NOT_IMPLEMENTED_HTTP_STATUS_CODE = 501;
	public static final Integer BAD_GATEWAY_HTTP_STATUS_CODE = 502;
	public static final Integer SERVICE_UNAVAILABLE_HTTP_STATUS_CODE = 503;
	public static final Integer GATEWAY_TIMEOUT_HTTP_STATUS_CODE = 504;
	public static final Integer HTTP_VERSION_NOT_SUPPORTED_HTTP_STATUS_CODE = 505;
	public static final Integer NOT_EXTENDED_HTTP_STATUS_CODE = 510;
	public static final Integer NETWORK_AUTHENTICAION_REQUIRED_HTTP_STATUS_CODE = 511;
	public static final Integer NETWORK_READ_TIME_ERROR_HTTP_STATUS_CODE = 598;
	public static final Integer NETWORK_CONNECTION_TIME_OUT_HTTP_STATUS_CODE = 599;
	
	//Address Type
	public static final String ADDRESS_TYPE_BILLING ="BILLING";
	public static final String ADDRESS_TYPE_SHIPPING ="SHIPPING";

	private Constants() {

	}

}
