package com.neosoft.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.neosoft.Message;

public class TestMessage {

	private Message m;
	private String expected;
	private String actual;

	@BeforeEach
	public void setup() {
		System.out.println("BeforeEach.setup()");
		m = new Message();
		expected = "HELLO USER, WELCOME TO ASSERTION API!";
		actual = "";
	}

	@Test
	void testShowMessage() {
		System.out.println("test.setup()");
		actual = m.showMessage();
		assertEquals(expected, actual, "May Be Data Not Matching!");
	}

	@AfterEach
	public void clean() {
		System.out.println("afterEach.clean()");
		m = null;
		expected = actual = null;
	}
}