package com.rs.baseproject.util;

public class PanNumberFormatter 
{
	public static String formatPanNumber(String panNumber) 
	{
		if(panNumber != null)
		{
			return panNumber.trim().replaceAll("\\s", "").toUpperCase();
		}else {
		return null;
		}
	}
}
