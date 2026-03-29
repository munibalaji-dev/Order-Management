package com.munibalaji.OrderManagement.models;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Orders extends BaseModel{


    @NotBlank(message = "product name cannot be null")
    private String productName;

    @NotNull(message = "must be choose atleast one quantity")
    private Integer quantity;

    @Positive
    private Double price;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
