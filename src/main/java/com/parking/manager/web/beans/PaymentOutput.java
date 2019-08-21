package com.parking.manager.web.beans;


/**
 * The type Payment output.
 */
public class PaymentOutput extends AbstractResponse {
  private PaymentTransaction transation;

  public PaymentTransaction getTransation() {
    return transation;
  }

  public void setTransation(PaymentTransaction transation) {
    this.transation = transation;
  }
}
