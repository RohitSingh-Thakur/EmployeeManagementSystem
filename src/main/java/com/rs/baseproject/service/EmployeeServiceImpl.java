package com.rs.baseproject.service;

import static com.rs.baseproject.util.AgeCalculator.getAge;
import static com.rs.baseproject.util.PanNumberFormatter.formatPanNumber;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rs.baseproject.custom.exception.NoRecordFoundException;
import com.rs.baseproject.custom.exception.NoRecordFoundForGivenIdException;
import com.rs.baseproject.entity.Employee;
import com.rs.baseproject.payloads.EmployeeDto;
import com.rs.baseproject.repository.EmployeeDao;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public EmployeeDto registerNewEmployee(EmployeeDto employeeDto) {

		Employee employee = this.mapper.map(employeeDto, Employee.class);

		employee.setEmployeeJoiningDate(new SimpleDateFormat("yyyyMMdd").format(new Date()));
		employee.setEmployeeAge(getAge(employee.getEmployeeDateOfBirth()));
		employee.setEmployeePanNumber(formatPanNumber(employee.getEmployeePanNumber()));

		Employee newEmployee = employeeDao.registerNewEmployee(employee);

		EmployeeDto empModel = this.mapper.map(newEmployee, EmployeeDto.class);

		return empModel;

	}

	@Override
	public List<EmployeeDto> getAllEmployeeDetails() {

		List<Employee> allEmployeeDetails = employeeDao.getAllEmployeeDetails();

		List<EmployeeDto> collect = allEmployeeDetails.stream().map(e -> this.mapper.map(e, EmployeeDto.class))
				.collect(Collectors.toList());
		if (collect.isEmpty() == false) {
			return collect;
		} else {
			throw new NoRecordFoundException();
		}
	}

	@Override
	public EmployeeDto searchEmployee(Integer employeeId) {
		Employee searchedEmployee = employeeDao.searchEmployee(employeeId);

		if (searchedEmployee != null) {
			return this.mapper.map(searchedEmployee, EmployeeDto.class);
		} else {
			throw new NoRecordFoundForGivenIdException(employeeId);
		}
	}

	@Override
	public EmployeeDto updateEmployeeByID(Integer employeeId, Map<String, Object> fields) {
		Employee updateEmployeeByID = employeeDao.updateEmployeeByID(employeeId, fields);
		if (updateEmployeeByID != null) {
			return this.mapper.map(updateEmployeeByID, EmployeeDto.class);
		} else {
			throw new NoRecordFoundForGivenIdException(employeeId);
		}
	}

	@Override
	public EmployeeDto deleteEmployeeById(Integer employeeId) {
		Employee emp = employeeDao.deleteEmployeeById(employeeId);
		if (emp != null) {
			return this.mapper.map(emp, EmployeeDto.class);
		} else {
			throw new NoRecordFoundForGivenIdException(employeeId);
		}
	}

	@Override
	public EmployeeDto searchEmployeeByName(String employeeName) {
		Employee searchedEmployee = employeeDao.searchEmployeeByName(employeeName);
		if (searchedEmployee != null) {
			return this.mapper.map(searchedEmployee, EmployeeDto.class);
		} else {
			throw new NoRecordFoundException();
		}
	}

	@Override
	public List<EmployeeDto> searchEmployeeByDepartment(String employeeDepartment) {
		List<Employee> listOfEmployees = employeeDao.searchEmployeeByDepartment(employeeDepartment);
		if (listOfEmployees != null) {

			return listOfEmployees.stream().map(listOfEmployee -> mapper.map(listOfEmployee, EmployeeDto.class))
					.collect(Collectors.toList());

		} else {
			throw new NoRecordFoundException();
		}
	}

}
