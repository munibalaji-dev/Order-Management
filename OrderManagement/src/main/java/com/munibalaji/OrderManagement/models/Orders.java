package com.munibalaji.OrderManagement.models;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Orders extends BaseModel{

    private String productName;
    private Integer quantity;
    private Double price;
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
}
