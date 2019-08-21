package com.parking.manager.dao;


import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class SlotAssignmentDAOTest {
  @Autowired
  SlotAssignmentDAO slotAssignmentDAO;
  @Test
  public void test_findFirstByCarPlateNumberAndEndDateTimeIsNull()
  {
//slotAssignmentDAO.findFirstByCarPlateNumberAndEndDateTimeIsNull();
//TODO
  }

}