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
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data

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
