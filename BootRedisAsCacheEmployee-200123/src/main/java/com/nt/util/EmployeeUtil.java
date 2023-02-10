package com.nt.util;

import com.nt.model.Employee;

public class EmployeeUtil {
	
	private EmployeeUtil() {

	}
	
	public static Employee setNonNullValues(Employee reqEmp,Employee dbEmp) {
		if(reqEmp.getEmpName()!=null)
			dbEmp.setEmpName(reqEmp.getEmpName());
		if(reqEmp.getEmpDesg()!=null)
			dbEmp.setEmpDesg(reqEmp.getEmpDesg());
		if(reqEmp.getEmpSal()!=null)
			dbEmp.setEmpSal(reqEmp.getEmpSal());
		return dbEmp;
	}
}
