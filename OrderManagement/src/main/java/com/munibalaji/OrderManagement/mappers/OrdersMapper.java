package com.munibalaji.OrderManagement.mappers;

import com.munibalaji.OrderManagement.dtos.*;
import com.munibalaji.OrderManagement.models.Order;

public class OrdersMapper {

    public static Order orderRequestDtoToEntity(OrderRequestDto orderRequestDto){

        if(orderRequestDto == null){
            return null;
        }

        Order order = new Order();
//        order.setProductName(orderRequestDto.getProductName());
        order.setQuantity(orderRequestDto.getQuantity());
        order.setPrice(orderRequestDto.getPrice());
        order.setStatus(orderRequestDto.getStatus());

        return order;
    }

    public static OrderResponseDto entityToOrderResponseDto(Order order){
        if(order == null){
            return null;
        }

        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
//        orderResponseDto.setProductName(order.getProductName());
        orderResponseDto.setQuantity(order.getQuantity());
        orderResponseDto.setPrice(order.getPrice());
        orderResponseDto.setStatus(order.getStatus());

        return orderResponseDto;

    }

    public static OrderDetailsDto mapToOrderDetails(Order order,
                                                    CustomerResponseDto customerResponseDto,
                                                    ProductResponseDto productResponseDto){

        if (order == null){
            return null;
        }

        OrderDetailsDto orderDetailsDto = new OrderDetailsDto();

        orderDetailsDto.setId(order.getId());
        orderDetailsDto.setCustomer(customerResponseDto);
        orderDetailsDto.setProduct(productResponseDto);
        orderDetailsDto.setQuantity(order.getQuantity());
        orderDetailsDto.setPrice(order.getPrice());
        orderDetailsDto.setOrderStatus(order.getStatus());

        return orderDetailsDto;
    }
}
