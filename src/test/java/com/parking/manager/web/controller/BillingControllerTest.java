package com.parking.manager.web.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Before;
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

import com.parking.manager.dao.entity.Bill;
import com.parking.manager.dao.entity.Fare;
import com.parking.manager.dao.entity.PaymentStatus;
import com.parking.manager.dao.entity.PaymentTransaction;
import com.parking.manager.dao.entity.TransactionStatus;
import com.parking.manager.service.exception.ParkingFunctionalException;
import com.parking.manager.service.slot.IBillingService;

import com.parking.manager.web.beans.PaymentInput;

@RunWith(SpringRunner.class)
@WebMvcTest(value = BillingController.class, secure = false)
public class BillingControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @MockBean
  IBillingService billingService;

  @Before
  public void setup() throws ParkingFunctionalException {
    Mockito.when(billingService.payBill(Mockito.any(PaymentInput.class))).thenReturn(createTransation());
  }

  private PaymentTransaction createTransation() {
    PaymentTransaction tr = new PaymentTransaction();
    tr.setStatus(TransactionStatus.SUCCESS);
    tr.setNumber(123L);
    tr.setDate(new Date());
    return tr;
  }

  @Test
  public void test_payBill_OK() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/billing/pay").contentType(MediaType.APPLICATION_JSON).content(
        "{\"billId\":3,\"creditCard\":{\"number\":\"1111111111111111\",\"ccv\":\"123\", \"expirationDate\":\"01/21\","
            + "\"ownerName\":\"John\"}}"))
        .andExpect(status().isOk());
  }

  @Test
  public void test_payBill_KO() throws Exception {
    mockMvc.perform(MockMvcRequestBuilders.post("/billing/pay").contentType(MediaType.APPLICATION_JSON).content(
        "{}"))
        .andExpect(status().is4xxClientError());
  }

  private Bill createBill() {
    Bill bill = new Bill();
    bill.setPaymentStatus(PaymentStatus.PENDING);
    bill.setCurrencyCode("EUR");
    bill.setCreationDate(new Date());
    Fare fare = new Fare();
    fare.setFixedAmount(2.0F);
    fare.setHourPrice(12.0F);
    fare.setId(1L);
    fare.setProrated(true);
    bill.setFare(fare);
    return bill;
  }


}