package com.evanzeimet.jpautils.api;

import javax.persistence.EntityManager;


public interface EntityManagerCatchCommand<T> {

	T execute(EntityManager entityManager) throws EntityManagerCommandException;

}
