package com.example.dictionary.exercises;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.IntStream;

public class Exercise5 {

	public static void main(String[] args) throws Exception {
		final List<String> words = Files.readAllLines(Paths.get("src", "dictionary.txt"));
		// Count the vowels used in words
		long count = words.stream().map(String::chars).flatMap(IntStream::boxed).filter(Exercise5::isVowel).count();
		System.out.println(count);
		int length = words.stream().mapToInt(String::length).sum();
		System.out.println(length);
	}

	public static long countVowel(String s) {
		return s.chars().filter(Exercise5::isVowel).count();
	}

	public static boolean isVowel(int c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'u' || c == 'o';
	}

}
