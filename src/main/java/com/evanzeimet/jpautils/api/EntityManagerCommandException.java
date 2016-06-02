package com.evanzeimet.jpautils.api;

public class EntityManagerCommandException extends Exception {

	private static final long serialVersionUID = 7335894732331910418L;

	public EntityManagerCommandException() {
		super();
	}

	public EntityManagerCommandException(String message) {
		super(message);
	}

	public EntityManagerCommandException(Throwable cause) {
		super(cause);
	}

	public EntityManagerCommandException(String message, Throwable cause) {
		super(message, cause);
	}
}
