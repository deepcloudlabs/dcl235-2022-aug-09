package com.example.decorator;

import com.example.Coffee;

public class Sugar implements Coffee {
	private Coffee coffee;
	
	public Sugar(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double getPrice() {
		return coffee.getPrice() + 1;
	}

}
