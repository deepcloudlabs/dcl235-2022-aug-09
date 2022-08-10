package com.example.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class CachingHandler implements InvocationHandler {
	private Object target;
	private Map<String,Map<String,Object>> cache= new ConcurrentHashMap<>();
	public CachingHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		var methodName = method.getName();
		var methodCache = cache.get(methodName);
		if (Objects.isNull(methodCache)) {
			methodCache = new ConcurrentHashMap<>();
			cache.put(methodName, methodCache);
		}
		var paramsKey = Arrays.toString(args);
		var result = methodCache.get(paramsKey);
		if (Objects.isNull(result)) {
			result = method.invoke(target, args);
			methodCache.put(paramsKey, result);
		}
		System.err.println(String.format("Method (%s) returns %s.", methodName,result));		
		return result;
	}

}
