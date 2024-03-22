package com.mytech.dependency.log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TimeLogger {

	private SimpleDateFormat simpleDateFormat;
	private Calendar calendar;
	
	public TimeLogger() {
		simpleDateFormat = new SimpleDateFormat();
		calendar = Calendar.getInstance();
	}
	
	public TimeLogger(SimpleDateFormat simpleDateFormat, Calendar calendar) {
		this.calendar = calendar;
		this.simpleDateFormat = simpleDateFormat;
	}
	
	public String getTime() {
		return simpleDateFormat.format(calendar.getTime());
	}
}
