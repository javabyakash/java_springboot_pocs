package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
	private Integer studId;
	private String studName;
	private String studBranch;
	private Integer mark1,mark2,mark3;
	private Double percentage;
	private String grade;
}
