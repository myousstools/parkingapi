package com.parking.manager.service.exception;

import com.parking.manager.ParkingException;

/**
 * The type Parking functional exception.
 */
public class ParkingFunctionalException extends ParkingException {
  /**
   * Instantiates a new Parking functional exception.
   *
   * @param errorCode the error code
   */
  public ParkingFunctionalException(String errorCode) {
    super(errorCode);
  }

  /**
   * Instantiates a new Parking functional exception.
   *
   * @param s         the s
   * @param errorCode the error code
   */
  public ParkingFunctionalException(String s, String errorCode) {
    super(s, errorCode);
  }

  /**
   * Instantiates a new Parking functional exception.
   *
   * @param s         the s
   * @param throwable the throwable
   * @param errorCode the error code
   */
  public ParkingFunctionalException(String s, Throwable throwable, String errorCode) {
    super(s, throwable, errorCode);
  }

  /**
   * Instantiates a new Parking functional exception.
   *
   * @param throwable the throwable
   * @param errorCode the error code
   */
  public ParkingFunctionalException(Throwable throwable, String errorCode) {
    super(throwable, errorCode);
  }

  /**
   * Instantiates a new Parking functional exception.
   *
   * @param s         the s
   * @param throwable the throwable
   * @param b         the b
   * @param b1        the b 1
   * @param errorCode the error code
   */
  public ParkingFunctionalException(String s, Throwable throwable, boolean b, boolean b1, String errorCode) {
    super(s, throwable, b, b1, errorCode);
  }
}
