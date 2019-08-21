package com.parking.manager.service.slot;

import com.parking.manager.dao.entity.PaymentTransaction;
import com.parking.manager.web.beans.CreditCard;

/**
 * The interface Payment service.
 */
public interface IPaymentService {
  /**
   * Submit payment request.
   *
   * @param creditCard the credit card
   * @param amount     the amount
   * @param currency   the currency
   * @return the payment transaction
   */
  PaymentTransaction submitPayment(CreditCard creditCard, float amount, String currency);
}
