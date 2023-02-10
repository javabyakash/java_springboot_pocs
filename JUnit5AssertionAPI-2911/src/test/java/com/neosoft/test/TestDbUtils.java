package com.neosoft.test;

import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import com.neosoft.DbUtils;

public class TestDbUtils {
	
	@Test
	public void testGetCon() {
		Connection con1 = DbUtils.getCon();
		Connection con2 = DbUtils.getCon();
		
		//assertNotNull(con1,"Connection Not Created!");
		if(con1==null || con2==null) {
			fail("Connection may not be created!");
		}
		assertSame(con1, con2);
	}
}
