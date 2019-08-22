package com.parking.manager.web.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.manager.dao.entity.Bill;
import com.parking.manager.dao.entity.SlotAssignment;
import com.parking.manager.service.exception.ParkingFunctionalException;
import com.parking.manager.service.slot.ISlotAssignmentService;
import com.parking.manager.web.beans.AssignSlotInput;
import com.parking.manager.web.beans.AssignSlotOutput;
import com.parking.manager.web.beans.ParkingSoltAssignment;
import com.parking.manager.web.beans.ReleaseSlotConverter;
import com.parking.manager.web.beans.ReleaseSlotInput;
import com.parking.manager.web.beans.ReleaseSlotOutput;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * The type Slot controller.
 */
@RestController
@RequestMapping(value = "/slot", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces =
    { MediaType.APPLICATION_JSON_VALUE })
@Api(value = "Parking manager REST API", produces = MediaType.APPLICATION_JSON_VALUE)
public class SlotController {
  /**
   * The Assign ment service.
   */
  @Autowired
  ISlotAssignmentService assignmentService;


  /**
   * Assign slot assign slot output.
   *
   * @param input the input
   * @return the assign slot output
   * @throws ParkingFunctionalException the parking functional exception
   */
  @PostMapping("/assignSlot")
  @ApiOperation(value = "Assign a parking slot", response = AssignSlotOutput.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully assigned"),
      @ApiResponse(code = 400, message = "Bad request")
  })
  AssignSlotOutput assignSlot(@RequestBody @Valid AssignSlotInput input) throws ParkingFunctionalException {
    SlotAssignment assignmentSlot = assignmentService.assignCar(input);
    ModelMapper modelMapper = new ModelMapper();
    ParkingSoltAssignment slotAssignment = modelMapper.map(assignmentSlot, ParkingSoltAssignment.class);
    AssignSlotOutput output = new AssignSlotOutput();
    output.setSuccess(true);
    output.setParkingSoltAssignment(slotAssignment);
    return output;
  }

  /**
   * Release slot release slot output.
   *
   * @param input the input
   * @return the release slot output
   * @throws ParkingFunctionalException the parking functional exception
   */
  @PostMapping("/releaseSlot")
  @ApiOperation(value = "Release a parking slot", response = ReleaseSlotOutput.class)
  @ApiResponses(value = {
      @ApiResponse(code = 200, message = "Successfully released"),
      @ApiResponse(code = 400, message = "Bad request")
  })
  ReleaseSlotOutput releaseSlot(@RequestBody @Valid ReleaseSlotInput input) throws ParkingFunctionalException {
    Bill bill = assignmentService.releaseSlot(input);
    ReleaseSlotOutput releaseSlotOutput = ReleaseSlotConverter.convert(bill);
    releaseSlotOutput.setSuccess(true);
    return releaseSlotOutput;
  }

}