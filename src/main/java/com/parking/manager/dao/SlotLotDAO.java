package com.parking.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.manager.dao.entity.SlotLot;

/**
 * The interface Slot lot dao.
 */
@Repository
public interface SlotLotDAO extends JpaRepository<SlotLot,Long> {
}
