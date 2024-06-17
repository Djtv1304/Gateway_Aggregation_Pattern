package com.example.OrderGatewayApplication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "order-service", url = "http://localhost:8082")
public interface OrderServiceClient {
    @GetMapping("/orders/{orderId}")
    String getOrder(@PathVariable String orderId);
}

