package com.munibalaji.OrderManagement.services;

import com.munibalaji.OrderManagement.dtos.OrderRequestDto;
import com.munibalaji.OrderManagement.dtos.OrderResponseDto;
import com.munibalaji.OrderManagement.models.OrderStatus;
import com.munibalaji.OrderManagement.models.Orders;
import org.springframework.data.domain.Page;
import java.util.List;

public interface OrderService {

    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);

    OrderResponseDto getOrderById(Long id);

    Page<OrderResponseDto> getAllOrders(int page, int size, String sortBy, String direction);

    OrderResponseDto updateOrderById(Long id, OrderRequestDto orderRequestDto);

    OrderResponseDto deleteOrderById(Long id);

    List<OrderResponseDto> getOrderByStatus(OrderStatus status);

    Page<OrderResponseDto> filterOrders(Double minPrice, String name, OrderStatus status, int page, int size);
}
