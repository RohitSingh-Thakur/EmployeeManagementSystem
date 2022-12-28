package com.rs.baseproject.entity;


import javax.persistence.Entity; 
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data

public class Projects {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer project_Id;
	private String project_Name;

}
