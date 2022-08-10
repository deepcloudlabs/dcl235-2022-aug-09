package com.example;

import java.util.List;

public class StudyInteger {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// -XX:AutoBoxCacheMax=2048
		int x = 42; // 4-Byte
		Integer y = 42; // 4-Byte (y) + 12-Byte (Header) + 4-byte (int value) = 20-Byte
		Integer z = 42;
		System.out.println(y==z); // true
		Integer u = Integer.valueOf(615);
		Integer v = 615;
		System.out.println(u==v); // false
		
		List<Integer> numbers= List.of(1,1,1,2,2,2); // 2 x 20-Byte = 40B
		// List<Integer> -> List<int>
	}

}
