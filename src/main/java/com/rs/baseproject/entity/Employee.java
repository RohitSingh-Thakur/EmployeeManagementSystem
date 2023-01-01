package com.rs.baseproject.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer employeeId;
	private String employeeName;
	private String employeeStatus = "Inactive";
	private String employeeDepartment;
	private String employeeEmailId;
	private long employeeSalary;
	private String employeeBloodGroup;
	private String employeeJoiningDate;
	private String employeeHrName;
	private String employeeAadhaarNumber;
	private String employeePanNumber;
	private String employeeDateOfBirth;
	private String employeeAge;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Employee_Id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Projects> employeeProject;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "EMP_ID")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<EmployeeAddress> employeeAddress;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Employee_Id")
	@Fetch(value = FetchMode.SUBSELECT)
	private List<EmployeeMobileNumber> employeeNumber;

}
