package com.parking.manager.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.parking.manager.service.exception.ParkingFunctionalException;

/**
 * The type Errors.
 */
public class Errors {

  /**
   * The constant MISSING_PLATENUMBER_ERROR_CODE.
   */
//validation error codes
  public static final String MISSING_PLATENUMBER_ERROR_CODE = "10001";
  /**
   * The constant EMPTY_PLATENUMBER_ERROR_CODE.
   */
  public static final String EMPTY_PLATENUMBER_ERROR_CODE = "10002";
  /**
   * The constant INVALID_PLATENUMBER_ERROR_CODE.
   */
  public static final String INVALID_PLATENUMBER_ERROR_CODE = "10003";
  /**
   * The constant MISSING_SLOT_TYPE_ERROR_CODE.
   */
  public static final String MISSING_SLOT_TYPE_ERROR_CODE = "10004";

  /**
   * The constant GENERIC_ERROR.
   */
//technical error codes
  public static final String GENERIC_ERROR = "20000";
  /**
   * The constant NO_MORE_AVAILABLE_SLOT_ERROR_CODE.
   */
//functional error codes
  public static final String NO_MORE_AVAILABLE_SLOT_ERROR_CODE = "30001";
  /**
   * The constant NO_ACTIVE_ASSIGNMENT_FOR_THIS_CAR_ERROR_CODE.
   */
  public static final String NO_ACTIVE_ASSIGNMENT_FOR_THIS_CAR_ERROR_CODE = "30002";
  public static final String ALREADY_PAYED_BILL_ERROR_CODE = "30003";
  public static final String PAYMENT_TRANSACTION_FAILED_ERROR_CODE = "30004";
  public static final String BILL_NOT_FOUND_ERROR_CODE = "30005";
  public static final String RESOURCE_NOT_FOUND_ERROR_CODE = "30006";
  public static final String INVALID_CREDIT_CARD_ERROR_CODE = "30007";
  public static final String MISSING_CREDIT_CARD_ERROR_CODE = "30008";
  public static final String INVALID_CREDIT_CARD_CCV_ERROR_CODE = "30009";
  public static final String INVALID_EXPIRATION_DATE_ERROR_CODE = "30010";
  public static final String MISSING_CREDIT_CARD_OWNER_ERROR_CODE = "30011";
  public static final String INVALID_CREDIT_CARD_OWNER_ERROR_CODE = "30012";
  public static final String INVALID_TYPE_ERROR_CODE = "30013";
  public static final String MISSING_CREADIT_CARD_OBJECT_ERROR_CODE = "30008";

  private final static Map<String, String> ERROR_MESSAGES_MAP = new HashMap<>();

  static {

    ERROR_MESSAGES_MAP.put(GENERIC_ERROR, "Generic Error");
    ERROR_MESSAGES_MAP.put(MISSING_PLATENUMBER_ERROR_CODE, "Missing plate number");
    ERROR_MESSAGES_MAP.put(EMPTY_PLATENUMBER_ERROR_CODE, "Empty plate number");
    ERROR_MESSAGES_MAP.put(INVALID_PLATENUMBER_ERROR_CODE, "Invalid plate number");
    ERROR_MESSAGES_MAP.put(MISSING_SLOT_TYPE_ERROR_CODE, "Missing Slot type");
    ERROR_MESSAGES_MAP.put(NO_MORE_AVAILABLE_SLOT_ERROR_CODE, "No more available slot");
    ERROR_MESSAGES_MAP.put(NO_ACTIVE_ASSIGNMENT_FOR_THIS_CAR_ERROR_CODE,
        "No active assignment for this car plate number");
    ERROR_MESSAGES_MAP.put(ALREADY_PAYED_BILL_ERROR_CODE, "Already Payed bill");
    ERROR_MESSAGES_MAP.put(PAYMENT_TRANSACTION_FAILED_ERROR_CODE, "Transaction failed");
    ERROR_MESSAGES_MAP.put(BILL_NOT_FOUND_ERROR_CODE, "Bill not found");
    ERROR_MESSAGES_MAP.put(RESOURCE_NOT_FOUND_ERROR_CODE, "Resource not found");
    ERROR_MESSAGES_MAP.put(INVALID_CREDIT_CARD_ERROR_CODE, "Invalid Credit Card number");
    ERROR_MESSAGES_MAP.put(MISSING_CREDIT_CARD_ERROR_CODE, "Missing Credit Card number");
    ERROR_MESSAGES_MAP.put(INVALID_CREDIT_CARD_CCV_ERROR_CODE, "Invalid Credit Card CCV");
    ERROR_MESSAGES_MAP.put(INVALID_EXPIRATION_DATE_ERROR_CODE, "Invalid expiration date");
    ERROR_MESSAGES_MAP.put(MISSING_CREDIT_CARD_OWNER_ERROR_CODE, "Missing owner name");
    ERROR_MESSAGES_MAP.put(INVALID_CREDIT_CARD_OWNER_ERROR_CODE, "Invalid owner name");
    ERROR_MESSAGES_MAP.put(INVALID_TYPE_ERROR_CODE, "Invalid input type");
    ERROR_MESSAGES_MAP.put(MISSING_CREADIT_CARD_OBJECT_ERROR_CODE, "Missing Credit Card Object");

  }

  /**
   * Gets message for code.
   *
   * @param errorCode the error code
   * @return the message for code
   */
  public static String getMessageForCode(String errorCode) {
    return ERROR_MESSAGES_MAP.get(errorCode);
  }

  public static ParkingFunctionalException getFunctionalExceptionFromErrorCode(String errorCode) {
    return new ParkingFunctionalException(errorCode, getMessageForCode(errorCode));
  }
}
