package com.parking.manager.service.slot;

import java.util.Date;
import java.util.Random;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.parking.manager.dao.entity.PaymentTransaction;
import com.parking.manager.dao.entity.TransactionStatus;
import com.parking.manager.web.beans.CreditCard;

/**
 * The type Payment service.
 */
@Service
@Transactional
public class PaymentService implements IPaymentService {
  private static long TRANSACTION_NUMBER_GENERATOR = 0L;
//TODO
  @Override
  public PaymentTransaction submitPayment(CreditCard creditCard, float amount, String currency) {
    //Mocked service
    PaymentTransaction transaction = new PaymentTransaction();
    transaction.setDate(new Date());
    transaction.setNumber(TRANSACTION_NUMBER_GENERATOR++);
    Random random = new Random(System.currentTimeMillis());
    //cases for tests
    if ("0000000000000000".equals(creditCard.getNumber())) {
      transaction.setStatus(TransactionStatus.FAILURE);
    } else if ("1111111111111111".equals(creditCard.getNumber())) {
      transaction.setStatus(TransactionStatus.SUCCESS);
    } else {
      transaction.setStatus(random.nextBoolean() ? TransactionStatus.SUCCESS : TransactionStatus.FAILURE);
    }
    return transaction;
  }
}
