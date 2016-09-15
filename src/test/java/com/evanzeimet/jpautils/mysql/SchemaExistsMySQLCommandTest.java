package com.evanzeimet.jpautils.mysql;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SchemaExistsMySQLCommandTest {

	private SchemaExistsMySQLCommand command;

	@Before
	public void setUp() {
		command = new SchemaExistsMySQLCommand();
	}

	@Test
	public void createSql() {
		String givenSchemaName = "my_schema";

		command.setSchemaName(givenSchemaName);

		String actual = command.createSql();
		String expected = "show databases like 'my_schema'";

		assertEquals(expected, actual);
	}

}
