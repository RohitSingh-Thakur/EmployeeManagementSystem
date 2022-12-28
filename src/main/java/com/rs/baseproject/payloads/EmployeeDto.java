package com.rs.baseproject.payloads;

import java.util.List; 

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import lombok.Data;


@Data
public class EmployeeDto {

	private Integer employeeId;
	
	@NotEmpty
	@Size(min = 4, message = "User Name Must Be Equal To Or Greater Than 4 Charachters")
	private String employeeName;
	
	@NotEmpty(message = "Please Enter Status" )
	@Size(min = 6, max = 8 ,message = "Status Must Be Must Be Equal To 6 like 'active' and Less Than 8 like 'inactive' Charachters")
	private String employeeStatus = "inactive";
	
	@NotEmpty(message = "Please Enter Department")
	@Size(min = 2, max = 20 ,message = "Department Must Be Equal To 2 Charachters And Less Than 20 Charachters")
	private String employeeDepartment;
	
	@Email(message = "Please fill Valid Email")
	private String employeeEmailId;
	
	private long employeeSalary;
	
	@NotEmpty(message = "Please Enter BloodGroup")
	@Size(min = 2, max = 3)
	private String employeeBloodGroup;
	
	private String employeeJoiningDate;
	
	@NotEmpty(message = "Please Enter Your HR Name")
	private String employeeHrName;
	
	@NotEmpty(message = "Please Enter AadhaarNumber")
	@Size(min = 12, max = 20)
	private String employeeAadhaarNumber;
	
	@NotEmpty(message = "Please Enter PanNumber")
	@Size(min = 10, max = 20)
	private String employeePanNumber;
	
	@NotEmpty(message = "Please Enter DateOfBirth")
	@Size(min = 10, max = 10)
	private String employeeDateOfBirth;
	
	private String employeeAge;
	
	private List<ProjectsDto> employeeProject;
	
	private List<EmployeeAddressDto> employeeAddress;
	
	private List<EmployeeMobileNumberDto> employeeNumber;

}
