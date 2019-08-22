package com.parking.manager.web.beans.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCreditCardConstraint implements ConstraintValidator<ValidCreditCard, String> {
  private static final String CC_REGEXP = "[0-9]{16,20}";

  @Override
  public void initialize(ValidCreditCard constraint) {
    //no initialisation needed
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    return value == null || value.matches(CC_REGEXP);
  }
}
