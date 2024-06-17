package com.example.OrderGatewayApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@RestController
public class OrderGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderGatewayApplication.class, args);
	}

	@Autowired
	private ProductServiceClient productServiceClient;

	@Autowired
	private CustomerServiceClient customerServiceClient;

	@Autowired
	private OrderServiceClient orderServiceClient;

	@GetMapping("/order-details/{orderId}")
	public Map<String, Object> getOrderDetails(@PathVariable String orderId) {
		Map<String, Object> response = new HashMap<>();
		response.put("order", orderServiceClient.getOrder(orderId));
		response.put("customer", customerServiceClient.getCustomer(orderId));
		response.put("products", productServiceClient.getProducts(orderId));
		return response;
	}

}
