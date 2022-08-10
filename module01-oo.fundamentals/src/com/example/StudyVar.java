package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class StudyVar {
    // private var m = 42; // instance variable
    
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// var is used only with local variables
		var x = 42; // int x, x is a local variable
		var y = fun(); // float y
		var lotteryNumbers = new ArrayList<List<Integer>>();
		var numbers = ThreadLocalRandom.current().ints(1, 60)
				    .distinct()
				    .limit(6)
				    .sorted()
				    .boxed()
				    .toList();
		var sayilar1 = List.of(1,2,3,4,5); // List<Integer>
		var sayilar2 = List.of(1,2,3,4,5.); // List<Number & Comparable<?>>
		List<Double> sayilar3 = List.of(1.,2.,3.,4.,5.); // List<Object & Serializable & Comparable<?>>
		
	}

	public static float fun() {
		return 3.14f;
	}
}

@SuppressWarnings("unused")
class Circle {
	private double x = 0;
	private double y = 0;
	private double radius = 0;
	
	public double circumference() {
		var _2pi = 2.0 * Math.PI; // local variable
		return _2pi * radius;
	}
}
