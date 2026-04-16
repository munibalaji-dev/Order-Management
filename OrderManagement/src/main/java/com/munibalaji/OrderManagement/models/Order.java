package com.munibalaji.OrderManagement.models;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Orders")
public class Order extends BaseModel{


//    @NotBlank(message = "product name cannot be null")
//    private String productName;

    private Long productId;
    private Long customerId;

    @NotNull(message = "must be choose atleast one quantity to place an order")
    private Integer quantity;

    @Positive
    private Double price;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
