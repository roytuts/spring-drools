package com.roytuts.springboot3.drools.exception;

public class ValidationException extends RuntimeException {

	private static final long serialVersionUID = 8263652792230400320L;

	public ValidationException(String msg) {
		super(msg);
	}

	public ValidationException(Throwable t) {
		super(t);
	}

	public ValidationException(String msg, Throwable t) {
		super(msg, t);
	}

}
