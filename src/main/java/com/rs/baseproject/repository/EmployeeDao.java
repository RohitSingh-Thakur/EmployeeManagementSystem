package com.rs.baseproject.repository;

import java.util.List;
import java.util.Map;

import com.rs.baseproject.entity.Employee;

public interface EmployeeDao {
	public Employee registerNewEmployee(Employee employee);

	public List<Employee> getAllEmployeeDetails();

	public Employee searchEmployee(Integer employeeId);

	public Employee updateEmployeeByID(Integer employeeId, Map<String, Object> fields);

	public Employee deleteEmployeeById(Integer employeeId);

	public Employee searchEmployeeByName(String employeeName);

	public List<Employee> searchEmployeeByDepartment(String employeeDepartment);
}
