package com.mytech.employeemgmt.ejb;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class PreferenceBean
 */
@Stateless
@LocalBean
public class PreferenceBean implements PreferenceBeanRemote {

    private int workingStart = 8;
    private int workingEnd = 17;
    
    public PreferenceBean() {
    }

	public int getWorkingStart() {
		return workingStart;
	}

	public void setWorkingStart(int workingStart) {
		this.workingStart = workingStart;
	}

	public int getWorkingEnd() {
		return workingEnd;
	}

	public void setWorkingEnd(int workingEnd) {
		this.workingEnd = workingEnd;
	}
    
    

}
