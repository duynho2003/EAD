package com.mytech.employeemgmt.web;

import java.io.Serializable;

import com.mytech.employemgmt.ejb.PreferenceBean;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("employeeBean")
@SessionScoped
public class EmployeeManagedBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@EJB
	private PreferenceBean preferenceBean;
	
	public int getTimeToWork() {
		return preferenceBean.getWorkingStart();
	}
	
	public int getTimeToLeave() {
		return preferenceBean.getWorkingEnd();
	}

}
