package com.ProductBackEnd.Exception;

public class InvalidInputException extends Exception {

	private static final long serialVersionUID = 2909732853499731592L; // backward compatible
	public InvalidInputException() {
		super();
	}

	public InvalidInputException(String message) {
		super(message);
	}
}
