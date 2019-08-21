package com.parking.manager.web.beans.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidCreditCardConstraintTest {
  @Test
  public void test_isValid_OK() {
    ValidCreditCardConstraint constraint = new ValidCreditCardConstraint();
    assertTrue(constraint.isValid(null, null));
    assertTrue(constraint.isValid("0000000000000000", null));
    assertTrue(constraint.isValid("1111111111111111", null));
    assertTrue(constraint.isValid("11111111111111111", null));
    assertTrue(constraint.isValid("111111111111111111", null));
    assertTrue(constraint.isValid("1111111111111111111", null));
    assertTrue(constraint.isValid("11111111111111111111", null));
  }

  @Test
  public void test_isValid_KO() {
    ValidCreditCardConstraint constraint = new ValidCreditCardConstraint();
    assertFalse(constraint.isValid("", null));
    assertFalse(constraint.isValid("123", null));
    assertFalse(constraint.isValid("ALPHA12", null));
    assertFalse(constraint.isValid("111111111111111111111", null));
  }
}