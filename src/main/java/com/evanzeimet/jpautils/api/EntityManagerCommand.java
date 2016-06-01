package com.evanzeimet.jpautils.api;

import javax.persistence.EntityManager;

public interface EntityManagerCommand<T> extends EntityManagerCatchCommand<T> {

	@Override
	T execute(EntityManager entityManager);

}
