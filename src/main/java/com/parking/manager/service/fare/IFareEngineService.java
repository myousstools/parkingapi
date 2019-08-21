package com.parking.manager.service.fare;

import com.parking.manager.dao.entity.Fare;
import com.parking.manager.dao.entity.Slot;
/**
 * The interface Fare engine service.
 */
public interface IFareEngineService {
  /**
   * Make fare fare.
   *
   * @param parkingSlot the parking slot
   * @return the fare
   */
  Fare makeFare(Slot parkingSlot);
}
