package com.parking.manager.web.beans;

import com.parking.manager.dao.entity.Bill;

/**
 * The type Release slot converter.
 */
public final class ReleaseSlotConverter {

  private ReleaseSlotConverter(){}

  /**
   * Convert bill entity to a release slot output object.
   *
   * @param bill the bill
   * @return the release slot output
   */
  public static ReleaseSlotOutput convert(Bill bill) {
    ReleaseSlotOutput releaseSlotOutput = new ReleaseSlotOutput();
    releaseSlotOutput.setAmount(bill.getAmount());
    releaseSlotOutput.setCurrencyCode(bill.getCurrencyCode());
    releaseSlotOutput.setCarPlateNumber(bill.getSlotAssignment().getCarPlateNumber());
    releaseSlotOutput.setProrated(bill.getFare().isProrated());
    releaseSlotOutput.setStartDateTime(bill.getSlotAssignment().getStartDateTime());
    releaseSlotOutput.setEndDateTime(bill.getSlotAssignment().getEndDateTime());
    releaseSlotOutput.setBillNumber(bill.getId());
    releaseSlotOutput.setSlotNumber(bill.getSlotAssignment().getSlot().getNumber());
    releaseSlotOutput.setPaymentStatus(bill.getPaymentStatus());
    return releaseSlotOutput;
  }
}
