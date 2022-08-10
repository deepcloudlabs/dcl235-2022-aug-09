package com.example.crm.service.business;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import com.example.crm.domain.Customer;
import com.example.crm.service.CustomerService;

public class StandardCustomerService implements CustomerService {
	public StandardCustomerService() {
		System.out.println("StandardCustomerService::StandardCustomerService()");
	}

	@Override
	public Optional<Customer> getCustomerByIdentity(String identity) {
		return Optional.of(new Customer(identity, "jack bauer", ThreadLocalRandom.current().nextInt(1960, 2000)));
	}

}
