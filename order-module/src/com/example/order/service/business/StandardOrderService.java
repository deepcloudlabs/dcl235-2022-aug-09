package com.example.order.service.business;

import java.util.UUID;

import com.example.crm.service.CustomerService;
import com.example.order.domain.Order;
import com.example.order.dto.OrderRequest;
import com.example.order.service.OrderService;
import com.example.product.service.ProductService;

public class StandardOrderService implements OrderService {

	private CustomerService customerService;
	private ProductService productService;

	public void setCustomerService(CustomerService customerService) {
		this.customerService = customerService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	@Override
	public Order makeOrder(OrderRequest request) {
		var identity = request.identity();
		long productId = request.productId();
		var customer = customerService.getCustomerByIdentity(identity )
				                      .orElseThrow( () -> new IllegalArgumentException("Cannot find customer."));
		var product = productService.findProduct(productId)
				                    .orElseThrow( () -> new IllegalArgumentException("Cannot find product."));
		int quantity = request.quantity();
		double totalPrice = quantity * product.price();
		return new Order(UUID.randomUUID().toString(), product, customer, quantity, totalPrice);
	}

}
