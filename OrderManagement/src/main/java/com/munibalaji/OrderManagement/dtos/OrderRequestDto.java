package com.munibalaji.OrderManagement.dtos;

import com.munibalaji.OrderManagement.models.OrderStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {

    @NotBlank(message = "Product name should not be null")
    private String productName;
    private Integer quantity;
    @Positive(message = "price of an order must be in positive")
    private Double price;
    private OrderStatus status;
}
