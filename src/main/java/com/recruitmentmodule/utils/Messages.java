package com.recruitmentmodule.utils;

/**
 * @author AKSHAY
 */
public class Messages {

	public static final String NULL_REQUEST = "Field should not be empty";
	public static final String SUCCESS_MOBILE_VERIFY = "Mobile Number Verified";

	public static final String INVALID_MOBILE_NUM = "Invalid Mobile Number Please provide Valid Number";
	public static final String SUCCESS_DOCUMENT_VALIDATION = "Image Document Verified";
	public static final String INVALID_DOCUMENT = "Invalid Document Please provide Valid Image Document";
	public static final String NEW_USERID_UPDATE_SUCCESS = "New UserId Updated Successfully";
	public static final String NEW_USERID_UPDATE_FAILURE = "New UserId Updated Successfully";
	public static final String INVALID_FILE_TYPE = "Please provide valid File Type";
	public static final String UPDATE_ERROR = "Update Error";
	public static final String SUCCESS = "SUCCESS";

	public static final String INVALID_ID = "Invalid ID Please provide valid ID";
	public static final String INVALID_NAME = "Invalid ItemName Please provide valid ItemName";
	public static final String INVALID_Value = "Enter The Value ";
	public static final String INVALID_FIELD = "Invalid Customer , Please Enter the Customer name";
	public static final String INVALID_GSTNO = "Invalid Company , Please  Enter the Company GST number";
	public static final String INVALID_ACCOUNTDETAILS = "Invalid AccountDetais, Please Enter the Account Details";
	public static final String INVALID_ADDRESSDETAILS = "Invalid AddrssDetails, plese Enter the Address Details";
	public static final String OTP = "otp";
	public static final String USER_NOT_EXIST_DB = "User Does not exists in our Database";

	public static final String SUCCESS_UPDATED_PWD = "New Password Updated Successfully";
	public static final String FAILURE_UPDATED_PWD = "New Password Updated Successfully";

	// Common messages
	public static final String SUCCESS_MESSAGE = "Success";
	public static final String FAILURE_MESSAGE = "Failed";
	public static final String FAILURE_LOGIN_MSG = "Sign-in failed:bad credentials";
	public static final String BAD_REQUEST = "Bad Request";
	public static final String EXCEPTION = "Exception";
	public static final String FETCH_ERROR = "Fetch Error from API";

	// Send/Varify OTP messages
	public static final String SUCCESS_OTP_TO_MOBILE = "Enter One Time Password (OTP) sent to your number";
	public static final String FAILED_TO_SEND_OTP = "Something went wrong, failed to send OTP";
	public static final String OTP_SUCCESS = "OTP Sent Successfully";
	public static final String SUCESS_OTP_VALIDATION = "OTP Validated Successfully";
	public static final String INVALID_OTP = "Invalid OTP";

	// Update profile
	public static final String SUCCES_MOBILE_NUM_UPDATE = "Mobile number updated successfully";
	public static final String FAILED_MOBILE_NUM_UPDATE = "Failed to update mobile number.";

	/*---------------------------Responses Of requests---------------------------------*/
	public static final String USER_INITIATION_FAILED = "User intiatiation failed";
	public static final String USER_ALREADY_EXISTS = "User already exists";
	public static final String USER_ROLE_NOT_EXISTS = "Role doesn't exists";
	public static final String DESIGNATION_NOT_EXISTS = "Designation doesn't exists";
	public static final String USER_INITIATED_SUCCESSFULLY = "User initiated successfully";
	public static final String SWW = "Something went wrong";
	public static final String USER_NOT_FOUND = "User not found";
	public static final String USER_DETAILS_NOT_FOUND = "User details not found";
	public static final String REFERECE_DETAILS_NOT_FOUND = "Reference details not found";
	public static final String LOGIN_SUCCESS_STATUS = "Login Success";
	public static final String ON_BOARDING_INITIATED = "Onboarding Initiated";
	public static final String USER_DOES_NOT_EXISTS = "User doesn't exists";
	public static final String DOCUMENT_DOES_NOT_EXISTS = "Document doesn't exists";
	public static final String WRONG_PASSWORD = "Wrong Password";
	public static final String UPDATED_DATA_SUCCESSFULLY = "Updated data successfully";
	public static final String UNAUTHORIZED_USER = "Unauthorized User";
	public static final String TRANSACTION_DOES_NOT_EXISTS = "Transaction Does Not Exists";

	public static final String DATA_NOT_FOUND = "Data Not Found";

	public static final String CURRENT_DATE = "Please Enter the current Date";

	public static final String DATE_FROMAT = "Date must be in yyyy-MM-dd format";

	public static final String EMPTY_DATE = "Date Should be not null";

	public static final String SAVE_ONCE = "Save only once in a day";

	public static final String NULL_ADDRESS_MSG = "Address can not be null";

	public static final String INVALID_ADDRESS_TYPE = "Invalid Address type";

	public static final String ADDRESS_NOT_FOUND = "Customer Address not found ";
	public static final String ID_NOT_FOUND = "Id not found";
	public static final String POST_DELETED_WITH_ID = "Post Deleted with id :";
	public static final String SELECTED_DATA_DELETED = "Selected data deleted";
	public static final String DATA_DELETE = "Data Deleted";

	// Add Job
	public static final String INVALID_SELECTION = "Invalid Selection , Please select one option";
	public static final String INVALID_TITLE = "Invalid Title , Please write valid title";
	public static final String EMPTY_LIST = "List is completely empty";
	public static final String SELECT_POST = "Please select atleast one post";

	// Add Job Default values
	public static final String SETCOMPANY_NAME = "HR1";
	public static final Integer SET_VACANCY = 10;
	public static final String SET_SHORT_DESCRIPTION = "This is short description";
	public static final String SET_LONG_DESCRIPTION = "This is long description";

	// Job Candidate

	public static final String INVALID_EMAIL = "Invalid email id,Please write valid email id";
	public static final String FILE_NOT_FOUNF = "File can not be empty,Please select valid file";

	private Messages() {

	}

}
