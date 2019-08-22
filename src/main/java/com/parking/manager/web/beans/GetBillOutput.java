package com.parking.manager.web.beans;

import io.swagger.annotations.ApiModel;
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
