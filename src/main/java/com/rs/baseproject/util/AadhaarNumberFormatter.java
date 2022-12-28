package com.rs.baseproject.util;

import java.text.DecimalFormat; 
import java.text.DecimalFormatSymbols;

public class AadhaarNumberFormatter {

	public static String formatAadhaarNumber(String aadhaarNumber)
	{
			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
	        symbols.setGroupingSeparator('-');
	        String pattern = "####-####";
	        DecimalFormat decimalFormat = new DecimalFormat(pattern , symbols );
	        String number = decimalFormat.format(Double.parseDouble(aadhaarNumber));		
	        return number;
	}
	
}
