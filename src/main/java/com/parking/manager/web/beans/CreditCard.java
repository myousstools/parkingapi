package com.parking.manager.web.beans;

import javax.validation.constraints.NotNull;

import com.parking.manager.web.beans.validation.ValidCCV;
import com.parking.manager.web.beans.validation.ValidCreditCard;
import com.parking.manager.web.beans.validation.ValidExpirationDate;
import com.parking.manager.web.controller.Errors;

public class CreditCard {
  @ValidCreditCard(message = Errors.INVALID_CREDIT_CARD_ERROR_CODE)
  @NotNull(message = Errors.MISSING_CREDIT_CARD_ERROR_CODE)
  private String number;
  @ValidCCV(message = Errors.INVALID_CREDIT_CARD_CCV_ERROR_CODE)
  private String ccv;
  @ValidExpirationDate(message = Errors.INVALID_EXPIRATION_DATE_ERROR_CODE)
  private String expirationDate;
  @NotNull(message = Errors.MISSING_CREDIT_CARD_OWNER_ERROR_CODE)
  private String ownerName;

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getCcv() {
    return ccv;
  }

  public void setCcv(String ccv) {
    this.ccv = ccv;
  }

  public String getExpirationDate() {
    return expirationDate;
  }

  public void setExpirationDate(String expirationDate) {
    this.expirationDate = expirationDate;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }
}
