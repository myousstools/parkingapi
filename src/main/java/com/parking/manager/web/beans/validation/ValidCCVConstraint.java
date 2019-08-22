package com.parking.manager.web.beans.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The type Valid ccv constraint.
 */
public class ValidCCVConstraint implements ConstraintValidator<ValidCCV, String> {
  private final String CCV_REGEXP = "[0-9]{3}";

  @Override
  public void initialize(ValidCCV constraint) {
    //no initialisation needed
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value == null || value.matches(CCV_REGEXP);
  }
}
