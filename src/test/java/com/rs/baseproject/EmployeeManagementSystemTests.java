package com.rs.baseproject;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rs.baseproject.constant.GlobalConstants_RequestName;
import com.rs.baseproject.payloads.EmployeeAddressDto;
import com.rs.baseproject.payloads.EmployeeDto;
import com.rs.baseproject.payloads.EmployeeMobileNumberDto;
import com.rs.baseproject.payloads.ProjectsDto;

@SpringBootTest
class EmployeeManagementSystemTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	public void getAllEmployeeDetailsTest() throws URISyntaxException {
		System.out.println("Test Started....");

		String url = GlobalConstants_RequestName.LOCAL_HOST + GlobalConstants_RequestName.GET_ALL_EMPLOYEES_DETAILS;
		URI uri = new URI(url);
		ResponseEntity<EmployeeDto[]> entity = restTemplate.getForEntity(uri, EmployeeDto[].class);
		EmployeeDto[] emp = entity.getBody();
		Assertions.assertEquals(200, 200);
		System.out.println(entity.getStatusCodeValue());

		System.out.println("Test Ended...");
	}

	@Test
	public void Test_registerNewEmployee() throws URISyntaxException {
		System.out.println("Test Started Register Employee....");

		String url = GlobalConstants_RequestName.LOCAL_HOST + GlobalConstants_RequestName.REGISTER_NEW_EMPLOYEE;
		URI uri = new URI(url);

		ProjectsDto projects1 = new ProjectsDto(null, "Ramayan");
		ProjectsDto projects2 = new ProjectsDto(null, "Mahabharat");
		List<ProjectsDto> projectList = new ArrayList<ProjectsDto>();
		projectList.add(projects1);
		projectList.add(projects2);

		EmployeeAddressDto address1 = new EmployeeAddressDto(null, "Ram", 444001, "Kishkinta");
		List<EmployeeAddressDto> addressList = new ArrayList<EmployeeAddressDto>();
		addressList.add(address1);

		EmployeeMobileNumberDto number = new EmployeeMobileNumberDto(null, 1234567890L);
		List<EmployeeMobileNumberDto> list = new ArrayList<EmployeeMobileNumberDto>();
		list.add(number);

		EmployeeDto employee = new EmployeeDto(null, "Pavan Putra Hanuman", "Active", "Manager", "hanuman@gmail.com",
				700000, "Om", null, "Ram", "123412341234", "Bqrpt1110l", "1996-08-08", null, projectList, addressList,
				list);
		ResponseEntity<EmployeeDto> result = this.restTemplate.postForEntity(uri, employee, EmployeeDto.class);

		assertEquals(201, result.getStatusCodeValue());

		System.out.println("Test Ended Register Employee.....");
	}

}