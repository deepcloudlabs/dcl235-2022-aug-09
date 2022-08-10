package com.example.hr.exercise;

import java.util.List;

public class StudyInteger {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// -Djava.lang.Integer.IntegerCache.high=1024
		// Integer is an immutable class
		Integer x = Integer.valueOf(108); // Boxing
		Integer y = 108; // Auto-boxing since java se 5 
		Integer u = 549;
		Integer v = 549;
		System.err.println("x==y? "+(x==y)); // true
		System.err.println("u==v? "+(u==v)); // false
		int a = 549; // 4-byte
		Integer b = 549; //12-byte header + 4-byte = 16-byte
		List<Integer> numbers; // 16M
		// List<int> -> 4M
	}

}
