package com.rs.baseproject.ModelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.baseproject.entity.Employee;
import com.rs.baseproject.payloads.EmployeeDto;

@Component
public class EmployeeToEmployeeModel {
	
	@Autowired
	private ModelMapper mapper;
	
	/*
	 * public static EmployeeModel employeeToEmployeeModel(Employee employee) {
	 * EmployeeModel model = new EmployeeModel();
	 * model.setEmployeeId(employee.getEmployeeId());
	 * model.setEmployeeName(employee.getEmployeeName());
	 * model.setEmployeeStatus(employee.getEmployeeStatus());
	 * model.setEmployeeDepartment(employee.getEmployeeDepartment());
	 * model.setEmployeeSalary(employee.getEmployeeSalary());
	 * model.setEmployeeBloodGroup(employee.getEmployeeBloodGroup());
	 * model.setEmployeeJoiningDate(employee.getEmployeeJoiningDate());
	 * model.setEmployeeHrName(employee.getEmployeeHrName());
	 * model.setEmployeeAadhaarNumber(employee.getEmployeeAadhaarNumber());
	 * model.setEmployeePanNumber(employee.getEmployeePanNumber());
	 * model.setEmployeeDateOfBirth(employee.getEmployeeDateOfBirth());
	 * model.setEmployeeAge(employee.getEmployeeAge());
	 * 
	 * model.setEmployeeProject(employee.getEmployeeProject());
	 * model.setEmployeeAddress(employee.getEmployeeAddress());
	 * model.setEmployeeNumber(employee.getEmployeeNumber());
	 * 
	 * return model; 
	 * } This logic is done by ModelMapper Library
	 */
	/*
	 * public EmployeeDto employeeToEmployeeModel(Employee employee) { EmployeeDto
	 * employeeModel = this.mapper.map(employee, EmployeeDto.class); return
	 * employeeModel; }
	 */
}
