package com.parking.manager.web.beans;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.parking.manager.web.beans.validation.ValidCarPlateNumber;
import com.parking.manager.web.controller.Errors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The type Assign slot input.
 */
@ApiModel(description = "Parking assignment request input")
public class AssignSlotInput {
  @NotEmpty(message = Errors.MISSING_PLATENUMBER_ERROR_CODE)
  @ValidCarPlateNumber(message = Errors.INVALID_PLATENUMBER_ERROR_CODE)
  @ApiModelProperty(notes = "The car plate number", example = "AA-123-BB", required = true)
  private String carPlateNumber;
  @ApiModelProperty(notes = "The car type", allowableValues = "SEDAN, ELECTRIC_20KW, ELECTRIC_50KW", required = true)
  @NotNull(message = Errors.MISSING_SLOT_TYPE_ERROR_CODE)
  private SlotType slotType;

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
   * Gets slot type.
   *
   * @return the slot type
   */
  public SlotType getSlotType() {
    return slotType;
  }

  /**
   * Sets slot type.
   *
   * @param slotType the slot type
   */
  public void setSlotType(SlotType slotType) {
    this.slotType = slotType;
  }
}
