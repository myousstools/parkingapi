package com.parking.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.manager.dao.entity.SlotAssignment;

/**
 * The interface Slot assignment dao.
 */
@Repository
public interface SlotAssignmentDAO extends JpaRepository<SlotAssignment,Long> {
  /**
   * Find first by car plate number and end date time is null slot assignment.
   *
   * @param carPlateNumber the car plate number
   * @return the slot assignment
   */
  SlotAssignment findFirstByCarPlateNumberAndEndDateTimeIsNull(String carPlateNumber);
}
