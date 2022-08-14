package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;

public class WatchDog {
     // -Xss8m
	public static void main(String[] args) throws Exception {
		String day = "MONDAY";
		// generator function
		boolean weekDay =
		switch (day) {
			case "MONDAY","FRIDAY" -> { 
				yield true;
			}
			case "SATURDAY","SUNDAY" -> {
				yield false;
			}
			default -> {
				throw new IllegalArgumentException("Unknown day!");
			}
		};
		String cmd = "mspaint";
		var numbers = new ArrayList<Integer>();
		var tsNumbers = Collections.synchronizedList(numbers);
		ConcurrentHashMap<String, Integer> tsMap; // multi-core
		CopyOnWriteArrayList<Integer> list;
		LinkedBlockingQueue<Integer> queue;
        do {
            Process process = Runtime.getRuntime().exec(cmd);
            ProcessHandle ph = process.toHandle();
            CompletableFuture<ProcessHandle> onExit = ph.onExit();
            onExit.get();
            System.err.println("Exit value: "+process.exitValue());
        } while (true);
	}

}
