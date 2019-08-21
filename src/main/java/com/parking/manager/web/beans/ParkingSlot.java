package com.parking.manager.web.beans;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The type Parking slot.
 */
@ApiModel(description = "The parking slot object")
public class ParkingSlot {
  @ApiModelProperty(notes = "The parking slot id", required = true)
  private Long id;
  @ApiModelProperty(notes = "The slot number", example = "A001", required = true)
  private String number;
  @ApiModelProperty(notes = "The slot type", example = "SEDAN", required = true)
  private SlotType type;

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
   * Gets number.
   *
   * @return the number
   */
  public String getNumber() {
    return number;
  }

  /**
   * Sets number.
   *
   * @param number the number
   */
  public void setNumber(String number) {
    this.number = number;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public SlotType getType() {
    return type;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(SlotType type) {
    this.type = type;
  }

}
