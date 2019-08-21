package com.parking.manager.dao;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import com.parking.manager.dao.entity.PaymentTransaction;

/**
 * The interface Payment transation dao.
 */
@Repository
public interface PaymentTransationDAO extends JpaRepository<PaymentTransaction, Long> {
}
