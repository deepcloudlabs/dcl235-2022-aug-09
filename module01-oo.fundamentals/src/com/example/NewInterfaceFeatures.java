package com.example;

import java.util.stream.IntStream;

public class NewInterfaceFeatures {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		var x = 42; // primitive -> value
		var y = new Object(); // reference -> object
		
		// reference -> function i) lambda expression ii) method reference
		Gun gun = u -> u*u*u; // anonymous class
		
		var numbers = IntStream.range(1, 100_000_001).boxed().toList();
		var sum = 0L;
		for (var number : numbers)
			if (number%2 == 0)
			  sum += number*number;
		System.out.println("sum: %d".formatted(sum));
		var statistics = numbers.stream()
				                .parallel()
				                .filter(Fun::isEven) // HoF
				                .mapToInt(Fun::squared) //HoF
				                .summaryStatistics();
		System.out.println("statistics: %s".formatted(statistics));
	}

}
// functional programming -> function, i) Higher-Order Function, ii) Pure function
interface Fun {
	// 1. public static method since java 8
	public static boolean isEven(int p) {
		return p%2 == 0;
	}
	public static int squared(int p) {
		return p*p;
	}
	// 2. default method/implementation since java 8
	default int haveSun() {
		return 42;
	};
	// 3. private static method since java 9
	
	// 4. private method since java 9
}


@FunctionalInterface
interface Gun {
   // Single Abstract Method
  int cube(int x);
}