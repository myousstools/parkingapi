package com.parking.manager.web.beans.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ValidCreditCardConstraint implements ConstraintValidator<ValidCreditCard, String> {
   private final String CC_REGEXP = "[0-9]{16,20}";

   public void initialize(ValidCreditCard constraint) {
   }

   public boolean isValid(String value, ConstraintValidatorContext context) {
      return value == null || value.matches(CC_REGEXP);
   }
}
