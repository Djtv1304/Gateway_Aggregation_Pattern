package com.example.OrderGatewayApplication;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "product-service", url = "http://localhost:8081")
public interface ProductServiceClient {
    @GetMapping("/products/{orderId}")
    List<String> getProducts(@PathVariable String orderId);
}

