package com.parking.manager.service.fare;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.manager.dao.entity.Fare;
import com.parking.manager.dao.entity.Slot;

/**
 * The type Fare engine service generates dynamically the the fare to apply
 * for a parking slot using the Drools rules
 */
@Service
public class FareEngineService implements IFareEngineService {
  /**
   * The Kie container.
   */
  @Autowired
  KieContainer kieContainer;

  public Fare makeFare(Slot parkingSlot) {
    Fare fare = new Fare();
    fare.setParkingSlot(parkingSlot);
    KieSession kieSession = kieContainer.newKieSession();
    kieSession.insert(fare);
    kieSession.fireAllRules(); // fire all rules defined into drools file (drl)
    kieSession.dispose();
    return fare;
  }
}
