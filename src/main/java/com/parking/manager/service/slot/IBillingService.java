package com.parking.manager.service.slot;

import com.parking.manager.dao.entity.Bill;
import com.parking.manager.dao.entity.PaymentTransaction;
import com.parking.manager.dao.entity.SlotAssignment;
import com.parking.manager.service.exception.ParkingFunctionalException;
import com.parking.manager.web.beans.PaymentInput;

/**
 * The interface Billing service. It defines the methods signature manage billing for a given parking slot assignment.
 */
public interface IBillingService {
  /**
   * Create bill.
   *
   * @param assignment the assignment
   * @return the bill
   */
  Bill createBill(SlotAssignment assignment);

  Bill getBill(Long id) throws ParkingFunctionalException;

  PaymentTransaction payBill(PaymentInput paymentInput) throws ParkingFunctionalException;
}
