package com.example.application;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class AsyncFunctions {

	public static void main(String[] args) {
		System.out.println("Application is just started.");
		Gun gun = new Gun();
		gun.haveGun().thenAccept(result -> System.out.println("[%s] result is %s".formatted(Thread.currentThread().getName(),result)));
		for (var i = 0; i < 10; ++i)
			try {
				TimeUnit.SECONDS.sleep(1);
				System.out.println("[%s] Working hard!".formatted(Thread.currentThread().getName()));
			} catch (Exception e) {}
		System.out.println("Application is just finished.");
	}

}

class Fun {

	public int haveFun() {
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (Exception e) {
		}
		return 42;
	}
}

class Gun {

	public CompletableFuture<Integer> haveGun() {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("%s running the async method body!".formatted(Thread.currentThread().getName()));
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (Exception e) {
			}
			return 42;
		});
	}
}
