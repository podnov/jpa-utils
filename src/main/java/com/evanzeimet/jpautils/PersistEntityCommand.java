package com.evanzeimet.jpautils;

import javax.persistence.EntityManager;

import com.evanzeimet.jpautils.api.EntityManagerCommand;

public class PersistEntityCommand<T> implements EntityManagerCommand<Void> {

	private T entity;

	public PersistEntityCommand() {

	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	@Override
	public Void execute(EntityManager entityManager) {
		entityManager.persist(entity);
		return null;
	}
}
