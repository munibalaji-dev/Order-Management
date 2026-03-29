package com.munibalaji.OrderManagement.controllers;

import com.munibalaji.OrderManagement.dtos.OrderRequestDto;
import com.munibalaji.OrderManagement.dtos.OrderResponseDto;
import com.munibalaji.OrderManagement.models.OrderStatus;
import com.munibalaji.OrderManagement.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Order Management", description = "Operations related to orders")
@RequestMapping("/api/v1/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }



    @Operation(summary = "To create an order")
    @PostMapping
    public ResponseEntity<OrderResponseDto> createOrder(@Valid @RequestBody OrderRequestDto orderRequestDto){
        return new ResponseEntity<>(orderService.createOrder(orderRequestDto), HttpStatus.CREATED);
    }



    @Operation(summary = "Enter order id to get the order")
    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDto> getOrderById(@PathVariable Long id){
        return new ResponseEntity<>(orderService.getOrderById(id), HttpStatus.OK);
    }




    @Operation(summary = "To get all the orders")
    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAllOrders() {

        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }


    @Operation(summary = "Enter order id to update your order")
    @PutMapping("/{id}")
    public ResponseEntity<OrderResponseDto> updateOrderById(@PathVariable Long id, @RequestBody OrderRequestDto orderRequestDto){
        return new ResponseEntity<>(orderService.updateOrderById(id, orderRequestDto), HttpStatus.OK);
    }




    @Operation(summary = "Enter order id to delete your order")
    @DeleteMapping("/{id}")
    public ResponseEntity<OrderResponseDto> deleteOrderById(@PathVariable Long id){
        return new ResponseEntity<>(orderService.deleteOrderById(id), HttpStatus.OK);
    }


    @GetMapping("/search")
    public ResponseEntity<Page<OrderResponseDto>> search(
            @RequestParam(required = false) Double minPrice,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) OrderStatus orderStatus,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {


        return ResponseEntity.ok(
                orderService.searchOrders(minPrice, name, orderStatus, page, size, sortBy, direction)
        );
    }

}
