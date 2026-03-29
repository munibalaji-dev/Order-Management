package com.munibalaji.OrderManagement.repositories.specifications;

import com.munibalaji.OrderManagement.models.OrderStatus;
import com.munibalaji.OrderManagement.models.Orders;
import org.springframework.data.jpa.domain.Specification;

public class OrderSpecification {

    public static Specification<Orders> hasMinPrice(Double price){
        return ((root, query, criteriaBuilder) ->
                price == null ? null : criteriaBuilder.greaterThan(root.get("price"), price));
    }

    public static Specification<Orders> hasStatus(OrderStatus status){
        return ((root, query, criteriaBuilder) ->
                status == null ? null : criteriaBuilder.equal(root.get("status"), status));
    }

    public static Specification<Orders> hasProductName(String name) {
//        return ((root, query, criteriaBuilder) ->
//                name == null ? null : criteriaBuilder.like(root.get("productName"), "%" + name.toLowerCase()+ "%"));

        return (root, query, criteriaBuilder) -> {
            if (name == null || name.trim().isEmpty()) return null;

            return criteriaBuilder.like(
                    criteriaBuilder.lower(root.get("productName")),
                    "%" + name.toLowerCase() + "%"
            );

        };
    }
}
