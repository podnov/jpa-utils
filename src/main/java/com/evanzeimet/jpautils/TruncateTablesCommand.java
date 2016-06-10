package com.evanzeimet.jpautils;

import java.util.List;

import javax.persistence.EntityManager;

import com.evanzeimet.jpautils.api.EntityManagerCommand;

public class TruncateTablesCommand implements EntityManagerCommand<Void> {

	private List<String> tableNames;

	public TruncateTablesCommand() {

	}

	public List<String> getTableNames() {
		return tableNames;
	}

	public void setTableNames(List<String> tableNames) {
		this.tableNames = tableNames;
	}

	@Override
	public Void execute(EntityManager entityManager) {
		TruncateTableCommand command = new TruncateTableCommand();

		for (String tableName : tableNames) {
			command.setTableName(tableName);
			command.execute(entityManager);
		}

		return null;
	}

}
