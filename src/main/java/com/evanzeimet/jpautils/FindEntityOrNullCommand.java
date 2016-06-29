package com.evanzeimet.jpautils;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import com.evanzeimet.jpautils.api.EntityManagerCommand;

public class FindEntityOrNullCommand<T> implements EntityManagerCommand<T> {

	private Class<T> entityClass;
	private Object primaryKey;

	public FindEntityOrNullCommand() {

	}

	public Class<T> getEntityClass() {
		return entityClass;
	}

	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public Object getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Object primaryKey) {
		this.primaryKey = primaryKey;
	}

	@Override
	public T execute(EntityManager entityManager) {
		T result;

		try {
			result = entityManager.find(entityClass, primaryKey);
		} catch (NoResultException e) {
			result = null;
		}

		return result;
	}

}
