package com.parking.manager.web.beans;

import java.util.Date;

import com.parking.manager.dao.entity.TransactionStatus;

public class PaymentTransaction {
  private Long transactionNumber;
  private TransactionStatus status;
  private Date date;

  public Long getTransactionNumber() {
    return transactionNumber;
  }

  public void setTransactionNumber(Long transactionNumber) {
    this.transactionNumber = transactionNumber;
  }

  public TransactionStatus getStatus() {
    return status;
  }

  public void setStatus(TransactionStatus status) {
    this.status = status;
  }

  public Date getDate() {
    return date;
  }

  public void setDate(Date date) {
    this.date = date;
  }
}
