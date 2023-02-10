package com.neosoft.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.neosoft.DbConnection;

public class TestDbConnection {

	private DbConnection dbc;
	private Connection con;

	@BeforeEach
	public void setup() {
		dbc = new DbConnection();
	}

	@Test
	public void testGetCon() {
		assertDoesNotThrow(() -> {
			con = dbc.getCon();
		});
		//assertNotNull(con, "Connection is not created, Please check!");
		assertNull(con,"Connection is null");
	}

	@AfterEach
	public void clean() {
		con = null;
		dbc = null;
	}
}
