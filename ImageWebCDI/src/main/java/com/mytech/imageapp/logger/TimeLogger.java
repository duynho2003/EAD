package com.mytech.imageapp.logger;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.SessionScoped;
@ApplicationScoped
public class TimeLogger implements Serializable {

	private static final long serialVersionUID = -1324786002273472820L;
	private SimpleDateFormat simpleDateFormat;
	private Calendar calendar;
	
	public TimeLogger() {
		simpleDateFormat = new SimpleDateFormat();
		calendar = Calendar.getInstance();
	}
	
	public TimeLogger (SimpleDateFormat simpleDateFormat, Calendar calendar) {
		this.calendar = calendar;
		this.simpleDateFormat = simpleDateFormat;
	}
	
	public String getTime() {
		return simpleDateFormat.format(calendar.getTime());
	}
}
