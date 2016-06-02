package com.evanzeimet.jpautils;

import javax.persistence.EntityManager;

import com.evanzeimet.jpautils.api.EntityManagerCommand;

public class MergeEntityCommand<T> implements EntityManagerCommand<T> {

	private T entity;

	public MergeEntityCommand() {

	}

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

	@Override
	public T execute(EntityManager entityManager) {
		return entityManager.merge(entity);
	}
}
