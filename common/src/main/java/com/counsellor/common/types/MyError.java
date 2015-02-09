/**
 * Error Codes Enum contains the Error Code and the Error String.
 */
package com.counsellor.common.types;

public enum MyError {

	//=================================================
	// Enums
	//=================================================
	/**
	 * GenericSystemError in Profile Service getAttributes
	 */
	SYSTEM_PROFILE_GET("SYS00001","Generic System error in Profile ProfileService.getAttribute"),
	/**
	 * GenericSystemError in Profile constructKeys
	 */
	SYSTEM_PROFILE_CONSTRUCT_KEYS("SYS00002","Generic System error in  ProfileService.constructKeys"),
	/**
	 * GenericSystemError in Profile constructAttrNames
	 */
	SYSTEM_PROFILE_CONSTRUCT_ATTR_NAMES("SYS00003","Generic System error in ProfileService.constructAttrNames"),
	/**
	 * GenericSystemError in Profile keysValidation
	 */
	SYSTEM_PROFILE_KEY_VALIDATION("SYS00004","Generic System error in  ProfileService.keysValidation"),
	/**
	 * GenericSystemError in Profile createAndValidateAttributes
	 */
	SYSTEM_PROFILE_CREATE_VALIDATE_ATTRIBUTES("SYS00005","Generic System error in  ProfileService.createAndValidateAttributes"),
	/**
	 * GenericSystemError in Profile getVinciAttributes
	 */
	SYSTEM_SERVICE_CORE_GETVinciAttributeS("SYS00006","Generic System error in ServiceCoreBaseImpl.getVinciAttributes"),
	/**
	 * GenericSystemError in Profile intialProcessing
	 */
	SYSTEM_SERVICE_CORE_INITIALPROCESSING("SYS00007","Generic System error in ServiceCoreBaseImpl.intialProcessing"),
	/**
	 * GenericSystemError in Profile fetchAttributes
	 */
	SYSTEM_SERVICE_CORE_FETCHATTRIBUTES("SYS00007","Generic System error in ServiceCoreBaseImpl.fetchAttributes"),
	/**
	 * IllegalArgumentException in ServiceCoreBaseImpl preprocess
	 */
	SYSTEM_SERVICE_CORE_PREPROCESS1("SYS00008","IllegalArgumentException in ServiceCoreBaseImpl.preprocess"),
	/**
	 * InstantiationException in ServiceCoreBaseImpl preprocess
	 */
	SYSTEM_SERVICE_CORE_PREPROCESS2("SYS00009","InstantiationException in ServiceCoreBaseImpl.preprocess"),/**
	/**
	 *IllegalAccessException in ServiceCoreBaseImpl preprocess
	 */
	SYSTEM_SERVICE_CORE_PREPROCESS3("SYS00010","IllegalAccessException in ServiceCoreBaseImpl.preprocess"),/**
	 /*
	 * InvocationTargetException in ServiceCoreBaseImpl preprocess
	 */
	SYSTEM_SERVICE_CORE_PREPROCESS4("SYS00011","InvocationTargetException in ServiceCoreBaseImpl.preprocess"),/**
	 /**
	 *  ClassNotFoundException in ServiceCoreBaseImpl preprocess
	 */
	SYSTEM_SERVICE_CORE_PREPROCESS5("SYS00012","ClassNotFoundException in ServiceCoreBaseImpl.preprocess"),/**
	 /**
	 * SecurityException in ServiceCoreBaseImpl preprocess
	 */
	SYSTEM_SERVICE_CORE_PREPROCESS6("SYS00013","SecurityException in ServiceCoreBaseImpl.preprocess"),
	/**
	 * NoSuchMethodException in ServiceCoreBaseImpl preprocess
	 */
	SYSTEM_SERVICE_CORE_PREPROCESS7("SYS00014","NoSuchMethodException in ServiceCoreBaseImpl.preprocess"),
	/**
	 * ConfigCategoryCreateException in ServiceCoreImpl createExecutorBean
	 */
	SYSTEM_SERVICE_CORE_CREATE_EXECUTOR_BEAN1("SYS00015","ConfigCategoryCreateException in ServiceCoreImpl createExecutorBean"),
	/**
	 * Exception in ServiceCoreImpl createExecutorBean
	 */
	SYSTEM_SERVICE_CORE_CREATE_EXECUTOR_BEAN2("SYS00016","Generic Exception in ServiceCoreImpl createExecutorBean"),
	/**
	 * Exception in ServiceCoreImpl validateAttributes
	 */
	SYSTEM_SERVICE_CORE_VALIDATE_ATTRIBUTES("SYS00017","Generic Exception in ServiceCoreImpl validateAttributes"),
	/**
	 * Exception in ServiceCoreImpl isValidName
	 */
	SYSTEM_SERVICE_CORE_FETCH_ATTRIBUTES1("SYS00018","ExecutionException  in ServiceCoreImpl fetchAttributes"),
	/**
	 * Exception in ServiceCoreImpl fetchAttributes.CancellationException
	 */
	SYSTEM_SERVICE_CORE_FETCH_ATTRIBUTES2("SYS00019","CancellationException in ServiceCoreImpl fetchAttributes"),
	/**
	 * Exception in ServiceCoreImpl fetchAttributes.InterruptedException
	 */
	SYSTEM_SERVICE_CORE_FETCH_ATTRIBUTES3("SYS00020","Interrupted Exception in ServiceCoreImpl fetchAttributes"),
	/**
	 * Exception in ServiceCoreImpl fetchAttributes
	 */
	SYSTEM_SERVICE_CORE_FETCH_ATTRIBUTES4("SYS00021","Generic Exception in ServiceCoreImpl fetchAttributes"),
	/**
	 * Exception in ServiceCoreImpl isValidName
	 */
	SYSTEM_SERVICE_CORE_IS_VALID_NAMES("SYS00022","Generic Exception  in ServiceCoreImpl isValidNames"),
	/**
	 * Exception in ServiceCoreImpl isAttributeExists
	 */
	SYSTEM_SERVICE_CORE_IS_ATTRIBUTE_EXISTS("SYS00023","ExecutionException  in ServiceCoreImpl isAttributeExists"),
	/**
	 * Exception in ServiceCoreImpl fetchAttributes
	 */
	SYSTEM_SERVICE_CORE_FETCH_ATTRIBUTES_GENERIC("SYS00024","Exception in ServiceCoreImpl fetchAttributes"),

	/**
	 * Mandatory field User id is missing
	 */
	USER_USER_ID_REQUIRED("USR00000", "USER_ID is a required field"),

	/**
	 * Attribute id is invalid
	 */
	USER_INVALID_ATTRIBUTE_REQUEST("USR00001", "This attribute_id is invalid"),

	/**
	 * DalAdapter error codes
	 */
	SYSTEM_DALADAPTER_GET_FAILURE("SYS00101", "System Error: failed to retrieve attributes"),
	SYSTEM_DALADAPTER_SET_FAILURE("SYS00102", "System Error: failed to upsert attributes"),

	SP_INVALID_GRADE_AGE_MAPPING("SP00001", "There is no proper age mapping found for the selected grade(s)"),


	/**
	 * Mandatory field User id is missing
	 */
	IMPORT_CONTACTS_INVALID_LOGIN("IMP00000", "Invalid credentials supplied.");
	
	


	//=================================================
	// Class Variables
	//=================================================

	//=================================================
	// Instance Variables
	//=================================================
	private final String errorCode;
	private final String errorString;

	//=================================================
	// Constructors
	//=================================================
	private MyError(final String errorCode, final String errorString) {
		this.errorCode = errorCode;
		this.errorString = errorString;
	}

	//=================================================
	// Class Methods
	//=================================================

	//=================================================
	// Instance Methods
	//=================================================
	@Override
	public String toString() {
		return this.errorCode + ": " + this.errorString;
	}

	//=================================================
	// Accessors
	//=================================================
	public String getErrorCode() {
		return this.errorCode;
	}

	public String getErrorString() {
		return this.errorString;
	}
}
