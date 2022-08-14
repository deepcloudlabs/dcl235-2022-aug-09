package com.example;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;

public class Exercise02 {

	public static void main(String[] args) {
		double x = 4.35 * 100 ; // 64-bit = 8-byte 2^64
		System.out.println("x= %3.32f".formatted(x));
		float y = 1_000_000_000f;
		y = y + 50;
		System.out.println("y= %3.32f".formatted(y));
		BigDecimal z = BigDecimal.valueOf(4.35);
		z = z.multiply(BigDecimal.valueOf(100));
		Collections.sort(null);
		HashMap<String,Integer> areaCodes = new HashMap<>();
	}

}
