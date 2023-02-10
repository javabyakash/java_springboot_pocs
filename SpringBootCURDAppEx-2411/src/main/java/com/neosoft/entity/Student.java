package com.neosoft.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "student_tab")
@NoArgsConstructor
@AllArgsConstructor
@Setter @Getter @ToString @Builder
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer studId;
	@Column(name = "name")
	private String studName;
	@Column(name = "address")
	private String studAddrs;
	@Column(name = "fees")
	private Double studFees;
	@Column(name = "mobile")
	private Long studMobile;
}
