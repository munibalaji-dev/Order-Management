package com.munibalaji.OrderManagement.controllers;

import com.munibalaji.OrderManagement.dtos.OrderRequestDto;
import com.munibalaji.OrderManagement.dtos.OrderResponseDto;
import com.munibalaji.OrderManagement.models.OrderStatus;
import com.munibalaji.OrderManagement.models.Orders;
import com.munibalaji.OrderManagement.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }



    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@RequestBody OrderRequestDto orderRequestDto){
        return new ResponseEntity<>(orderService.createOrder(orderRequestDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long id){
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDto> updateOrderById(@PathVariable Long id, @RequestBody OrderRequestDto orderRequestDto){
        return new ResponseEntity<>(orderService.updateOrderById(id, orderRequestDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<OrderResponseDto> deleteOrderById(@PathVariable Long id){
        return new ResponseEntity<>(orderService.deleteOrderById(id), HttpStatus.OK);
    }

    @GetMapping("/status/{status}")
    public List<OrderResponseDto> getOrderByStatus(@PathVariable OrderStatus status){
        return orderService.getOrderByStatus(status);
    }

}
