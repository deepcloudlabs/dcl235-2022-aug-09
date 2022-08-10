package com.example.crm.domain;

public record Customer(String identity,String fullname,int birthYear) {
	public Customer(String identity,String fullname) {
		this(identity,fullname,2000);
	}

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullname=" + fullname + "]";
	}
	
	public Customer fun() {
		return new Customer(identity,fullname,birthYear+1);
	}
}
