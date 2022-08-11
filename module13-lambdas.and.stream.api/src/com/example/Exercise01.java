package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Exercise01 {
	public static void main(String[] args) {
		var names = new ArrayList<String>();
		names.add("jack");
		names.add("james");
		names.add("kate");
		names.add("jin");
		names.add("sun");
		names.add("ben");
		System.out.println(names);
		Collections.sort(names, 
				   new Comparator<String>() { // anonymous
				      public int compare(String s1, String s2) {
				          return Integer.compare(
				                     s1.length(), s2.length());
				      }
				   }
				);
		                       // lambda expression
		Comparator<String> orderByStringLengthAsc = (s1,s2) -> Integer.compare(s1.length(), s2.length());
		Collections.sort(names,orderByStringLengthAsc); 		 // 1
		names.sort(orderByStringLengthAsc);                      // 2
		var sortedNames = names.stream().parallel().sorted(orderByStringLengthAsc).toList();  // 3
		sortedNames = names.stream().parallel()
				.sorted(orderByStringLengthAsc.thenComparing(String::compareTo)).toList();  // 3
		System.out.println(names);
		System.out.println(sortedNames);

	}
}
