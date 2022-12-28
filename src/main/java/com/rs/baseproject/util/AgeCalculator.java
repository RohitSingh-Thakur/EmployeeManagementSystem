package com.rs.baseproject.util;

import java.time.LocalDate; 
import java.time.Period;

public class AgeCalculator 
{
	public static String getAge(String age)
	{
		LocalDate dob = LocalDate.parse(age);
		LocalDate curDate = LocalDate.now(); 
		if ((dob != null) && (curDate != null))   
		{  
		return String.valueOf(Period.between(dob, curDate).getYears());  
		}  
		else  
		{  
		return null;  
		}  
		
	}
}
