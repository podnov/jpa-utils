package com.evanzeimet.jpautils.mysql;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TableExistsMySQLCommandTest {

	private TableExistsMySQLCommand command;

	@Before
	public void setUp() {
		command = new TableExistsMySQLCommand();
	}

	@Test
	public void createSql_schemaName_tableName() {
		String givenSchemaName = "my_schema";
		String givenTableName = "my_table";

		command.setSchemaName(givenSchemaName);
		command.setTableName(givenTableName);

		String actual = command.createSql();
		String expected = "show tables from my_schema like 'my_table'";

		assertEquals(expected, actual);
	}

	@Test
	public void createSql_tableName() {
		String givenTableName = "my_table";

		command.setTableName(givenTableName);

		String actual = command.createSql();
		String expected = "show tables like 'my_table'";

		assertEquals(expected, actual);
	}
}
