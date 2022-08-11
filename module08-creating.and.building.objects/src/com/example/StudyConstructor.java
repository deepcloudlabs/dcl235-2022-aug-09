package com.example;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.LongStream;

public class StudyConstructor {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		var streamSum = LongStream.range(0, Integer.MAX_VALUE).parallel().sum();
		long stop = System.currentTimeMillis();
		System.out.println("sum= %d @ %d msec.".formatted(streamSum,(stop-start)));
		
		long sum = 0L;
		start = System.currentTimeMillis();
		for (var i=0;i<Integer.MAX_VALUE;i++)
			sum += i; // auto-boxing + auto-unboxing
			// sum = Long.valueOf(sum.longValue() + i);
		stop = System.currentTimeMillis();
		System.out.println("sum= %d @ %d msec.".formatted(sum,(stop-start)));
		// Arrays: utility class -> private constructor, final class 
		//         static methods
		// Math, Collections, Collectors, Files, Objects, Objects (throw new AssertionError("No java.util.Objects instances for you!");)
		
		A a = A.valueOf(42); // Heap Object -> attribute
		Integer i = Integer.valueOf(42);
		var point = Point.of(1, 2);
		String name = "jack";
		var upperCaseName = name.toUpperCase();
		System.out.println(upperCaseName);
		var bi1 = BigInteger.valueOf(123); // immutable
		bi1 = bi1.add(BigInteger.ONE);
		System.out.println(bi1);
		var sayilar = Arrays.asList(1, 2, 3, 4, 5, 6); // mutable list
		var numbers = List.of(1, 2, 3, 4, 5, 6); // immutable list
		numbers.add(3);
		numbers.remove(3);
		var nokta1 = new Nokta(10, 20);
		System.out.println(nokta1.x());
		System.out.println(nokta1.y());
		var kate = new Customer(
				"11111111110", 
				"kate austen", 
				List.of(new Account()), 
				"kate.austen@example.com", 
				"+905554444"
		);
		var jack = new Customer.Builder()
				               .fullname("jack bauer")
				               .phone("+905555555")
				               .accounts(new Account(),new Account())
				               .identity("11111111110")
				               .email("jack.bauer@example.com")
				               .build();
	}

}

@SuppressWarnings("unused")
class Customer {
	private String identity;
	private String fullname;
	private List<Account> accounts;
	private String email;
	private String phone;

	public Customer(String identity, String fullname, List<Account> accounts) {
		this(identity, fullname, accounts, null, null);
	}

	public Customer(String identity, String fullname, List<Account> accounts, String email, String phone) {
		this.identity = identity;
		this.fullname = fullname;
		this.accounts = accounts;
		this.email = email;
		this.phone = phone;
	}

	public Customer(Builder builder) {
		this.identity = builder.identity;
		this.fullname = builder.fullname;
		this.accounts = builder.accounts;
		this.email = builder.email;
		this.phone = builder.phone;
	}

	public static class Builder {
		private String identity;
		private String fullname;
		private List<Account> accounts;
		private String email;
		private String phone;

		public Builder identity(String identity) {
			this.identity = identity;
			return this;
		}

		public Builder fullname(String fullname) {
			this.fullname = fullname;
			return this;
		}

		public Builder accounts(Account... accounts) {
			this.accounts = Arrays.asList(accounts);
			return this;
		}

		public Builder email(String email) {
			this.email = email;
			return this;
		}

		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public Customer build() {
			// business rule, invariants, validation, constraints, ...
			return new Customer(this);
		}
	}

}

// immutable class -> TS, 

// Entity Class -> persistent, identity
@SuppressWarnings("unused")
class Account {
	private String iban;
	private double balance;
}

// Domain Class: Entity Class, Aggregate, Value Object (DDD), Solution Class
// Value Object: has no identity
final class A {
	private static Map<Integer, A> cache = new ConcurrentHashMap<>();
	private final int x;

	private A(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public static A valueOf(int x) {
		// validation
		if (x <= 0)
			throw new IllegalArgumentException("x must be a positive integer!");
		// object pooling -> immutable
		var cachedObject = cache.get(x);
		if (Objects.isNull(cachedObject)) {
			cachedObject = new A(x);
			cache.put(x, cachedObject);
		}
		return cachedObject;
	}
}

final class Point {
	private final int x;
	private final int y;

	private Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public static Point of(int x, int y) {
		// caching, validation, ...
		return new Point(x, y);
	}
}

record Nokta(int x, int y) {
	public Nokta() {
		this(0, 0); // all argument constructor
	}

	public Nokta(int x) {
		this(x, 0); // all argument constructor
	}

	public static Nokta of(int x, int y) {
		// caching, validation, ...
		return new Nokta(x, y);
	}
} // immutable
