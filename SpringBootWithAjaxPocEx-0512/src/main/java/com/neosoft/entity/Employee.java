package com.neosoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "emp_info_ajax")
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter @Builder @ToString
public class Employee {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "id")
		private Integer empId;
		@Column(name = "name")
		private String empName;
		@Column(name = "email")
		private String empEmail;
		@Column(name = "sal")
		private Double empSal;
		@Column(name = "dept")
		private String empDept;
}
