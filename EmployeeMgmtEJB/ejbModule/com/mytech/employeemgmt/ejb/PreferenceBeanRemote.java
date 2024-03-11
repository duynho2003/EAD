package com.mytech.employeemgmt.ejb;

import jakarta.ejb.Remote;

@Remote
public interface PreferenceBeanRemote {
	public int getWorkingStart();
	int getWorkingEnd();
}
