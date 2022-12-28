package com.rs.baseproject;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.rs.baseproject.constant.GlobalConstants_RequestName;
import com.rs.baseproject.entity.Employee;
import com.rs.baseproject.entity.EmployeeAddress;
import com.rs.baseproject.entity.EmployeeMobileNumber;
import com.rs.baseproject.entity.Projects;
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
	public void getAllEmployeeDetailsTest() throws URISyntaxException
	{
		System.out.println("Test Started....");
		
		String url = GlobalConstants_RequestName.LOCAL_HOST+GlobalConstants_RequestName.GET_ALL_EMPLOYEES_DETAILS;
		URI uri = new URI(url);
		ResponseEntity<EmployeeDto[]> entity = restTemplate.getForEntity(uri,EmployeeDto[].class);
		EmployeeDto[] emp = entity.getBody();
		//Stream.of(emp).forEach(e -> System.out.println(e)); // printing the data 
		Assertions.assertEquals(200, 200);
		System.out.println(entity.getStatusCodeValue());
		
		System.out.println("Test Ended...");
	}

	private static EmployeeDto emp()
	{
		EmployeeAddressDto address = new EmployeeAddressDto();
	//	address.setAddressCode(101);
		address.setPinCode(444001);
		address.setAddress("Deshmukh peth");
		address.setLandMark("XYZ");
		address.setState("Maharashtra");
		address.setStreet("ABC");
		
		EmployeeAddressDto address2 = new EmployeeAddressDto();
	//	address2.setAddressCode(102);
		address2.setPinCode(444002);
		address2.setAddress("Deshmukh peth");
		address2.setLandMark("XYZ");
		address2.setState("Maharashtra");
		address2.setStreet("ABC");
		
		List<EmployeeAddressDto> addressList = new ArrayList<EmployeeAddressDto>();
		addressList.add(address);
		addressList.add(address2);
		
		//-------------------------- Mobile Number -----------------------------
		
		EmployeeMobileNumberDto number = new EmployeeMobileNumberDto();
	//	number.setId(1111L);
		number.setMobileNumber(9673428105L);
		
		EmployeeMobileNumberDto number2 = new EmployeeMobileNumberDto();
	//	number2.setId(2222L);
		number2.setMobileNumber(7767097144L);
		
		List<EmployeeMobileNumberDto> mobileNumber = new ArrayList<EmployeeMobileNumberDto>();
		mobileNumber.add(number);
		mobileNumber.add(number2);
		
		//-------------------------- Projects -----------------------------
		
		ProjectsDto project1 = new ProjectsDto();
		//project1.setProject_Id(202);
		project1.setProject_Name("IBMS");
		
		ProjectsDto project2 = new ProjectsDto();
		//project2.setProject_Id(203);
		project2.setProject_Name("HMS");
		
		List<ProjectsDto> pro = new ArrayList<ProjectsDto>();
		pro.add(project1);
		pro.add(project2);
		
		EmployeeDto empl = new EmployeeDto();
		//empl.setEmployeeId(101);
		empl.setEmployeeEmailId("Rohit@Gmail.com");
		empl.setEmployeeName("Rohit Thakur");
		empl.setEmployeeBloodGroup("AB+");
		empl.setEmployeeAadhaarNumber("444455558888");
		empl.setEmployeeAddress(addressList);
		empl.setEmployeeDateOfBirth("1996-08-08");
		empl.setEmployeeDepartment("Developer");
		empl.setEmployeeProject(pro);
		empl.setEmployeeSalary(70000);
		empl.setEmployeeNumber(mobileNumber);
		empl.setEmployeeStatus("Active");
		empl.setEmployeePanNumber("bqrpt1110k");
		//empl.setEmployeeAge("26");
		empl.setEmployeeHrName("OM");
		//empl.setEmployeeJoiningDate("2022-12-27");
		
		return empl;
		
	}
	
	
	@ParameterizedTest
	@MethodSource("emp")
	public void registerNewEmployeeTest(EmployeeDto dto) throws URISyntaxException
	{
		System.out.println("Test Started....");
		
		String url = "http://localhost:2010/RegisterNewEmployee";
		URI uri = new URI(url);
		
		HttpHeaders headers = new HttpHeaders();
		 
        HttpEntity<EmployeeDto> request = new HttpEntity<>(dto, headers);
		
		ResponseEntity<EmployeeDto> postForEntity = restTemplate.postForEntity(uri, request, EmployeeDto.class);
	//	EmployeeDto emp = entity.getBody();
		//Stream.of(emp).forEach(e -> System.out.println(e)); // printing the data 
		
		Assertions.assertEquals(201, postForEntity.getStatusCodeValue());
		System.out.println(postForEntity.getStatusCodeValue());
		
		System.out.println("Test Ended...");
	}
}
