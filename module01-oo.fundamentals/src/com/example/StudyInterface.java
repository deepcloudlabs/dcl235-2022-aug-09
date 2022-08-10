package com.example;

public class StudyInterface {

	public static void main(String[] args) {
		Animal anonymousAnimal = new Animal(12) { // Anonymous Class

			@Override
			public void eat() {
				System.out.println("Anonymous animal is eating now...");
			}
			
		};
		anonymousAnimal.eat();
		System.out.println(anonymousAnimal.getClass());
		var wieredAnimal = new Animal(12) { // Anonymous Class
			
			@Override
			public void eat() {
				System.out.println("Wiered animal is eating now...");
			}
			
		};
		wieredAnimal.eat();
		System.out.println(wieredAnimal.getClass());
		
		var pet = new Pet() { // anonymous class

			@Override
			public void play() {
				System.out.println("Pet is playing now...");
			}
			
		};
		pet.play();
		System.out.println(pet.getClass());
	}

}

abstract class Animal {
	private int legs;

	public Animal(int legs) {
		this.legs = legs;
	}

	public int getLegs() {
		return legs;
	}

	public abstract void eat();
}

class Spider extends Animal { // concrete

	public Spider() {
		super(8);
	}

	@Override
	public void eat() {
		System.out.println("Spider is eating now...");
	}

}
class Cat extends Animal implements Pet {

	public Cat() {
		super(4);
	}

	@Override
	public void play() {
	}

	@Override
	public void eat() {
	}
	
}

abstract interface Pet { // until java se 8
	void play();
}

interface AA {
	public static final int x = 42; // global constant
	int y = 100;
}

interface BB {}
interface CC {}
interface DD extends AA, BB, CC {} // multiple inheritance