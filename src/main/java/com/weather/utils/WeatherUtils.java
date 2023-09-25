package com.weather.utils;

import java.sql.Timestamp;

public class WeatherUtils {
	
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		long factor = (long) Math.pow(10, places);
		value = value * factor;
		long tmp = Math.round(value);
		return (double) tmp / factor;
	}
	
	public static Timestamp getCurrenttime() {
		java.util.Date utilDate = new java.util.Date();
		Timestamp sqlTimestamp = new Timestamp(utilDate.getTime());
		return sqlTimestamp;
	}

}
