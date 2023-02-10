package com.neosoft.service;

public class Employee {
	
	private IHikeService hikeService;
	
	public Employee(IHikeService hikeService) {
		this.hikeService=hikeService;
	}
	
	public Double finalHikeByDesg(String code, Double hikePer) {
		return hikeService.employeeHikeByDesg(code)*hikePer/100.0;
	}
}
