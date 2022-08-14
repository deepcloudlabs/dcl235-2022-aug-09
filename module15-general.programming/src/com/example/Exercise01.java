package com.example;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

public class Exercise01 {

	public static void main(String[] args) {
		var numbers = IntStream.range(1, 11).boxed().toList();
		// iterator
		{
			var iter1 = numbers.iterator();
			while (iter1.hasNext()) {
				var number = iter1.next();
				System.out.println(number);
			}			
		}
		// no iter1!!!
        // for
		for (var iter2 = numbers.iterator();iter2.hasNext();) {
			var number = iter2.next();
			System.out.println(number);			
		}
		// no iter2!!!
		
		// for-each applies to collection
		for (var number : numbers) {
			System.out.println(number);			
		}
		int[] array = {1,2,3,4,5,6,7,8,9,10};
		for (var arr : array) {
			System.out.println(arr);			
		}
		
		// stream
		long start = System.currentTimeMillis();
		numbers.forEach(System.out::println);
		long stop = System.currentTimeMillis();
		System.out.println(stop-start);
		Arrays.stream(array).forEach(System.out::println);
		Map<String,Integer> areaCodes = Map.of(
		      "ankara" , 312,
		      "istanbul-anadolu", 216,
		      "istanbul-avrupa", 212
		);
		areaCodes.keySet().forEach(System.out::println);
		areaCodes.values().forEach(System.out::println);
		areaCodes.entrySet().forEach(entry -> System.out.println("%16s --> %3d".formatted(entry.getKey(),entry.getValue())) );
		areaCodes.forEach((city,code) -> System.out.println("%16s --> %3d".formatted(city,code)) );
		
	}

}
