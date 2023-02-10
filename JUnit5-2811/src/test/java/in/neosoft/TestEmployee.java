package in.neosoft;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
@DisplayName("TESTING EMPLOYEE SERVICE")
public class TestEmployee {
	
	/*
	@BeforeAll
	public static void setupOnce() {
		System.out.println("FROM ONE TIME SETUP");
	}
	
	@BeforeEach
	public void setup() {
		System.out.println("FROM-SETUP");
	}
	
	@Test
	@Order(1)
	@DisplayName("TESTING SAVE METHOD")
	public void testSave() {
		System.out.println("EMPLOYEE SAVE");
	}
	
	@Test
	@Order(2)
	@DisplayName("TESTING UPDATE METHOD")
	@Disabled	// Ignoring these method from execution
	public void testUpdate() {
		System.out.println("EMPLOYEE UPDATE");
	}
	
	@Test
	@Order(3)
	@DisplayName("TESTING DELETE METHOD")
	public void testDelete() {
		System.out.println("EMPLOYEE DELETE");
	}
	
	@AfterEach
	public void clear() {
		System.out.println("FROM-CLEAR");
	}
	
	@AfterAll
	public static void closeAll() {
		System.out.println("ONCE AT END");
	}
	*/
	
	//@RepeatedTest()
	
	/*
	@RepeatedTest(value = 4, name = "{displayName}-{currentRepetition}/{totalRepetitions}")
	@DisplayName("MULTIPLE TEST")
	public void testMultiple(TestInfo info) {
		//System.out.println("FROM TEST MULTIPLE");
		//System.out.println("HELLO " + info.getTestClass().get().getName());
		//System.out.println("HELLO "+info.getTestMethod().get().getName());
		System.out.println("HELLO "+ info.getDisplayName());
	}
	*/
	
	//@Tag
	
	/*
	@Test
	@Tag("dev")
	public void testA() {
		System.out.println("HELLO-TEST-A");
	}
	@Test
	@Tag("prod")
	public void testB() {
		System.out.println("HELLO-TEST-B");
	}
	@Test
	@Tag("qa")
	public void testC() {
		System.out.println("HELLO-TEST-C");
	}
	@Test
	@Tag("prod")
	public void testD() {
		System.out.println("HELLO-TEST-D");
	}
	*/
}
