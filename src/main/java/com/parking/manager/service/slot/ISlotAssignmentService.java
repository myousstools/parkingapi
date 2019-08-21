package com.parking.manager.service.slot;


import com.parking.manager.dao.entity.Bill;
import com.parking.manager.dao.entity.SlotAssignment;
import com.parking.manager.service.exception.ParkingFunctionalException;
import com.parking.manager.web.beans.AssignSlotInput;
import com.parking.manager.web.beans.ReleaseSlotInput;

/**
 * The interface Slot assignment service.
 */
public interface ISlotAssignmentService {
  /**
   * Assign a slot for the given input.
   *
   * @param input the input
   * @return the slot assignment
   * @throws ParkingFunctionalException the parking functional exception
   */
  SlotAssignment assignCar(AssignSlotInput input) throws ParkingFunctionalException;

  /**
   * Release slot.
   *
   * @param input the input
   * @return the bill
   * @throws ParkingFunctionalException the parking functional exception
   */
  Bill releaseSlot(ReleaseSlotInput input) throws ParkingFunctionalException;
}
