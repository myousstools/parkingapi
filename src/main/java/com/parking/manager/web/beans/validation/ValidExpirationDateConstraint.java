package com.parking.manager.web.beans.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

/**
 * The type Valid expiration date constraint.
 */
public class ValidExpirationDateConstraint implements ConstraintValidator<ValidExpirationDate, String> {
  private static final String DATE_FORMAT = "dd/yy";

  @Override
  public void initialize(ValidExpirationDate constraint) {
    //no initialisation needed
  }

  @Override
  public boolean isValid(String dateString, ConstraintValidatorContext context) {
    if (dateString == null) {
      return true;
    } else {
      try {
        DateTime dateTime = DateTime.parse(dateString, DateTimeFormat.forPattern(DATE_FORMAT));
        DateTime now = DateTime.now();
        return dateTime != null && dateTime.isAfter(now); //TODO to improve
      } catch (IllegalArgumentException e) {
        return false;
      }
    }
  }
}
