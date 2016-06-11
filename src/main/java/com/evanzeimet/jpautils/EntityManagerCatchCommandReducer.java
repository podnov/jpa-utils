package com.evanzeimet.jpautils;

import javax.persistence.EntityManager;

import com.evanzeimet.jpautils.api.EntityManagerCatchCommand;
import com.evanzeimet.jpautils.api.EntityManagerCommand;
import com.evanzeimet.jpautils.api.EntityManagerCommandRuntimeException;

public class EntityManagerCatchCommandReducer<T> implements EntityManagerCommand<T> {

	private EntityManagerCatchCommand<T> command;

	public EntityManagerCatchCommandReducer() {

	}

	public EntityManagerCatchCommand<T> getCommand() {
		return command;
	}

	public void setCommand(EntityManagerCatchCommand<T> command) {
		this.command = command;
	}

	@Override
	public T execute(EntityManager entityManager) {
		T result;

		try {
			result = command.execute(entityManager);
        } catch (Exception e) {
			throw new EntityManagerCommandRuntimeException(e);
		}

		return result;
	}

}
