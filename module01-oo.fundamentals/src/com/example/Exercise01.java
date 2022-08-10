package com.example;

public class Exercise01 {
	public static void main(String[] args) {
		A a = new B();
		System.out.println(a instanceof E);
		if (a instanceof Object) {
			
		}
	}
}

class A extends F {}
class B extends A implements D, E{
	public int fun() {return 42;}
}
class C extends Object {}
class F extends Object {}
interface D {}
interface E {}