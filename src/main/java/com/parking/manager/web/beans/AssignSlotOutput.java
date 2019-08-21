package com.parking.manager.web.beans;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * The type Assign slot output.
 */

@ApiModel(description = "Parking assignment response")
public class AssignSlotOutput extends AbstractResponse {
  @ApiModelProperty(notes = "The parking slot assignment")
  private ParkingSoltAssignment parkingSoltAssignment;

  /**
   * Gets parking solt assignment.
   *
   * @return the parking solt assignment
   */
  public ParkingSoltAssignment getParkingSoltAssignment() {
    return parkingSoltAssignment;
  }

  /**
   * Sets parking solt assignment.
   *
   * @param parkingSoltAssignment the parking solt assignment
   */
  public void setParkingSoltAssignment(ParkingSoltAssignment parkingSoltAssignment) {
    this.parkingSoltAssignment = parkingSoltAssignment;
  }
}
