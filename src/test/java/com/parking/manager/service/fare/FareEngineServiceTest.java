package com.parking.manager.service.fare;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.parking.manager.dao.entity.Fare;
import com.parking.manager.dao.entity.Slot;
import com.parking.manager.web.beans.SlotType;

@RunWith(SpringRunner.class)
public class FareEngineServiceTest {
  @Test
  public void test_makeFare() throws IOException {
    FareEngineService service = new FareEngineService();
    service.kieContainer = new DroolsConfig().kieContainer();
    Slot slot = new Slot();
    slot.setType(SlotType.SEDAN);
    Fare fare = service.makeFare(slot);
    assertEquals(0, fare.getFixedAmount(), 0);
    assertEquals(2.0, fare.getHourPrice(), 0);
    assertFalse(fare.isProrated());

    slot.setType(SlotType.ELECTRIC_20KW);
    fare = service.makeFare(slot);
    assertEquals(2.0, fare.getFixedAmount(), 0);
    assertEquals(5.0, fare.getHourPrice(), 0);
    assertTrue(fare.isProrated());

    slot.setType(SlotType.ELECTRIC_50KW);
    fare = service.makeFare(slot);
    assertEquals(2.0, fare.getFixedAmount(), 0);
    assertEquals(12.5, fare.getHourPrice(), 0);
    assertTrue(fare.isProrated());
  }
}