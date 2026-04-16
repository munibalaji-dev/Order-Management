package com.munibalaji.OrderManagement.repositories;

import com.munibalaji.OrderManagement.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>, JpaSpecificationExecutor<Order> {


//    Page<Order> findByPriceGreaterThan(Double price, Pageable pageable);
//
//    Page<Order> findByStatus(OrderStatus status, Pageable pageable);
//
//    Page<Order> findByProductNameContaining(String name, Pageable pageable);
}
