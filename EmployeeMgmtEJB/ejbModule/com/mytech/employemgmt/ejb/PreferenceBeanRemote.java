package com.mytech.employemgmt.ejb;

import jakarta.ejb.Remote;

@Remote
public interface PreferenceBeanRemote {
	public int getWorkingStart();
	int getWorkingEnd();
}
