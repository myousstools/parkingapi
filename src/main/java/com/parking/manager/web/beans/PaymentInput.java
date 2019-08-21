package com.parking.manager.web.beans;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.parking.manager.web.controller.Errors;

/**
 * The type Payment input.
 */
public class PaymentInput  {
  private Long billId;
  @NotNull(message = Errors.MISSING_CREDIT_CARD_ERROR_CODE)
  @Valid
  private CreditCard creditCard;

  /**
   * Gets credit card.
   *
   * @return the credit card
   */
  public CreditCard getCreditCard() {
    return creditCard;
  }

  /**
   * Sets credit card.
   *
   * @param creditCard the credit card
   */
  public void setCreditCard(CreditCard creditCard) {
    this.creditCard = creditCard;
  }

  /**
   * Gets bill id.
   *
   * @return the bill id
   */
  public Long getBillId() {
    return billId;
  }

  /**
   * Sets bill id.
   *
   * @param billId the bill id
   */
  public void setBillId(Long billId) {
    this.billId = billId;
  }
}
