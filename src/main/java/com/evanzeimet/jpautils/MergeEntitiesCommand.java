package com.evanzeimet.jpautils;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.evanzeimet.jpautils.api.EntityManagerCommand;

public class MergeEntitiesCommand<T> implements EntityManagerCommand<List<T>> {

	private List<T> entities;

	public MergeEntitiesCommand() {

	}

	public List<T> getEntities() {
		return entities;
	}

	public void setEntities(List<T> entities) {
		this.entities = entities;
	}

	@Override
	public List<T> execute(EntityManager entityManager) {
		List<T> result = null;

		if (entities != null) {
			result = new ArrayList<T>();

			for (T entity : entities) {
				T mergedEntity = entityManager.merge(entity);
				result.add(mergedEntity);
			}
		}

		return result;
	}

}
