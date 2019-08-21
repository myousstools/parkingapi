package com.parking.manager.web.beans;

import java.util.Date;

import com.parking.manager.dao.entity.PaymentStatus;

import io.swagger.annotations.ApiModelProperty;

public class BillOutput {
  @ApiModelProperty(notes = "The slot number", example = "A001")
  private String slotNumber;
  @ApiModelProperty(notes = "The assignment start timestamp", example = "1566321684182", required = true)
  private Date startDateTime;
  @ApiModelProperty(notes = "The assignment end timestamp, null if not yet released", example = "1566321684182",
      required = false)
  private Date endDateTime;
  @ApiModelProperty(notes = "The amount to pay", example = "5.2")
  private float amount;
  @ApiModelProperty(notes = "The currency code for the amount to pay", example = "EUR")
  private String currencyCode;
  @ApiModelProperty(notes = "Indicates if it is prorated amount of not", example = "false")
  private boolean isProrated;
  @ApiModelProperty(notes = "The bill numbr", example = "12321")
  private long billNumber;
  @ApiModelProperty(notes = "The car plate number", example = "AA-333-BB", required = true)
  private String carPlateNumber;
  @ApiModelProperty(notes = "The payment status", example = "PENDING", required = true)
  private PaymentStatus paymentStatus;

  public String getSlotNumber() {
    return slotNumber;
  }

  public void setSlotNumber(String slotNumber) {
    this.slotNumber = slotNumber;
  }

  public Date getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  public Date getEndDateTime() {
    return endDateTime;
  }

  public void setEndDateTime(Date endDateTime) {
    this.endDateTime = endDateTime;
  }

  public float getAmount() {
    return amount;
  }

  public void setAmount(float amount) {
    this.amount = amount;
  }

  public String getCurrencyCode() {
    return currencyCode;
  }

  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  public boolean isProrated() {
    return isProrated;
  }

  public void setProrated(boolean prorated) {
    isProrated = prorated;
  }

  public long getBillNumber() {
    return billNumber;
  }

  public void setBillNumber(long billNumber) {
    this.billNumber = billNumber;
  }

  public String getCarPlateNumber() {
    return carPlateNumber;
  }

  public void setCarPlateNumber(String carPlateNumber) {
    this.carPlateNumber = carPlateNumber;
  }

  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }
}
