package com.munibalaji.OrderManagement.services;
import com.munibalaji.OrderManagement.client.CustomerClient;
import com.munibalaji.OrderManagement.client.ProductClient;
import com.munibalaji.OrderManagement.dtos.*;
import com.munibalaji.OrderManagement.repositories.specifications.OrderSpecification;
import com.munibalaji.OrderManagement.exceptions.ResourceNotFoundException;
import com.munibalaji.OrderManagement.mappers.OrdersMapper;
import com.munibalaji.OrderManagement.models.OrderStatus;
import com.munibalaji.OrderManagement.models.Order;
import com.munibalaji.OrderManagement.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService{


    private OrderRepository orderRepository;

    private final CustomerClient client;
    private final ProductClient productClient;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            CustomerClient client,
                            ProductClient productClient){
        this.orderRepository = orderRepository;
        this.client = client;
        this.productClient = productClient;
    }


    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {

        Order order = OrdersMapper.orderRequestDtoToEntity(orderRequestDto);
        Order saved = orderRepository.save(order);

        return OrdersMapper.entityToOrderResponseDto(saved);
    }





    @Override
    public OrderResponseDto getOrderById(Long id) {

        Order getOrderById = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not found with your id check it once and try again"));

        return OrdersMapper.entityToOrderResponseDto(getOrderById);
    }





    @Override
    public List<OrderResponseDto> getAllOrders() {

        List<Order> orders = orderRepository.findAll();

        return orders.stream()
                .map(OrdersMapper::entityToOrderResponseDto)
                .toList();
    }





    @Override
    public OrderResponseDto updateOrderById(Long id, OrderRequestDto orderRequestDto) {

        Order order = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id mismatch to update your order check it once and try again"));

//        order.setProductName(orderRequestDto.getProductName());
        order.setQuantity(orderRequestDto.getQuantity());
        order.setPrice(orderRequestDto.getPrice());
        order.setStatus(orderRequestDto.getStatus());

        Order updatedOrder = orderRepository.save(order);

        return OrdersMapper.entityToOrderResponseDto(updatedOrder);
    }





    @Override
    public OrderResponseDto deleteOrderById(Long id) {

        Order order = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id mismatch to delete your order check it once and try again"));
        orderRepository.delete(order);
        return null;
    }





    public Page<OrderResponseDto> searchOrders(Double minPrice, String name, OrderStatus orderStatus,
                                               int page, int size, String sortBy, String direction){


        Sort sort = direction.equalsIgnoreCase("asc") ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);

        Specification<Order> specification = (root, query, cb) -> cb.conjunction();

        if(minPrice != null){
            specification = specification.and(OrderSpecification.hasMinPrice(minPrice));
        }

//        if (name != null){
//            specification = specification.and(OrderSpecification.hasProductName(name));
//        }

        if (orderStatus != null){
            specification = specification.and(OrderSpecification.hasStatus(orderStatus));
        }

//        Specification<Order> specification = Specification.allOf(
//                 OrderSpecification.hasMinPrice(minPrice))
//                .and(OrderSpecification.hasStatus(orderStatus))
//                .and(OrderSpecification.hasProductName(name));
//
//
        return orderRepository.findAll(specification, pageable)
                .map(OrdersMapper::entityToOrderResponseDto);

    }





    public OrderDetailsDto getOrderDetails(Long orderId){

        Order order = orderRepository.findById(orderId).orElseThrow(()->new ResourceNotFoundException("Order not found"));

        CustomerResponseDto customerResponseDto = client.getCustomerById(order.getCustomerId());

        ProductResponseDto productResponseDto = productClient.getProductById(order.getProductId());

        return OrdersMapper.mapToOrderDetails(order, customerResponseDto, productResponseDto);

    }

}
