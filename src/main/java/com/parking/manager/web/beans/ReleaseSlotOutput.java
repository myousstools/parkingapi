package com.parking.manager.web.beans;

import java.util.Date;

import com.parking.manager.dao.entity.PaymentStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The type Release slot output.
 */
@ApiModel(description = "defines the release slot output data model")
public class ReleaseSlotOutput extends AbstractResponse {
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

  /**
   * Gets slot number.
   *
   * @return the slot number
   */
  public String getSlotNumber() {
    return slotNumber;
  }

  /**
   * Sets slot number.
   *
   * @param slotNumber the slot number
   */
  public void setSlotNumber(String slotNumber) {
    this.slotNumber = slotNumber;
  }

  /**
   * Gets start date time.
   *
   * @return the start date time
   */
  public Date getStartDateTime() {
    return startDateTime;
  }

  /**
   * Sets start date time.
   *
   * @param startDateTime the start date time
   */
  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  /**
   * Gets end date time.
   *
   * @return the end date time
   */
  public Date getEndDateTime() {
    return endDateTime;
  }

  /**
   * Sets end date time.
   *
   * @param endDateTime the end date time
   */
  public void setEndDateTime(Date endDateTime) {
    this.endDateTime = endDateTime;
  }

  /**
   * Gets amount.
   *
   * @return the amount
   */
  public float getAmount() {
    return amount;
  }

  /**
   * Sets amount.
   *
   * @param amount the amount
   */
  public void setAmount(float amount) {
    this.amount = amount;
  }

  /**
   * Gets currency code.
   *
   * @return the currency code
   */
  public String getCurrencyCode() {
    return currencyCode;
  }

  /**
   * Sets currency code.
   *
   * @param currencyCode the currency code
   */
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }

  /**
   * Is prorated boolean.
   *
   * @return the boolean
   */
  public boolean isProrated() {
    return isProrated;
  }

  /**
   * Sets prorated.
   *
   * @param prorated the prorated
   */
  public void setProrated(boolean prorated) {
    isProrated = prorated;
  }

  /**
   * Gets bill number.
   *
   * @return the bill number
   */
  public long getBillNumber() {
    return billNumber;
  }

  /**
   * Sets bill number.
   *
   * @param billNumber the bill number
   */
  public void setBillNumber(long billNumber) {
    this.billNumber = billNumber;
  }

  /**
   * Gets car plate number.
   *
   * @return the car plate number
   */
  public String getCarPlateNumber() {
    return carPlateNumber;
  }

  /**
   * Sets car plate number.
   *
   * @param carPlateNumber the car plate number
   */
  public void setCarPlateNumber(String carPlateNumber) {
    this.carPlateNumber = carPlateNumber;
  }

  /**
   * Gets payment status.
   *
   * @return the payment status
   */
  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  /**
   * Sets payment status.
   *
   * @param paymentStatus the payment status
   */
  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }
}
