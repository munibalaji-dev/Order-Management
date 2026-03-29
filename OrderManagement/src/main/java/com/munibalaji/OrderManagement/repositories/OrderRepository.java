package com.munibalaji.OrderManagement.repositories;

import com.munibalaji.OrderManagement.models.Orders;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>, JpaSpecificationExecutor<Orders> {


//    Page<Orders> findByPriceGreaterThan(Double price, Pageable pageable);
//
//    Page<Orders> findByStatus(OrderStatus status, Pageable pageable);
//
//    Page<Orders> findByProductNameContaining(String name, Pageable pageable);
}
