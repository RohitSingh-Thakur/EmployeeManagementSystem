package com.rs.baseproject.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.rs.baseproject.entity.Employee;
import com.rs.baseproject.payloads.EmployeeDto;
import com.rs.baseproject.repository.EmployeeDao;

@Component
public class EmployeeCache {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private ModelMapper mapper;
	
	public static Map<Integer, EmployeeDto> cache = new HashMap<Integer, EmployeeDto>();
	
	@Scheduled(cron = "*/10 * * * * *")
	public void loadCache()
	{
		System.out.println("Cache Loading Started.....");
		
		List<Employee> listOfEmployees = employeeDao.getAllEmployeeDetails();
		List<EmployeeDto> collect = listOfEmployees.stream().map(e -> mapper.map(e, EmployeeDto.class)).collect(Collectors.toList());
		collect.forEach(employee -> cache.put(employee.getEmployeeId(), employee));
				
		System.out.println("Cache Loading Ended.....");
		
	}

}
