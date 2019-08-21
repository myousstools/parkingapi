package com.parking.manager.dao.entity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.parking.manager.web.beans.SlotStatus;
import com.parking.manager.web.beans.SlotType;

/**
 * The type Slot.
 */
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Slot {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  @Enumerated(EnumType.STRING)
  private SlotType type;
  private String number;
  @Enumerated(EnumType.STRING)
  private SlotStatus status;

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public SlotType getType() {
    return type;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(SlotType type) {
    this.type = type;
  }

  /**
   * Gets number.
   *
   * @return the number
   */
  public String getNumber() {
    return number;
  }

  /**
   * Sets number.
   *
   * @param number the number
   */
  public void setNumber(String number) {
    this.number = number;
  }

  /**
   * Gets status.
   *
   * @return the status
   */
  public SlotStatus getStatus() {
    return status;
  }

  /**
   * Sets status.
   *
   * @param status the status
   */
  public void setStatus(SlotStatus status) {
    this.status = status;
  }
}
