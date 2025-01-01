package com.phatse.order.repository;


import com.phatse.order.dao.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    // Additional query methods can be added here if needed


}
