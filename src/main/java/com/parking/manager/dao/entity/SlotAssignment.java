package com.parking.manager.dao.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * The type Slot assignment.
 */
@Entity
public class SlotAssignment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String carPlateNumber;
  private Date startDateTime;
  private Date endDateTime;
  @OneToOne
  private Slot slot;

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
   * Gets slot.
   *
   * @return the slot
   */
  public Slot getSlot() {
    return slot;
  }

  /**
   * Sets slot.
   *
   * @param slot the slot
   */
  public void setSlot(Slot slot) {
    this.slot = slot;
  }
}
