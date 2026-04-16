package com.munibalaji.OrderManagement.client;


import com.munibalaji.OrderManagement.dtos.CustomerResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CustomerManagementProject", url = "http://localhost:3001")
public interface CustomerClient {

    @GetMapping("/api/v1/customers/{id}")
    CustomerResponseDto getCustomerById(@PathVariable("id") Long id);


}
