package com.example.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProfilingHandler implements InvocationHandler {
	private Object target;
	
	public ProfilingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var methodName = method.getName();
		long start = System.nanoTime();
		var result = method.invoke(target, args);
		long stop = System.nanoTime();
		System.err.println(String.format("Method (%s) runs %d ns.", methodName,(stop-start)));		
		return result;
	}

}
