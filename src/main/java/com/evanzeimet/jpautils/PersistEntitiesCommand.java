package com.evanzeimet.jpautils;

import java.util.List;

import javax.persistence.EntityManager;

import com.evanzeimet.jpautils.api.EntityManagerCommand;

public class PersistEntitiesCommand<T> implements EntityManagerCommand<Void> {

	private List<T> entities;

	public PersistEntitiesCommand() {

	}

	public List<T> getEntities() {
		return entities;
	}

	public void setEntities(List<T> entities) {
		this.entities = entities;
	}

	@Override
	public Void execute(EntityManager entityManager) {
		if (entities != null) {
			for (T entity : entities) {
				entityManager.persist(entity);
			}
		}

		return null;
	}

}
