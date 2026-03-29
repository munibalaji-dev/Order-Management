package com.munibalaji.OrderManagement.dtos;

import com.munibalaji.OrderManagement.models.OrderStatus;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {

    @Schema(description = "Product Name")
    @NotBlank(message = "Product name should not be null")
    private String productName;

    @Schema(description = "How many quantities")
    @NotNull(message = "quantity must contain atleast one")
    private Integer quantity;

    @Schema(description = "Price of a product")
    @Positive(message = "price of an order must be in positive")
    private Double price;

    @Schema(description = "Tracking of order")
    private OrderStatus status;
}
