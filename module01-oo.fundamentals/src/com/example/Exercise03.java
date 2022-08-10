package com.example;

public class Exercise03 {

	public static void main(String[] args) {
		

	}

}

class AAA {}
final class BBB extends AAA {}

interface G {}

interface H {}

sealed class S permits T {}

final class T extends S {}
// Error: class U extends S {}