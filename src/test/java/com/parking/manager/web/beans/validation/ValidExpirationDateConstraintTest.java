package com.parking.manager.web.beans.validation;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidExpirationDateConstraintTest {
  @Test
  public void test_isValid_OK() {
    ValidExpirationDateConstraint constraint = new ValidExpirationDateConstraint();
    assertTrue(constraint.isValid(null, null));
    assertTrue(constraint.isValid("12/30", null));
  }

  @Test
  public void test_isValid_KO() {
    ValidExpirationDateConstraint constraint = new ValidExpirationDateConstraint();
    assertFalse(constraint.isValid("", null));
    assertFalse(constraint.isValid("12/13", null));
    assertFalse(constraint.isValid("ALPHA12", null));
    assertFalse(constraint.isValid("@!", null));
  }
}