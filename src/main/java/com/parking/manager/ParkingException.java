package com.parking.manager;

/**
 * The type Parking exception.
 */
public class ParkingException extends Exception {
  private String errorCode;

  /**
   * Instantiates a new Parking exception.
   *
   * @param errorCode the error code
   */
  public ParkingException(String errorCode) {
    this.errorCode = errorCode;
  }

  /**
   * Instantiates a new Parking exception.
   *
   * @param s         the s
   * @param errorCode the error code
   */
  public ParkingException(String s, String errorCode) {
    super(s);
    this.errorCode = errorCode;
  }

  /**
   * Instantiates a new Parking exception.
   *
   * @param s         the s
   * @param throwable the throwable
   * @param errorCode the error code
   */
  public ParkingException(String s, Throwable throwable, String errorCode) {
    super(s, throwable);
    this.errorCode = errorCode;
  }

  /**
   * Instantiates a new Parking exception.
   *
   * @param throwable the throwable
   * @param errorCode the error code
   */
  public ParkingException(Throwable throwable, String errorCode) {
    super(throwable);
    this.errorCode = errorCode;
  }

  /**
   * Instantiates a new Parking exception.
   *
   * @param s         the s
   * @param throwable the throwable
   * @param b         the b
   * @param b1        the b 1
   * @param errorCode the error code
   */
  public ParkingException(String s, Throwable throwable, boolean b, boolean b1, String errorCode) {
    super(s, throwable, b, b1);
    this.errorCode = errorCode;
  }

  /**
   * Gets error code.
   *
   * @return the error code
   */
  public String getErrorCode() {
    return errorCode;
  }

  /**
   * Sets error code.
   *
   * @param errorCode the error code
   */
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }
}
