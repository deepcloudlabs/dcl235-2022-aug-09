package com.example;

import java.util.Optional;
import java.util.function.Consumer;

@SuppressWarnings("unused")
public class StudyOptional {

	public static void main(String[] args) {
		Service srv = new Service();
		Optional<String> result = 
				srv.getValue("test");
		// SAFE: Functional
		Consumer<String> println = 
				System.out::println;
		Consumer<String> sendEmail = 
				System.out::println;
		Consumer<String> printAndSendEmail = println.andThen(sendEmail);
		result.ifPresent(printAndSendEmail);
		String s = result.orElse("default");
		result.orElseThrow(IllegalArgumentException::new);
		// SAFE
		if (result.isPresent())
		   System.out.println(result.get());
	}

}

class Service {
	public Optional<String> getValue(String code){
		return Optional.ofNullable(null);
	}
}