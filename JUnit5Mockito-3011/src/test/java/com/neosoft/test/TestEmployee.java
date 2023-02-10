package com.neosoft.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.neosoft.service.Employee;
import com.neosoft.service.IHikeService;

public class TestEmployee {

	@Mock
	private IHikeService hikeService;

	private Employee emp;
	private String code;
	private Double retVal,hikePer,finalExpVal;

	@BeforeEach
	public void setupCode() {
		MockitoAnnotations.initMocks(this);
		code = "DEV";
		retVal = 5000.0;
		hikePer=10.0;
		finalExpVal=500.0;
	}

	@Test
	void testFinalHikeByDesg() {
		when(hikeService.employeeHikeByDesg(code)).thenReturn(retVal);
		assertEquals(retVal, hikeService.employeeHikeByDesg(code), "May be value not matching!");
		emp = new Employee(hikeService);
		Double hikeByDesg = emp.finalHikeByDesg(code, hikePer);
		assertEquals(finalExpVal, hikeByDesg, "May be hike not same!");
	}
}
