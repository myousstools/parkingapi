package com.parking.manager.web.beans.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidCarPlateNumberConstraintTest {
  @Test
  public void test_isValid_OK() {
    ValidCarPlateNumberConstraint constraint = new ValidCarPlateNumberConstraint();
    assertTrue(constraint.isValid(null, null));
    assertTrue(constraint.isValid("AB-123-XX", null));
    assertTrue(constraint.isValid("ABCDEB", null));
    assertTrue(constraint.isValid("AB 100 EB", null));
  }

  @Test
  public void test_isValid_KO() {
    ValidCarPlateNumberConstraint constraint = new ValidCarPlateNumberConstraint();
    assertFalse(constraint.isValid("", null));
    assertFalse(constraint.isValid("A", null));
    assertFalse(constraint.isValid("^7H", null));
  }
}