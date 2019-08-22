package com.parking.manager.web.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.manager.dao.entity.Bill;
import com.parking.manager.dao.entity.PaymentTransaction;
import com.parking.manager.service.exception.ParkingFunctionalException;
import com.parking.manager.service.slot.IBillingService;
import com.parking.manager.web.beans.GetBillOutput;
import com.parking.manager.web.beans.GetBillOutputConverter;
import com.parking.manager.web.beans.PaymentInput;
import com.parking.manager.web.beans.PaymentOutput;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "/billing", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces =
    { MediaType.APPLICATION_JSON_VALUE })
@Api(value = "Billing REST API", produces = MediaType.APPLICATION_JSON_VALUE)
public class BillingController {
  @Autowired
  IBillingService billingService;

  @PostMapping(value = "/pay")
  public PaymentOutput submitPayment(@RequestBody @Valid PaymentInput paymentInput) throws ParkingFunctionalException {
    PaymentTransaction transaction = billingService.payBill(paymentInput);
    PaymentOutput paymentOutput = new PaymentOutput();
    ModelMapper modelMapper = new ModelMapper();
    com.parking.manager.web.beans.PaymentTransaction transactionBean = modelMapper.map(transaction,
        com.parking.manager.web.beans.PaymentTransaction.class);
    paymentOutput.setTransation(transactionBean);
    paymentOutput.setSuccess(true);
    return paymentOutput;
  }

  @GetMapping(value = "/bill/{id}")
  public GetBillOutput getBill(@PathVariable(value = "id") Long id) throws ParkingFunctionalException {
    Bill bill = billingService.getBill(id);
    GetBillOutput result = GetBillOutputConverter.convert(bill);
    result.setSuccess(true);
    return result;
  }
}
