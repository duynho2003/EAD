package com.mytech.imageapp.logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;

@ApplicationScoped
public class TimeLoggerFactory {
	@TimerLoggerQualifier
	@Produces
	public TimeLogger getTimeLogger() {
		return new TimeLogger(new SimpleDateFormat("HH:mm"), Calendar.getInstance());
	}
}
