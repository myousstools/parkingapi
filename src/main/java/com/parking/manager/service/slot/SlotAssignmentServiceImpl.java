package com.parking.manager.service.slot;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.manager.dao.entity.Bill;
import com.parking.manager.dao.entity.Slot;
import com.parking.manager.dao.entity.SlotAssignment;
import com.parking.manager.dao.SlotAssignmentDAO;
import com.parking.manager.dao.SlotDAO;

import com.parking.manager.service.exception.ParkingFunctionalException;
import com.parking.manager.web.beans.SlotStatus;
import com.parking.manager.web.beans.AssignSlotInput;
import com.parking.manager.web.controller.Errors;
import com.parking.manager.web.beans.ReleaseSlotInput;

/**
 * The type Slot assignment service.
 */
@Service
@Transactional
public class SlotAssignmentServiceImpl implements ISlotAssignmentService {
  /**
   * The Slot assignment dao.
   */
  @Autowired
  SlotAssignmentDAO slotAssignmentDAO;
  /**
   * The Slot dao.
   */
  @Autowired
  SlotDAO slotDAO;

  /**
   * The Billing service.
   */
  @Autowired
  IBillingService billingService;

  @Override
  public SlotAssignment assignCar(AssignSlotInput input) throws ParkingFunctionalException {
    //get active assignment if any
    SlotAssignment activeSlotAssignment = slotAssignmentDAO.findFirstByCarPlateNumberAndEndDateTimeIsNull(
        input.getCarPlateNumber());
    if (activeSlotAssignment != null) {
      //We have already an active assignment for this car plate number
      return activeSlotAssignment;
    }
    //get first available slot
    Slot slot = slotDAO.findFirstByTypeEqualsAndStatusEquals(input.getSlotType(), SlotStatus.AVAILABLE);
    if (slot != null) {
      //mark the slot as UNAVAILABLE
      slot.setStatus(SlotStatus.UNAVAILABLE);
      SlotAssignment assignment = new SlotAssignment();
      assignment.setSlot(slot);
      assignment.setStartDateTime(new Date());
      assignment.setCarPlateNumber(input.getCarPlateNumber());
      return slotAssignmentDAO.saveAndFlush(assignment);
    }
    throw new ParkingFunctionalException(Errors.getMessageForCode(Errors.NO_MORE_AVAILABLE_SLOT_ERROR_CODE),
        Errors.NO_MORE_AVAILABLE_SLOT_ERROR_CODE);
  }

  @Override
  public Bill releaseSlot(ReleaseSlotInput input) throws ParkingFunctionalException {
    //get active assignment
    SlotAssignment activeSlotAssignment = slotAssignmentDAO.findFirstByCarPlateNumberAndEndDateTimeIsNull(
        input.getCarPlateNumber());
    if (activeSlotAssignment == null) {
      //No active slot for the given car plateNumber
      throw new ParkingFunctionalException(
          Errors.getMessageForCode(Errors.NO_ACTIVE_ASSIGNMENT_FOR_THIS_CAR_ERROR_CODE),
          Errors.NO_ACTIVE_ASSIGNMENT_FOR_THIS_CAR_ERROR_CODE);
    }
    activeSlotAssignment.setEndDateTime(new Date());
    //mark the slot as AVAILABLE again
    activeSlotAssignment.getSlot().setStatus(SlotStatus.AVAILABLE);
    //create the billing information.
    return billingService.createBill(activeSlotAssignment);
  }
}
