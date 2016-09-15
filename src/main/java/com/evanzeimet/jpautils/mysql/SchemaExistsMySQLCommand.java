package com.evanzeimet.jpautils.mysql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.evanzeimet.jpautils.api.EntityManagerCommand;

public class SchemaExistsMySQLCommand implements EntityManagerCommand<Boolean> {

	public String schemaName;

	public SchemaExistsMySQLCommand() {

	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	protected String createSql() {
		return String.format("show databases like '%s'",
				schemaName);
	}

	@Override
	public Boolean execute(EntityManager entityManager) {
		Boolean result;
		String sql = createSql();
		Query query = entityManager.createNativeQuery(sql);

		List<?> resultList = query.getResultList();

		if (resultList.isEmpty()) {
			result = false;
		} else {
			result = true;
		}

		return result;
	}

}
