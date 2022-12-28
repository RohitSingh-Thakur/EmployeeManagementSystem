package com.rs.baseproject.payloads;

import lombok.Data;


@Data
public class EmployeeAddressDto {


	private Integer addressCode;
	private String street;
	private String state;
	private String landMark;
	private Integer pinCode;
	private String address;

}
