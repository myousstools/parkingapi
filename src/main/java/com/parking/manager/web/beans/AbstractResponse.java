package com.parking.manager.web.beans;

import java.util.List;


/**
 * The type Abstract response.
 */
public class AbstractResponse {

  private boolean success;
  private List<String> errorCodes;
  private List<String> errorMessages;

  /**
   * Is success boolean.
   *
   * @return the boolean
   */
  public boolean isSuccess() {
    return success;
  }

  /**
   * Sets success.
   *
   * @param success the success
   */
  public void setSuccess(boolean success) {
    this.success = success;
  }

  /**
   * Gets error codes.
   *
   * @return the error codes
   */
  public List<String> getErrorCodes() {
    return errorCodes;
  }

  /**
   * Sets error codes.
   *
   * @param errorCodes the error codes
   */
  public void setErrorCodes(List<String> errorCodes) {
    this.errorCodes = errorCodes;
  }

  /**
   * Gets error messages.
   *
   * @return the error messages
   */
  public List<String> getErrorMessages() {
    return errorMessages;
  }

  /**
   * Sets error messages.
   *
   * @param errorMessages the error messages
   */
  public void setErrorMessages(List<String> errorMessages) {
    this.errorMessages = errorMessages;
  }
}
