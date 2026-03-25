package com.munibalaji.OrderManagement.mappers;

import com.munibalaji.OrderManagement.dtos.OrderRequestDto;
import com.munibalaji.OrderManagement.dtos.OrderResponseDto;
import com.munibalaji.OrderManagement.models.Orders;

public class OrdersMapper {

    public static Orders orderRequestDtoToEntity(OrderRequestDto orderRequestDto){

        if(orderRequestDto == null){
            return null;
        }

        Orders orders = new Orders();
        orders.setProductName(orderRequestDto.getProductName());
        orders.setQuantity(orderRequestDto.getQuantity());
        orders.setPrice(orderRequestDto.getPrice());
        orders.setStatus(orderRequestDto.getStatus());

        return orders;
    }

    public static OrderResponseDto entityToOrderResponseDto(Orders orders){
        if(orders == null){
            return null;
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(orders.getId());
        orderResponseDto.setProductName(orders.getProductName());
        orderResponseDto.setQuantity(orders.getQuantity());
        orderResponseDto.setPrice(orders.getPrice());
        orderResponseDto.setStatus(orders.getStatus());

        return orderResponseDto;

    }
}
