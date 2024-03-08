package com.mytech.hellobean.ejb;

import jakarta.ejb.Remote;

@Remote
public interface SingletonAppBeanRemote {
	int addCounter();
}
