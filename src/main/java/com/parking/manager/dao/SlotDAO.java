package com.parking.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.manager.dao.entity.Slot;
import com.parking.manager.web.beans.SlotStatus;
import com.parking.manager.web.beans.SlotType;

/**
 * The interface Slot dao.
 */
@Repository
public interface SlotDAO extends JpaRepository<Slot,Long> {
  /**
   * Find first by type equals and status equals slot.
   *
   * @param type   the type
   * @param status the status
   * @return the slot
   */
  Slot findFirstByTypeEqualsAndStatusEquals(SlotType type, SlotStatus status);

}
