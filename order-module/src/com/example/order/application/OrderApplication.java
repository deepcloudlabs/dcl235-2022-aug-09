package com.example.order.application;

import java.util.ServiceLoader;

import com.example.crm.service.CustomerService;
import com.example.order.dto.OrderRequest;
import com.example.order.service.business.StandardOrderService;
import com.example.product.service.ProductService;

public class OrderApplication {

	public static void main(String[] args) {
		var orderService = new StandardOrderService();
		var customerService = ServiceLoader.load(CustomerService.class)
				                           .findFirst().get();
		var productService = ServiceLoader.load(ProductService.class)
				                          .findFirst().get();
		System.out.println(customerService.getClass());
		System.out.println(productService.getClass());
		orderService.setCustomerService(customerService); 
		orderService.setProductService(productService); 
		var order = orderService.makeOrder(new OrderRequest("11111111110", 123L, 2));
		System.out.println("Order is created: %s".formatted(order));
	}

}
