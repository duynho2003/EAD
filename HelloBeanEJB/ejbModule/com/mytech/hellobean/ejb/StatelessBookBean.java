package com.mytech.hellobean.ejb;

import java.util.ArrayList;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

/**
 * Session Bean implementation class StatelessBookBean
 */
@Stateless
@LocalBean
public class StatelessBookBean implements StatelessBookBeanRemote {

	private java.util.List<String> listBooks = null;
    public StatelessBookBean() {
    	listBooks = new ArrayList<String>();
    	System.out.println("StatelessBookBean constructor:" +hashCode());
    }
	@Override
	public void addBook(String name) {
		System.out.println("StatelessBookBean:addBooks:"+name);
		listBooks.add(name); 
		
	}
	@Override
	public java.util.List<String> getBooks() {
		System.out.println("StatelessBookBean:getBooks:"+listBooks.size());
		
		return listBooks;
	}

}
