package com.munibalaji.OrderManagement.dtos;

import com.munibalaji.OrderManagement.models.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDetailsDto {

    private Long id;
    private CustomerResponseDto customer;
    private ProductResponseDto product;
    private Integer quantity;
    private Double price;
    private OrderStatus orderStatus;

}
