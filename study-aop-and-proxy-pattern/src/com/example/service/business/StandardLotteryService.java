package com.example.service.business;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

import com.example.service.LotteryService;

public final class StandardLotteryService implements LotteryService {
	
	private StandardLotteryService() {}
	
	private volatile static LotteryService singleton ;
	
	public static synchronized LotteryService getSingleton() {
		if (Objects.isNull(singleton))
			singleton = new StandardLotteryService();
		return singleton;
	}

	@Override
	public List<Integer> draw(int max, int size) {
		return ThreadLocalRandom.current().ints(1,max+1)
				   .distinct()
				   .limit(size)
				   .sorted()
				   .boxed()
				   .collect(Collectors.toList());
	}

}
