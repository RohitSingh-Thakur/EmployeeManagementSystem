package com.rs.baseproject.payloads;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeAddressDto {

	private Integer addressCode;
	private String state;
	private Integer pinCode;
	private String address;
}
