package com.evanzeimet.jpautils.api;

public class EntityManagerCommandRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 7335894732331910418L;

	public EntityManagerCommandRuntimeException() {
		super();
	}

	public EntityManagerCommandRuntimeException(String message) {
		super(message);
	}

	public EntityManagerCommandRuntimeException(Throwable cause) {
		super(cause);
	}

	public EntityManagerCommandRuntimeException(String message, Throwable cause) {
		super(message, cause);
	}
}
