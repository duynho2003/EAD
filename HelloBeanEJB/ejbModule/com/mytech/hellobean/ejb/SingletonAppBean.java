package com.mytech.hellobean.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Singleton;
                                             
@Singleton
@LocalBean
public class SingletonAppBean implements SingletonAppBeanRemote, SingletonAppBeanLocal {

	private int appCounter =0;
    public SingletonAppBean() {
        System.out.println("SingletonAppBean:" +hashCode());
    }

    @Override
    public int addCounter() {
		appCounter++;
		System.out.println("SingletonAppBean:" + appCounter);
		return appCounter;
	}
    
    public int getCounter() {
    	return appCounter;
    }
    
    public void resetCounter() {
    	appCounter =0;
    }
    
    @PostConstruct
    public void applicationStartup() {
    	System.out.println("applicationStartup");
    	resetCounter();
    }
    
    @PreDestroy
    public void applicationShutdown() {
    	System.out.println("applicationShutdown");
    }
}
