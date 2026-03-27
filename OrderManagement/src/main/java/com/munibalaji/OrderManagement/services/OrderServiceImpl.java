package com.munibalaji.OrderManagement.services;
import com.munibalaji.OrderManagement.OrderSpecification;
import com.munibalaji.OrderManagement.dtos.OrderRequestDto;
import com.munibalaji.OrderManagement.dtos.OrderResponseDto;
import com.munibalaji.OrderManagement.exceptions.ResourceNotFoundException;
import com.munibalaji.OrderManagement.mappers.OrdersMapper;
import com.munibalaji.OrderManagement.models.OrderStatus;
import com.munibalaji.OrderManagement.models.Orders;
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

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository){
        this.orderRepository = orderRepository;
    }


    @Override
    public OrderResponseDto createOrder(OrderRequestDto orderRequestDto) {

        Orders orders = OrdersMapper.orderRequestDtoToEntity(orderRequestDto);
        Orders saved = orderRepository.save(orders);

        return OrdersMapper.entityToOrderResponseDto(saved);
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {

        Orders getOrderById = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Order not found with your id check it once and try again"));

        return OrdersMapper.entityToOrderResponseDto(getOrderById);
    }

    @Override
    public Page<OrderResponseDto> getAllOrders(int page, int size, String sortBy, String direction) {

//        Sort sort = direction.equalsIgnoreCase("asc") ? // here i used the ternary operator condition ? value1 : value2;
//                                                                    // --if condition is true → use value1//else → use value2
//       Sort.by("price").descending().and(Sort.by("productName").ascending())
//        Sort.by(sortBy).ascending() :
//        Sort.by(sortBy).descending();

        Sort sort;

        if(direction.equalsIgnoreCase("asc")){
            sort = Sort.by(sortBy).ascending();
        }else{
            sort = Sort.by(sortBy).descending();
        }

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Orders> page1 = orderRepository.findAll(pageable);

        return page1.map(OrdersMapper::entityToOrderResponseDto);
    }

    @Override
    public OrderResponseDto updateOrderById(Long id, OrderRequestDto orderRequestDto) {

        Orders orders = orderRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Id mismatch to update your order check it once and try again"));

        orders.setProductName(orderRequestDto.getProductName());
        orders.setQuantity(orderRequestDto.getQuantity());
        orders.setPrice(orderRequestDto.getPrice());
        orders.setStatus(orderRequestDto.getStatus());

        Orders updatedOrder = orderRepository.save(orders);

        return OrdersMapper.entityToOrderResponseDto(updatedOrder);
    }

    @Override
    public OrderResponseDto deleteOrderById(Long id) {

        Orders orders = orderRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Id mismatch to delete your order check it once and try again"));
        orderRepository.delete(orders);
        return null;
    }

    @Override
    public List<OrderResponseDto> getOrderByStatus(OrderStatus status) {

        List<Orders> orders = orderRepository.findOrdersByStatus(status);

        return orders.stream()
                .map(OrdersMapper::entityToOrderResponseDto)
                .toList();
    }

    @Override
    public Page<OrderResponseDto> filterOrders(Double minPrice, String name, OrderStatus status, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        Specification<Orders> specification = Specification
                .allOf( OrderSpecification.hasMinPrice(minPrice),
                        OrderSpecification.hasStatus(status),
                        OrderSpecification.hasProductName(name));


        Page<Orders> page1 = orderRepository.findAll(specification, pageable);


        return page1.map(OrdersMapper::entityToOrderResponseDto);








//        Page<Orders> ordersPage;
//
//        if(minPrice != null){
//            ordersPage = orderRepository.findByPriceGreaterThan(minPrice, pageable);
//        }else if(name != null){
//            ordersPage = orderRepository.findByProductNameContaining(name, pageable);
//        } else if (status != null) {
//            ordersPage = orderRepository.findByStatus(status, pageable);
//        }else{
//            ordersPage = orderRepository.findAll(pageable);
//        }
//        return ordersPage.map(OrdersMapper :: entityToOrderResponseDto);
    }

}
