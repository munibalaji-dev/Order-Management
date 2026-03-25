package com.munibalaji.OrderManagement.repositories;

import com.munibalaji.OrderManagement.models.OrderStatus;
import com.munibalaji.OrderManagement.models.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {

    List<Orders> findOrdersByStatus(OrderStatus status);
}
