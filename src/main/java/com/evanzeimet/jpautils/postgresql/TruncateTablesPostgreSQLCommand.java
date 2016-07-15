package com.evanzeimet.jpautils.postgresql;

import java.util.List;

import javax.persistence.EntityManager;

import com.evanzeimet.jpautils.api.EntityManagerCommand;

public class TruncateTablesPostgreSQLCommand implements EntityManagerCommand<Void> {

	private List<String> tableNames;

	public TruncateTablesPostgreSQLCommand() {

	}

	public List<String> getTableNames() {
		return tableNames;
	}

	public void setTableNames(List<String> tableNames) {
		this.tableNames = tableNames;
	}

	@Override
	public Void execute(EntityManager entityManager) {
		TruncateTablePostgreSQLCommand command = new TruncateTablePostgreSQLCommand();

		for (String tableName : tableNames) {
			command.setTableName(tableName);
			command.execute(entityManager);
		}

		return null;
	}

}
