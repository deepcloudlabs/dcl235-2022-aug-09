package com.example;

public class StudyString {

	public static void main(String[] args) {
		// Flyweight Pattern -> String -> Immutable, record
		String name1= "jack"; // constant pool -> object pooling (Permanent Generation (PermGen), MetaSpace)
		String name2= "jack"; // constant pool -> object pooling
		String name3= new String("jack"); // heap
		name1.toUpperCase();
		// heap -> constant pool
		name3 = name3.intern(); // internalize: heap -> constant pool
		// GC -> G1GC (=Garbage First): String Deduplication
		// -XX:+UseG1GC -XX:+UseStringDeduplication, G1GC is the default GC since Java 9
		// -XX:+PrintStringDeduplicationStatistics
		// http://binkurt.blogspot.com/2014/09/string-deduplication.html
		System.out.println(name1==name2);
		System.out.println(name1==name3);
	}

}

// https://openjdk.org/projects/valhalla/
record Circle(double x,double y,double radius) {}
// List<Circle> 1M -> 12B + 4B + 8B + 8B + 8B => 40B -> 40MB
// After Valhalla: List<Circle> 1M: | x (8B) y (8B) radius (8B) | x (8B) y (8B) radius (8B) | ...
//                              24MB
// GPU (https://openjdk.org/projects/sumatra)
//