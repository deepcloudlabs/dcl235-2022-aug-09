package com.example.application;

import java.util.ArrayList;
import java.util.Collections;

public class StudyUtilityClasses {

	public static void main(String[] args) {
		// Build-in Classes examplifies Facade Pattern
		// Collection <-> Collections
		// Files -> Java IO
		// Arrays -> array
		// Stream -> Stream API
		ArrayList<Integer> s= new ArrayList<>();
		s.sort(Integer::compare);
		Collections.sort(s,Integer::compare);
		//Files.copy(source, out)
		
	}

}
