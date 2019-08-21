package com.parking.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.manager.dao.entity.Bill;

/**
 * The interface Bill dao.
 */
@Repository
public interface BillDAO extends JpaRepository<Bill, Long> {
}
