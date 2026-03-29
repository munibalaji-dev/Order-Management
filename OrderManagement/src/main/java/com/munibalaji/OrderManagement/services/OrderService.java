package com.munibalaji.OrderManagement.services;

import com.munibalaji.OrderManagement.dtos.OrderRequestDto;
import com.munibalaji.OrderManagement.dtos.OrderResponseDto;
import com.munibalaji.OrderManagement.models.OrderStatus;
import org.springframework.data.domain.Page;
import java.util.List;

public interface OrderService {

    OrderResponseDto createOrder(OrderRequestDto orderRequestDto);


    OrderResponseDto getOrderById(Long id);


    List<OrderResponseDto> getAllOrders();


    OrderResponseDto updateOrderById(Long id, OrderRequestDto orderRequestDto);


    OrderResponseDto deleteOrderById(Long id);


    Page<OrderResponseDto> searchOrders(Double minPrice, String name, OrderStatus orderStatus, int page, int size, String sortBy, String direction);
}
