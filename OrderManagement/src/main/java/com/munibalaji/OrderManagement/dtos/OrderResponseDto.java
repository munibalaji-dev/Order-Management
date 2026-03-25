package com.munibalaji.OrderManagement.dtos;

import com.munibalaji.OrderManagement.models.OrderStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {

    private Long id;
    private String productName;
    private Integer quantity;
    private Double price;
    private OrderStatus status;
}
