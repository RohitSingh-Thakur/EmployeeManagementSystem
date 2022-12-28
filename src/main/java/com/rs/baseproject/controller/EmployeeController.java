package com.rs.baseproject.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rs.baseproject.constant.GlobalConstants_Messages;
import com.rs.baseproject.constant.GlobalConstants_RequestName;
import com.rs.baseproject.payloads.EmployeeDto;
import com.rs.baseproject.service.EmployeeService;
import com.rs.baseproject.util.EmployeeCache;

@RestController
public class EmployeeController {

	static Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(GlobalConstants_RequestName.WELCOME)
	public String welcomeService(@PathVariable String name) {

		/*
		 * Good morning (12am-12pm) Good after noon (12pm -4pm) Good evening (4pm to
		 * 9pm) Good night ( 9pm to 6am)
		 */

		Calendar c = Calendar.getInstance();
		int timeOfDay = c.get(Calendar.HOUR_OF_DAY);

		if (timeOfDay >= 0 & timeOfDay < 12) {
			return GlobalConstants_Messages.GOOD_MORNING + name
					+ GlobalConstants_Messages.WELCOME_TO_EMPLOYEE_MANAGEMENT_SYSTEM;
		}

		else if (timeOfDay >= 12 & timeOfDay < 16) {
			return GlobalConstants_Messages.GOOD_AFTERNOON + name
					+ GlobalConstants_Messages.WELCOME_TO_EMPLOYEE_MANAGEMENT_SYSTEM;
		}

		else if (timeOfDay >= 16 & timeOfDay < 21) {
			return GlobalConstants_Messages.GOOD_EVENING + name
					+ GlobalConstants_Messages.WELCOME_TO_EMPLOYEE_MANAGEMENT_SYSTEM;
		}

		else if (timeOfDay >= 21 & timeOfDay < 24) {
			return GlobalConstants_Messages.GOOD_NIGHT + name
					+ GlobalConstants_Messages.WELCOME_TO_EMPLOYEE_MANAGEMENT_SYSTEM;
		}

		return GlobalConstants_Messages.WELCOME;
	}

	
	// TestCase 
	@PostMapping(GlobalConstants_RequestName.REGISTER_NEW_EMPLOYEE)
	public ResponseEntity<EmployeeDto> registerNewEmployee(@Valid @RequestBody EmployeeDto employeeDto) {

		EmployeeDto registeredEmployee = employeeService.registerNewEmployee(employeeDto);

		if (registeredEmployee != null) {
			return new ResponseEntity<EmployeeDto>(registeredEmployee, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<EmployeeDto>(HttpStatus.NO_CONTENT);
		}

	}

	// test Case Complete + Cache
	@GetMapping(GlobalConstants_RequestName.GET_ALL_EMPLOYEES_DETAILS)
	public ResponseEntity<List<EmployeeDto>> getAllEmployeeDetails() {
		if (EmployeeCache.cache.isEmpty()) {
			List<EmployeeDto> allEmployeeDetails = employeeService.getAllEmployeeDetails();
			if (allEmployeeDetails.isEmpty() == false) {
				System.out.println("In DB code");
				return new ResponseEntity<List<EmployeeDto>>(allEmployeeDetails, HttpStatus.OK);
			} else {
				return new ResponseEntity<List<EmployeeDto>>(HttpStatus.NO_CONTENT);
			}
		} else {
			System.out.println("In cache code");
			return new ResponseEntity<List<EmployeeDto>>(EmployeeCache.cache.values().stream().toList(), HttpStatus.OK);
		}

	}

	@GetMapping(GlobalConstants_RequestName.SEARCH_EMPLOYEE_BY_EMPLOYEE_ID)
	public ResponseEntity<EmployeeDto> searchEmployee(@PathVariable Integer employeeId) {
		EmployeeDto searchedEmployee = employeeService.searchEmployee(employeeId);
		if (searchedEmployee != null) {
			return new ResponseEntity<EmployeeDto>(searchedEmployee, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);

		}
	}

	@PatchMapping(GlobalConstants_RequestName.UPDATE_EMPLOYEE_BY_EMPLOYEE_ID)
	public ResponseEntity<EmployeeDto> updateEmployeeByID(@PathVariable Integer employeeId,
			@RequestBody Map<String, Object> fields) {
		EmployeeDto updateEmployeeByID = employeeService.updateEmployeeByID(employeeId, fields);
		if (updateEmployeeByID != null) {
			return new ResponseEntity<EmployeeDto>(updateEmployeeByID, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping(GlobalConstants_RequestName.DELETE_EMPLOYEE_BY_EMPLOYEE_ID)
	public ResponseEntity<EmployeeDto> deleteEmployeeById(@PathVariable Integer employeeId) {
		EmployeeDto emp = employeeService.deleteEmployeeById(employeeId);
		if (emp != null) {
			return new ResponseEntity<EmployeeDto>(emp, HttpStatus.OK);
		} else {
			return new ResponseEntity<EmployeeDto>(HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(GlobalConstants_RequestName.SEARCH_EMPLOYEE_BY_NAME)
	public ResponseEntity<EmployeeDto> searchEmployeeByName(@PathVariable String employeeName) {
		EmployeeDto empDetails = employeeService.searchEmployeeByName(employeeName);
		if (empDetails != null) {
			return new ResponseEntity<EmployeeDto>(empDetails, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(GlobalConstants_RequestName.SEARCH_EMPLOYEE_BY_DEPARTMENT)
	public ResponseEntity<List<EmployeeDto>> searchEmployeeByDepartment(@PathVariable String employeeDepartment) {
		List<EmployeeDto> listOfEmployees = employeeService.searchEmployeeByDepartment(employeeDepartment);
		if (listOfEmployees != null) {
			return new ResponseEntity<List<EmployeeDto>>(listOfEmployees, HttpStatus.FOUND);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

}
