package com.example.decorator;

import com.example.Coffee;

public class Milk implements Coffee {
	private Coffee coffee;

	public Milk(Coffee coffee) {
		this.coffee = coffee;
	}

	@Override
	public double getPrice() {
		return coffee.getPrice() + 4;
	}

}
