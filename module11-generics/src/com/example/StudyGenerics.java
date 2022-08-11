package com.example;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;

public class StudyGenerics {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(42);
		Integer i = numbers.get(0); // ClassCastException-free
		List<String> names = new ArrayList<>();
		Object[] sayilar = new Long[10];
		// Error: names.add(BigInteger.TEN);
//        sayilar[0] = "first element";
//        sayilar[0] = 3.14;
//        sayilar[0] = 3.14;
		Stack<String> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		// Object []arr1 = numbers.toArray();
		// String []arr2 = numbers.toArray(new String[0]);
		for (var weekDay : WEEK_DAYS.values()) {
			System.out.println(weekDay.name() + ": " + weekDay.ordinal() + ", " + weekDay.isWeekend());
		}
		var wday = WEEK_DAYS.valueOf("SUNDAY");
		System.out.println(wday);
		EnumSet<WEEK_DAYS> mySet;
		EnumMap<WEEK_DAYS, List<String>> myMap;
	}

}

@SuppressWarnings("unused")
class Stack<E> {
	private Object[] array;
}

enum WEEK_DAYS {
	MONDAY(false), TUESDAY(false), SATURDAY(true), SUNDAY(true);

	private final boolean weekend;

	private WEEK_DAYS(boolean weekend) {
		this.weekend = weekend;
	}

	public boolean isWeekend() {
		return weekend;
	}

}