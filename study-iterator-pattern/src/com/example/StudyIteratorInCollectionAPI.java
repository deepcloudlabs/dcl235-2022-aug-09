package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class StudyIteratorInCollectionAPI {

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<>(List.of(4,8,15,16,23,42));
		Iterator<Integer> iter = numbers.iterator();
		while(iter.hasNext()) { // external loop
			var number = iter.next();
			System.err.println(number);
		}
		// Java SE 5
		// external loop
		for (var number : numbers) { // for-each: read-only
			System.err.println(number);
		}
		// Java SE 8
		// internal loop + Stream API (Filter/Map/Reduce)
		numbers.parallelStream().forEach(System.err::println);
		// Java SE 7 -> Fork/Join Framework + Fork/Join Thread Pool -> Work Stealing
		// Data Parallelism -> FJ (multi-core) -> Fork
		// [         |         ] <- Fork
		// [   |    ] [    |   ] <- 2x Fork
		// ...
		
		Spliterator<Integer> spliterator = numbers.spliterator();
		System.err.println(numbers.size());
		System.err.println(spliterator.estimateSize());
		var leftSide = spliterator.trySplit();
		System.err.println(spliterator.estimateSize()); // 3
		System.err.println(leftSide.estimateSize()); // 3
	}

}
