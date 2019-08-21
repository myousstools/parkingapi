package com.parking.manager.dao.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.parking.manager.web.beans.SlotType;

/**
 * The type Fare.
 */
@Entity
public class Fare {
  /**
   * The Id.
   */
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @ManyToOne
  private Slot parkingSlot;
  private float fixedAmount;
  private float hourPrice;
  private boolean prorated;

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
   * Gets parking slot.
   *
   * @return the parking slot
   */
  public Slot getParkingSlot() {
    return parkingSlot;
  }

  /**
   * Sets parking slot.
   *
   * @param parkingSlot the parking slot
   */
  public void setParkingSlot(Slot parkingSlot) {
    this.parkingSlot = parkingSlot;
  }

  /**
   * Gets fixed amount.
   *
   * @return the fixed amount
   */
  public float getFixedAmount() {
    return fixedAmount;
  }

  /**
   * Sets fixed amount.
   *
   * @param fixedAmount the fixed amount
   */
  public void setFixedAmount(float fixedAmount) {
    this.fixedAmount = fixedAmount;
  }

  /**
   * Gets hour price.
   *
   * @return the hour price
   */
  public float getHourPrice() {
    return hourPrice;
  }

  /**
   * Sets hour price.
   *
   * @param hourPrice the hour price
   */
  public void setHourPrice(float hourPrice) {
    this.hourPrice = hourPrice;
  }

  /**
   * Is prorated boolean.
   *
   * @return the boolean
   */
  public boolean isProrated() {
    return prorated;
  }

  /**
   * Sets prorated.
   *
   * @param prorated the prorated
   */
  public void setProrated(boolean prorated) {
    this.prorated = prorated;
  }
}
