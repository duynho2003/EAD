package com.mytech.hellobeans.app;

import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.mytech.hellobean.ejb.SingletonAppBean;
import com.mytech.hellobean.ejb.SingletonAppBeanRemote;
import com.mytech.hellobean.ejb.StatefullBookBean;
import com.mytech.hellobean.ejb.StatefullBookBeanRemote;
import com.mytech.hellobean.ejb.StatelessBookBean;
import com.mytech.hellobean.ejb.StatelessBookBeanRemote;


public class EJBClient1 {

	public StatefullBookBeanRemote statefullBookBean;
	public StatelessBookBeanRemote statelessBookBean;
	public SingletonAppBeanRemote singletonAppBean;
	
	public EJBClient1() {
		System.out.println("EJB Client 1 initialzing... ");
		final Hashtable<String, String> jndiProperties = new Hashtable<String, String>();
		jndiProperties.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProperties.put(Context.PROVIDER_URL, "remote+http://127.0.0.1:8080");
		
		String statelessBookLookup = "ejb:/HelloBeanEJB/StatelessBookBean!com.mytech.hellobean.ejb.StatelessBookBeanRemote";
		String statefullBookLookup = "ejb:/HelloBeanEJB/StatefullBookBean!com.mytech.hellobean.ejb.StatefullBookBeanRemote?stateful";
		String singletonAppLookup = "ejb:/HelloBeanEJB/SingletonAppBean!com.mytech.hellobean.ejb.SingletonAppBeanRemote";
		
		try {
			final Context context = new InitialContext(jndiProperties);
			
			statelessBookBean = (StatelessBookBeanRemote) context.lookup(statelessBookLookup);
			statefullBookBean = (StatefullBookBeanRemote) context.lookup(statefullBookLookup);
			singletonAppBean = (SingletonAppBeanRemote) context.lookup(singletonAppLookup);
			
		} catch (Exception e) {
			System.out.println("EJBClient1: " + e.getLocalizedMessage());
		}
	}

	public void add() {
		statelessBookBean.addBook("WCD LESS");
		statelessBookBean.addBook("EDA LESS");

		statefullBookBean.addBook("WCD FULL");
		statefullBookBean.addBook("EDA FULL");
		
		int count = singletonAppBean.addCounter();
		System.out.println("Counter Client 1: " + count);
	}

	public void print() {
		System.out.println("Client 1");
		List<String> statelessBooks = statelessBookBean.getBooks();
		System.out.println("Client 1:: StatelessBook");
		System.out.println(statelessBooks);
		
		List<String> statefullBooks = statefullBookBean.getBooks();
		System.out.println("Client 1:: StatefullBook");
		System.out.println(statefullBooks);
	}
}
