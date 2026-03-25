package com.munibalaji.OrderManagement.services;

import com.munibalaji.OrderManagement.dtos.OrderRequestDto;
import com.munibalaji.OrderManagement.dtos.OrderResponseDto;
import com.munibalaji.OrderManagement.models.OrderStatus;
import com.munibalaji.OrderManagement.models.Orders;

import java.util.List;

public interface OrderService {

    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

    OrderResponseDto getOrderById(Long id);

    List<OrderResponseDto> getAllOrders();

    OrderResponseDto updateOrderById(Long id, OrderRequestDto orderRequestDto);

    OrderResponseDto deleteOrderById(Long id);

    List<OrderResponseDto> getOrderByStatus(OrderStatus status);
}
