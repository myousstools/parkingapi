package com.parking.manager.web.beans;

import java.util.Date;

import com.parking.manager.dao.entity.PaymentStatus;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel()
public class GetBillOutput extends AbstractResponse {
  private BillOutput bill;

  public BillOutput getBill() {
    return bill;
  }

  public void setBill(BillOutput bill) {
    this.bill = bill;
  }
}
