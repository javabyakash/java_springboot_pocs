package com.nt.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer empId;
	private String empName;
	private String empDesg;
	private Double empSal;
}
