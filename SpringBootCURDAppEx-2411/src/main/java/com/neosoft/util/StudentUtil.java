package com.neosoft.util;

import com.neosoft.entity.Student;

public interface StudentUtil {
	
	//Java8 static method
	public static void copyNonNullValues(Student dbStud,Student reqStud) {
		if(reqStud.getStudName()!=null)
			dbStud.setStudName(reqStud.getStudName());
		if(reqStud.getStudAddrs()!=null)
			dbStud.setStudAddrs(reqStud.getStudAddrs());
		if(reqStud.getStudFees()!=null)
			dbStud.setStudFees(reqStud.getStudFees());
		if(reqStud.getStudMobile()!=null)
			dbStud.setStudMobile(reqStud.getStudMobile());
	}
}
