package com.mytech.uppercase.ejb;

import jakarta.ejb.Remote;

@Remote
public interface UpperCaseBeanRemote {

	String transformToUpperCase(String message);
}
