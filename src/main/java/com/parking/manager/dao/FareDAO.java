package com.parking.manager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.manager.dao.entity.Fare;

/**
 * The interface Fare dao.
 */
@Repository
public interface FareDAO extends JpaRepository<Fare, Long> {
}
