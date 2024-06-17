package com.example.OrderGatewayApplication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service", url = "http://localhost:8083")
public interface CustomerServiceClient {
    @GetMapping("/customers/{orderId}")
    String getCustomer(@PathVariable String orderId);
}

