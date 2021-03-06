package com.parking.manager.web.beans.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * The type Valid car plate number constraint.
 */
public class ValidCarPlateNumberConstraint implements ConstraintValidator<ValidCarPlateNumber, String> {
  private static final String PLATENUMBER_REGEXP = "([0-9A-Z]{2,}[ -]?)+";

  @Override
  public void initialize(ValidCarPlateNumber constraint) {
    //no initialisation needed
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value == null || value.matches(PLATENUMBER_REGEXP);
  }
}
