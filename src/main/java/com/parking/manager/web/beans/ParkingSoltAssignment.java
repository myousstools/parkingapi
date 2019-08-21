package com.parking.manager.web.beans;


import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The type Parking solt assignment.
 */
@ApiModel(description = "Parking assignment")
public class ParkingSoltAssignment {
  @ApiModelProperty(notes = "The parking assignment id", example = "123", required = true)
  private Long id;
  @ApiModelProperty(notes = "The assigned slot", required = true)
  private ParkingSlot slot;
  @ApiModelProperty(notes = "The car plate number",example = "AA-333-BB", required = true)
  private String carPlateNumber;
  @ApiModelProperty(notes = "The assignment start timestamp",example = "1566321684182", required = true)
  private Date startDateTime;
  @ApiModelProperty(notes = "The assignment end timestamp, null if not yet released",example = "1566321684182", required = false)
  private Date endDateTime;

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
  public ParkingSlot getSlot() {
    return slot;
  }

  /**
   * Sets slot.
   *
   * @param slot the slot
   */
  public void setSlot(ParkingSlot slot) {
    this.slot = slot;
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
}
