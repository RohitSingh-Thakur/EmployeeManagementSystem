package com.rs.baseproject.ModelMapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rs.baseproject.entity.Employee;
import com.rs.baseproject.payloads.EmployeeDto;

@Component
public class EmployeeModelToEmployee {
	
	@Autowired
	private ModelMapper mapper;

	
	/*
	 * public static Employee employeeModelToemployee(EmployeeModel employeeModel) {
	 * Employee employee = new Employee();
	 * employee.setEmployeeId(employeeModel.getEmployeeId());
	 * employee.setEmployeeName(employeeModel.getEmployeeName());
	 * employee.setEmployeeStatus(employeeModel.getEmployeeStatus());
	 * employee.setEmployeeDepartment(employeeModel.getEmployeeDepartment());
	 * employee.setEmployeeSalary(employeeModel.getEmployeeSalary());
	 * employee.setEmployeeBloodGroup(employeeModel.getEmployeeBloodGroup());
	 * employee.setEmployeeJoiningDate(employeeModel.getEmployeeJoiningDate());
	 * employee.setEmployeeHrName(employeeModel.getEmployeeHrName());
	 * employee.setEmployeeAadhaarNumber(employeeModel.getEmployeeAadhaarNumber());
	 * employee.setEmployeePanNumber(employeeModel.getEmployeePanNumber());
	 * employee.setEmployeeDateOfBirth(employeeModel.getEmployeeDateOfBirth());
	 * employee.setEmployeeAge(employeeModel.getEmployeeAge());
	 * 
	 * employee.setEmployeeProject(employeeModel.getEmployeeProject());
	 * employee.setEmployeeAddress(employeeModel.getEmployeeAddress());
	 * employee.setEmployeeNumber(employeeModel.getEmployeeNumber());
	 * 
	 * return employee;
	 * This logic is done by ModelMapper Library
	 * }
	 */
	
	/*
	 * public Employee employeeModelToemployee(EmployeeDto employeeModel) {
	 * 
	 * Employee employee = this.mapper.map(employeeModel, Employee.class); return
	 * employee; }
	 */
}
