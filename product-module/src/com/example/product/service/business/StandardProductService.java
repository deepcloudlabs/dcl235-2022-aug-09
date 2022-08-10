package com.example.product.service.business;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import com.example.product.domain.Product;
import com.example.product.service.ProductService;

public class StandardProductService implements ProductService {
	public StandardProductService() {
		System.out.println("StandardProductService::StandardProductService()");
	}

	@Override
	public Optional<Product> findProduct(long productId) {
		return Optional.of(new Product(productId, "notebook", ThreadLocalRandom.current().nextDouble(15_000, 75_000)));
	}

}
