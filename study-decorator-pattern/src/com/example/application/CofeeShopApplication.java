package com.example.application;

import com.example.Coffee;
import com.example.FilterCoffee;
import com.example.decorator.LongSize;
import com.example.decorator.Milk;
import com.example.decorator.Sugar;

public class CofeeShopApplication {

	public static void main(String[] args) {
		Coffee coffee = new Sugar(new Milk(new Sugar(new Milk(new LongSize(new FilterCoffee())))));
		
		System.err.println("Payment: "+coffee.getPrice());		

	}

}
