package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercise {
    // Exceptions: 1) Business (checked) Exception   -> Exception
	//             2) Run-time (unchecked) Exception -> RuntimeException
	//             3) [Fatal] Error like OMError     -> Error
	public static void main(String[] args) {
		// jvm -> -ea or --enable-assertion
		int x = 11;
		assert x > 10 : "x must be larger than 10." ; // throws AssertionError if assert logic expression is false
		System.out.println("Application is done!");
		Aggregate a = new Aggregate();
		a.getNumbers().clear();
	}
    public static double fun(double value,TemperatureScale scale) {
    	return value;
    }
	private static void sort (long a[], int offset, int length){
		   assert a != null;
		   assert offset >= 0 && offset <= a.length;
		   assert length >= 0  && length <= (a.length - offset);
		   // business logic
	}
}

enum TemperatureScale {
	FAHRENHEIT, CELCIUS, KELVIN;
}
class Aggregate { // sub-domain state
	private int x;
	private B y;
	private C z; // Value Object -> Immutable Class
	private List<Integer> numbers= new ArrayList<>(); // immutable collection
	
	
	public List<Integer> getNumbers() {
		return Collections.unmodifiableList(numbers);
	}

	public B getY() {
		return y;
	}

	public C getZ() {
		return new C(); // defensive/guard
	}
	
	// business method
	void fun() {
		// business rule/constraint/invariants/validation/...
	}
	void gun() {}
}

record B(int u,double v) {}

class C {}