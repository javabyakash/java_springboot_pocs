package com.neosoft.test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import com.neosoft.DbUtils;

public class TestExample {

	@Test
	@Disabled
	public void testArray() {
		Integer[] expected = { 1, 2, 3 };
		Integer[] actual = { 1, 2, 3 };
		assertArrayEquals(expected, actual);
	}

	@Test
	@Disabled
	public void testBooleanValue() {
		Boolean isPresent = false;
		assertTrue(isPresent);
	}

	@Test
	@Disabled
	public void testNormal() {
		assertThrows(NullPointerException.class, () -> {
			throw new NullPointerException();
		});
	}

	@Test
	public void testAll() {
		assertAll(() -> {
			assertNotNull(DbUtils.getCon());
		}, () -> {
			Connection con1, con2;
			con1 = DbUtils.getCon();
			con2 = DbUtils.getCon();
			assertSame(con1, con2);
		}, () -> {
			Connection con1, con2;
			con1 = DbUtils.getCon();
			con2 = DbUtils.getCon();
			if (con1 == null || con2 == null) {
				fail();
			}
		});
	}
}
