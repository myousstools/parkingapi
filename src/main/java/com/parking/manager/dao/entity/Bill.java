package com.parking.manager.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * The type Bill.
 */
@Entity
public class Bill {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @OneToOne
  private SlotAssignment slotAssignment;
  private float amount;
  private String currencyCode;
  private Date creationDate;
  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus;
  @OneToOne
  private Fare fare;

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets slot assignment.
   *
   * @return the slot assignment
   */
  public SlotAssignment getSlotAssignment() {
    return slotAssignment;
  }

  /**
   * Sets slot assignment.
   *
   * @param slotAssignment the slot assignment
   */
  public void setSlotAssignment(SlotAssignment slotAssignment) {
    this.slotAssignment = slotAssignment;
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
   * Gets creation date.
   *
   * @return the creation date
   */
  public Date getCreationDate() {
    return creationDate;
  }

  /**
   * Sets creation date.
   *
   * @param creationDate the creation date
   */
  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
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

  /**
   * Gets fare.
   *
   * @return the fare
   */
  public Fare getFare() {
    return fare;
  }

  /**
   * Sets fare.
   *
   * @param fare the fare
   */
  public void setFare(Fare fare) {
    this.fare = fare;
  }
}
