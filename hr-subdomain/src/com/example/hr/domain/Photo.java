package com.example.hr.domain;

import java.util.Base64;
import java.util.Objects;

@ValueObject
public final class Photo {
	private final byte[] values;
	
	private Photo(byte[] values) {
		this.values = values;
	}

	public byte[] getValues() {
		return values;
	}
	public String getBase64EncodedValues() {
		return Base64.getEncoder().encode(values).toString();
	}
	
	public static Photo of(byte[] values) {
		Objects.requireNonNull(values);
		return new Photo(values);
	}
	
	public static Photo of(String values) { // base64 encoded
		Objects.requireNonNull(values);
		return new Photo(Base64.getDecoder().decode(values));
	}
 	
}
