package com.evanzeimet.jpautils;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.evanzeimet.jpautils.api.EntityManagerCommand;
import com.evanzeimet.jpautils.api.EntityManagerCommandRuntimeException;

public class TransactionWrappingCommand<T> implements EntityManagerCommand<T> {

	private EntityManagerCommand<T> command;

	public TransactionWrappingCommand() {

	}

	public EntityManagerCommand<T> getCommand() {
		return command;
	}

	public void setCommand(EntityManagerCommand<T> command) {
		this.command = command;
	}

	@Override
	public T execute(EntityManager entityManager) {
		T result = null;
		Exception exception = null;

		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();

		try {
			result = command.execute(entityManager);
		} catch (Exception e) {
			exception = e;
		}

		if (exception == null) {
			transaction.commit();
		} else {
			transaction.rollback();
			throw new EntityManagerCommandRuntimeException(exception);
		}

		return result;
	}

}
