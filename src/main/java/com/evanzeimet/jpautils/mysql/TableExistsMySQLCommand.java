package com.evanzeimet.jpautils.mysql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.evanzeimet.jpautils.api.EntityManagerCommand;

public class TableExistsMySQLCommand implements EntityManagerCommand<Boolean> {

	private String schemaName;
	private String tableName;

	public TableExistsMySQLCommand() {

	}

	public String getSchemaName() {
		return schemaName;
	}

	public void setSchemaName(String schemaName) {
		this.schemaName = schemaName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
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

	protected String createSql() {
		String result;

		if (schemaName == null) {
			result = String.format("show tables like '%s'", tableName);
		} else {
			result = String.format("show tables from %s like '%s'", schemaName, tableName);
		}

		return result;
	}
}
