package com.example.decorator;

import com.example.Coffee;

public class Cream implements Coffee {
	private Coffee coffee;
	
	public Cream(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double getPrice() {
		return coffee.getPrice() + 7.5;
	}

}
