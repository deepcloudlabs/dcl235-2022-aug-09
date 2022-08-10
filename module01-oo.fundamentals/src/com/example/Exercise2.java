package com.example;

public class Exercise2 {
	public static void main(String[] args) {
		A a = new A();
		if (a instanceof B b && b.fun() > 20) { // Guard
			// do something
		}
		if (a instanceof B) { // Guard
		   B b = (B) a;
		   if (b.fun() > 20) {
			   // do something
		   }
		}
	}
}

