package com.parking.manager.web.beans.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidCCVConstraintTest {
  @Test
  public void test_isValid_OK() {
    ValidCCVConstraint constraint = new ValidCCVConstraint();
    assertTrue(constraint.isValid(null, null));
    assertTrue(constraint.isValid("123", null));
  }

  @Test
  public void test_isValid_KO() {
    ValidCCVConstraint constraint = new ValidCCVConstraint();
    assertFalse(constraint.isValid("", null));
    assertFalse(constraint.isValid("ABC", null));
    assertFalse(constraint.isValid("12", null));
    assertFalse(constraint.isValid("1234", null));
  }
}