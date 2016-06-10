package com.evanzeimet.jpautils.postgres;

import java.util.List;

import javax.persistence.EntityManager;

import com.evanzeimet.jpautils.api.EntityManagerCommand;

public class TruncatePostgresTablesCommand implements EntityManagerCommand<Void> {

	private List<String> tableNames;

	public TruncatePostgresTablesCommand() {

	}

	public List<String> getTableNames() {
		return tableNames;
	}

	public void setTableNames(List<String> tableNames) {
		this.tableNames = tableNames;
	}

	@Override
	public Void execute(EntityManager entityManager) {
		TruncatePostgresTableCommand command = new TruncatePostgresTableCommand();

		for (String tableName : tableNames) {
			command.setTableName(tableName);
			command.execute(entityManager);
		}

		return null;
	}

}
