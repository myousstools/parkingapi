package com.parking.manager.service.slot;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.manager.dao.PaymentTransationDAO;
import com.parking.manager.dao.entity.Bill;
import com.parking.manager.dao.BillDAO;
import com.parking.manager.dao.entity.Fare;
import com.parking.manager.dao.FareDAO;
import com.parking.manager.dao.entity.PaymentStatus;
import com.parking.manager.dao.entity.PaymentTransaction;
import com.parking.manager.dao.entity.SlotAssignment;
import com.parking.manager.dao.entity.TransactionStatus;
import com.parking.manager.service.exception.ParkingFunctionalException;
import com.parking.manager.service.fare.IFareEngineService;
import com.parking.manager.web.beans.PaymentInput;
import com.parking.manager.web.controller.Errors;

/**
 * The type Billing service.
 */
@Service
@Transactional
public class BillingServiceImpl implements IBillingService {
  //TODO could be configured in the database
  private static final String DEFAULT_CURRENCY_CODE = "EUR";
  /**
   * The Fare engine service.
   */
  @Autowired
  IFareEngineService fareEngineService;
  /**
   * The Bill dao.
   */
  @Autowired
  BillDAO billDAO;
  /**
   * The Fare dao.
   */
  @Autowired
  FareDAO fareDAO;

  @Autowired
  IPaymentService paymentService;

  @Autowired
  PaymentTransationDAO paymentTransationDAO;

  @Override
  public Bill createBill(SlotAssignment assignment) {
    //create dynamically the fare to apply
    Fare fare = fareEngineService.makeFare(assignment.getSlot());
    float durationInHours = getStayDurationInHours(
        LocalDateTime.ofInstant(assignment.getStartDateTime().toInstant(), ZoneId.systemDefault()),
        LocalDateTime.ofInstant(assignment.getEndDateTime().toInstant(), ZoneId.systemDefault()), fare.isProrated());
    float amount = durationInHours * fare.getHourPrice() + fare.getFixedAmount();
    Bill bill = new Bill();
    bill.setSlotAssignment(assignment);
    bill.setAmount(amount);
    bill.setFare(fare);
    bill.setCreationDate(new Date());
    bill.setCurrencyCode(DEFAULT_CURRENCY_CODE);
    bill.setPaymentStatus(PaymentStatus.PENDING);
    fareDAO.save(fare);
    billDAO.saveAndFlush(bill);
    return bill;
  }

  @Override
  public Bill getBill(Long id) throws ParkingFunctionalException {
    Bill bill = billDAO.findById(id).orElseThrow(
        () -> Errors.getFunctionalExceptionFromErrorCode(Errors.RESOURCE_NOT_FOUND_ERROR_CODE));
    return bill;
  }

  @Override
  public PaymentTransaction payBill(PaymentInput paymentInput) throws ParkingFunctionalException {
    Bill bill = getBill(paymentInput.getBillId());
    if (bill != null) {
      if (bill.getPaymentStatus() == PaymentStatus.PENDING) {
        PaymentTransaction transaction = paymentService.submitPayment(paymentInput.getCreditCard(), bill.getAmount(),
            bill.getCurrencyCode());
        if (transaction != null) {
          if (transaction.getStatus() == TransactionStatus.SUCCESS) {
            bill.setPaymentStatus(PaymentStatus.PAYED);
          }
          transaction.setBill(bill);
          paymentTransationDAO.saveAndFlush(transaction);
          if (transaction.getStatus() == TransactionStatus.FAILURE) {
            throw Errors.getFunctionalExceptionFromErrorCode(Errors.PAYMENT_TRANSACTION_FAILED_ERROR_CODE);
          }
          return transaction;
        } else {
          throw Errors.getFunctionalExceptionFromErrorCode(Errors.PAYMENT_TRANSACTION_FAILED_ERROR_CODE);
        }
      } else {
        //already payed
        throw Errors.getFunctionalExceptionFromErrorCode(Errors.ALREADY_PAYED_BILL_ERROR_CODE);
      }
    } else {
      throw Errors.getFunctionalExceptionFromErrorCode(Errors.BILL_NOT_FOUND_ERROR_CODE);
    }
  }

  //
  private float getStayDurationInHours(LocalDateTime startDateTime, LocalDateTime endDateTime, boolean isProrated) {
    float durationInHours = ChronoUnit.HOURS.between(startDateTime, endDateTime);
    if (isProrated) {
      // the exact duration
      durationInHours += ChronoUnit.MINUTES.between(startDateTime, endDateTime) % 60 / 60F;
    } else {
      //add one full hour if a new hour is started
      durationInHours += (ChronoUnit.MINUTES.between(startDateTime, endDateTime) % 60 / 60F) > 0 ? 1 : 0;
    }
    return durationInHours;
  }


}
