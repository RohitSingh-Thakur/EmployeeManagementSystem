package com.rs.baseproject.service;

import java.util.List;
import java.util.Map;

import com.rs.baseproject.payloads.EmployeeDto;

public interface EmployeeService 
{
	public EmployeeDto registerNewEmployee(EmployeeDto employeeDto);

	public List<EmployeeDto> getAllEmployeeDetails();
	
	public EmployeeDto searchEmployee(Integer employeeId);
	
	public EmployeeDto updateEmployeeByID(Integer employeeId, Map<String, Object> fields);
	
	public EmployeeDto deleteEmployeeById(Integer employeeId);
	
	public EmployeeDto searchEmployeeByName(String employeeName);
	
	public List<EmployeeDto> searchEmployeeByDepartment(String employeeDepartment);
}
