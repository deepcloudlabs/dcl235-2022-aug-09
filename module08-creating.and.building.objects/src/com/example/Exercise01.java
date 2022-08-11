package com.example;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.TreeSet;

public class Exercise01 {

	public static void main(String[] args) {
		var x = new BigDecimal("1.1");
		var y = new BigDecimal("1.10");
		var set1 = new HashSet<BigDecimal>(); // equals
		var set2 = new TreeSet<BigDecimal>(); // compareTo
		set1.add(x);
		set1.add(y);
		set2.add(x);
		set2.add(y);
		System.out.println(x.equals(y)); // false
		System.out.println(x.compareTo(y)); // 0
		System.out.println(set1.size()); // 2
		System.out.println(set2.size()); // 1
	}

}
