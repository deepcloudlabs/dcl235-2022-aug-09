package com.example.service.business;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public enum StandardLotteryEnumService { // TS, CC
	SINGLETON();
	
	private StandardLotteryEnumService() {
	}

	public List<Integer> draw(int max, int size) {
		return ThreadLocalRandom.current().ints(1,max+1)
				   .distinct()
				   .limit(size)
				   .sorted()
				   .boxed()
				   .collect(Collectors.toList());
	}	
}
