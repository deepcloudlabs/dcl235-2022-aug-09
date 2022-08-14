package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SplittableRandom;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Exercise03 {

	public static void main(String[] args) {
		// Functional Programming
		//  i) HoF: Stream API -> filter, map, flatMap, ... -> @FunctionalInterface -> SAM
		// ii) Pure Function (side-effect-free) -> a) Anonymous Class -> Lambda Expression b) Method Reference 

		// Stream API: i) FP -> immutability
		//            ii) Fluent API -> method chaining -> pipeline 
		//           iii) lazy evaluation 
		//            iv) default -> sequential, one-pass execution (.sequential())
		//             v) .parallel() -> fork/join framework -> fork-join pool -> job stealing algorithm
		//                               data parallelism
		// ArrayList/HashMap/HastSet/ConcurrentHashMap/Java Array (Arrays.stream())/int range/long range
		// LoR (Locality of Reference)
		// int/long/double
		// IntStream.range(0, 1_000_000)
		// LongStream.range(0, 1_000_000_000_000L)
		var random = new SplittableRandom();
		// instead of "ThreadLocalRandom.current().ints(0, 60).parallel()." use the following
		var randomNumbers = random.ints(0, 60).parallel().distinct().limit(10).boxed().toList();
		var numbers = ThreadLocalRandom.current().ints(0, 60)
				                                 .parallel().peek(System.out::println)
				                                 .distinct().peek(System.out::println)
				                                 .limit(6).peek(System.out::println)
				                                 .sorted().peek(System.out::println);
		numbers.sequential().forEach(System.out::println);
		var data = new ArrayList<Integer>();
		data.add(1);
		data.add(2);
		data.add(3);
		// ConcurrentModificationException
		var sayilar = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		var iter = data.iterator();
		data.stream().forEach( sayi -> {
			data.remove(sayi); // CME -> Bug
			System.out.println(sayi);
		});
		// sayilar.stream(). -> read-only, cannot change sayilar!!!
	    /* final */ Integer []counter = {2}; // effectively final
		Predicate<Integer> isEven = u -> { // immutability -> pure function
			counter[0]++;
			return u%2 == 0;
		} ;
		System.out.println(isEven.test(42));
		var sum = getNumbers().sum();
		
	}
	// int, long, double
	public static IntStream getNumbers(){ // lazy
		return Stream.of(1,2,3,4,5,6,7,8,9).filter(u -> u%3 == 0).mapToInt(u -> u*u*u);
	}
}
