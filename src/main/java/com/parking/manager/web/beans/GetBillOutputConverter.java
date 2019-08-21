package com.parking.manager.web.beans;

import com.parking.manager.dao.entity.Bill;

/**
 * The type Get bill output converter.
 */
public class GetBillOutputConverter {
  /**
   * Convert get bill output.
   *
   * @param bill the bill
   * @return the get bill output
   */
  public static GetBillOutput convert(Bill bill) {
    GetBillOutput result = new GetBillOutput();
    result.setBill(new BillOutput());
    result.getBill().setAmount(bill.getAmount());
    result.getBill().setCurrencyCode(bill.getCurrencyCode());
    result.getBill().setCarPlateNumber(bill.getSlotAssignment().getCarPlateNumber());
    result.getBill().setProrated(bill.getFare().isProrated());
    result.getBill().setStartDateTime(bill.getSlotAssignment().getStartDateTime());
    result.getBill().setEndDateTime(bill.getSlotAssignment().getEndDateTime());
    result.getBill().setBillNumber(bill.getId());
    result.getBill().setSlotNumber(bill.getSlotAssignment().getSlot().getNumber());
    result.getBill().setPaymentStatus(bill.getPaymentStatus());
    return result;
  }
}
