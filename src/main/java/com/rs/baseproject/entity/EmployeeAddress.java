package com.rs.baseproject.entity;


import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data

public class EmployeeAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addressCode;

	private String street;
	private String state;
	private String landMark;
	private Integer pinCode;
	private String address;


}
