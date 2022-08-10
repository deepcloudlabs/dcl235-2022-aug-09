package com.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudyThreadPool {
	public static void main(String[] args) {
		// Submission abstraction
		ExecutorService es = 
		                     // Pooling strategy abstraction		
				  // Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
				     Executors.newWorkStealingPool(); // burst mode
		es.submit(()->{});
	}
}
