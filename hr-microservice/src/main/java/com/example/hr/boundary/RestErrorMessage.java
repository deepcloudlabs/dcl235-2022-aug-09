package com.example.hr.boundary;

public class RestErrorMessage {
	private String status;
	private String message;

	public RestErrorMessage(String status, String message) {
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

}
