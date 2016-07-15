package com.evanzeimet.jpautils.postgresql;

import javax.persistence.EntityManager;

import com.evanzeimet.jpautils.api.EntityManagerCommand;

public class TruncateTablePostgreSQLCommand implements EntityManagerCommand<Void> {

	private String tableName;

	public TruncateTablePostgreSQLCommand() {

	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	@Override
	public Void execute(EntityManager entityManager) {
		String sql = createTruncateSql(tableName);
		entityManager.createNativeQuery(sql).executeUpdate();
		return null;
	}

	protected String createTruncateSql(String tableName) {
		return String.format("truncate table %s restart identity", tableName);
	}

}
