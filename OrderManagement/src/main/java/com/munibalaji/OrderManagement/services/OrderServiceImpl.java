package com.munibalaji.OrderManagement.services;

import com.munibalaji.OrderManagement.dtos.OrderRequestDto;
import com.munibalaji.OrderManagement.dtos.OrderResponseDto;
import com.munibalaji.OrderManagement.exceptions.ResourceNotFoundException;
import com.munibalaji.OrderManagement.mappers.OrdersMapper;
import com.munibalaji.OrderManagement.models.OrderStatus;
import com.munibalaji.OrderManagement.models.Orders;
import com.munibalaji.OrderManagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{


    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {

        Orders orders = OrdersMapper.orderRequestDtoToEntity(orderRequestDto);
        Orders saved = orderRepository.save(orders);

        return OrdersMapper.entityToOrderResponseDto(saved);
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {

        Orders getOrderById = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not found with your id check it once and try again"));

        return OrdersMapper.entityToOrderResponseDto(getOrderById);
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {

        List<Orders> getAllOrders = orderRepository.findAll();

        return getAllOrders.stream()
                .map(OrdersMapper :: entityToOrderResponseDto)
                .toList();
    }

    @Override
    public OrderResponseDto updateOrderById(Long id, OrderRequestDto orderRequestDto) {

        Orders orders = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id mismatch to update your order check it once and try again"));

        orders.setProductName(orderRequestDto.getProductName());
        orders.setQuantity(orderRequestDto.getQuantity());
        orders.setPrice(orderRequestDto.getPrice());
        orders.setStatus(orderRequestDto.getStatus());

        Orders updatedOrder = orderRepository.save(orders);

        return OrdersMapper.entityToOrderResponseDto(updatedOrder);
    }

    @Override
    public OrderResponseDto deleteOrderById(Long id) {

        Orders orders = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id mismatch to delete your order check it once and try again"));
        orderRepository.delete(orders);
        return null;
    }

    @Override
    public List<OrderResponseDto> getOrderByStatus(OrderStatus status) {

        List<Orders> orders = orderRepository.findOrdersByStatus(status);

        return orders.stream()
                .map(OrdersMapper::entityToOrderResponseDto)
                .toList();
    }

}
