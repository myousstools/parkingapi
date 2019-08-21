package com.parking.manager.web.controller;


import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.parking.manager.dao.entity.Slot;
import com.parking.manager.dao.entity.SlotAssignment;
import com.parking.manager.service.slot.ISlotAssignmentService;
import com.parking.manager.web.beans.AssignSlotInput;
import com.parking.manager.web.beans.SlotStatus;
import com.parking.manager.web.beans.SlotType;

@RunWith(SpringRunner.class)
@WebMvcTest(value = SlotControllerTest.class, secure = false)
public class SlotControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @MockBean
  ISlotAssignmentService assignmentService;

  @Before
  public void setUp() throws Exception {
    Mockito.when(assignmentService.assignCar(Mockito.any(AssignSlotInput.class))).thenReturn(createAssignment());
  }

  //TODO finalize
  @Test
  @Ignore
  public void test_payBill_OK() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/slot/assignSlot").contentType(MediaType.APPLICATION_JSON).content(
        "{{\"carPlateNumber\":\"AB-1234\",\"slotType\":\"ELECTRIC_20KW\"}}"))
        .andExpect(status().isOk());
  }

  @Test
  public void test_payBill_KO() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/slot/assignSlot").contentType(MediaType.APPLICATION_JSON).content(
        "{}"))
        .andExpect(status().is4xxClientError());
  }

  private SlotAssignment createAssignment() {
    SlotAssignment assignment = new SlotAssignment();
    assignment.setStartDateTime(new Date());
    assignment.setCarPlateNumber("ABC-AA");
    assignment.setId(10L);
    Slot slot = new Slot();
    slot.setType(SlotType.ELECTRIC_50KW);
    slot.setStatus(SlotStatus.UNAVAILABLE);
    slot.setNumber("A0001");
    assignment.setSlot(slot);
    return assignment;
  }

  //TODO add releaseSlot test cases
}