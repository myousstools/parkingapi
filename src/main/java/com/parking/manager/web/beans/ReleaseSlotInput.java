package com.parking.manager.web.beans;

import javax.validation.constraints.NotNull;

import com.parking.manager.web.beans.validation.ValidCarPlateNumber;
import com.parking.manager.web.controller.Errors;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Parking release slot request input")
public class ReleaseSlotInput {

  @NotNull(message = Errors.MISSING_PLATENUMBER_ERROR_CODE)
  @ValidCarPlateNumber(message = Errors.INVALID_PLATENUMBER_ERROR_CODE)
  @ApiModelProperty(notes = "The car plate number", example = "AA-123-BB", required = true)
  private String carPlateNumber;

  public String getCarPlateNumber() {
    return carPlateNumber;
  }

  public void setCarPlateNumber(String carPlateNumber) {
    this.carPlateNumber = carPlateNumber;
  }
}
