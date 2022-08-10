package com.example.crm.service.business;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import com.example.crm.domain.Customer;
import com.example.crm.service.CustomerService;

public class FastCustomerService implements CustomerService {
	public FastCustomerService() {
		System.out.println("FastCustomerService::FastCustomerService()");
	}

	@Override
	public Optional<Customer> getCustomerByIdentity(String identity) {
		return Optional.of(new Customer(identity, "jack bauer", ThreadLocalRandom.current().nextInt(1960, 2000)));
	}

}
