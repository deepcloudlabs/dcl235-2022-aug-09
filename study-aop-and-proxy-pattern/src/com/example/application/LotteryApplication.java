package com.example.application;

import java.lang.reflect.Proxy;
import java.util.stream.IntStream;

import com.example.handler.AuditHandler;
import com.example.handler.CachingHandler;
import com.example.handler.ProfilingHandler;
import com.example.service.LotteryService;
import com.example.service.business.StandardLotteryService;

public class LotteryApplication {

	public static void main(String[] args) {
		LotteryService standardLotteryService = StandardLotteryService.getSingleton();
		var clazz = standardLotteryService.getClass();
		AuditHandler auditHandler = new AuditHandler(standardLotteryService);
		final LotteryService lotteryService = 
				(LotteryService) Proxy.newProxyInstance(
				            clazz.getClassLoader(), 
				            clazz.getInterfaces(), 
				            auditHandler);
		ProfilingHandler profilingHandler = new ProfilingHandler(lotteryService);
		final LotteryService lotteryService2 = 
				(LotteryService) Proxy.newProxyInstance(
						clazz.getClassLoader(), 
						clazz.getInterfaces(), 
						profilingHandler);
		
		CachingHandler cachingHandler = new CachingHandler(lotteryService2);
		final LotteryService lotteryService3 = 
				(LotteryService) Proxy.newProxyInstance(
						clazz.getClassLoader(), 
						clazz.getInterfaces(), 
						cachingHandler);

		IntStream.range(0, 10)
		         .mapToObj(i ->lotteryService3.draw(60+2*i, 6+i))
		         .forEach(System.err::println);
	}

}
