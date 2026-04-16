package com.munibalaji.OrderManagement.client;

import com.munibalaji.OrderManagement.dtos.ProductResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ProductManagement", url = "http://localhost:3002")
public interface ProductClient {

    @GetMapping("/api/v2/products/{id}")
    ProductResponseDto getProductById(@PathVariable("id") Long id);
}
