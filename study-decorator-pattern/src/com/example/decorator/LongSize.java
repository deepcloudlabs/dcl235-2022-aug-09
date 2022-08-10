package com.example.decorator;

import com.example.Coffee;

public class LongSize implements Coffee {
	private Coffee coffee;
	
	public LongSize(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double getPrice() {
		return 1.7 * coffee.getPrice();
	}

}
