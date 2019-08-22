package com.parking.manager.web.beans.validation;

import java.lang.annotation.Documented;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * The interface Valid car plate number.
 */
@Documented
@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = ValidCarPlateNumberConstraint.class)
public @interface ValidCarPlateNumber {
  /**
   * Message string.
   *
   * @return the string
   */
  String message() default "Invalid card number";

  /**
   * Groups class [ ].
   *
   * @return the class [ ]
   */
  Class<?>[] groups() default {};

  /**
   * Payload class [ ].
   *
   * @return the class [ ]
   */
  Class<? extends Payload>[] payload() default {};
}
