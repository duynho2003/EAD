package com.mytech.hellobean.ejb;



import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;

import java.util.ArrayList;
import java.util.List;

@Stateful
@LocalBean
public class StatefullBookBean implements StatefullBookBeanRemote {

    private List<String> listBooks = null;
    public StatefullBookBean() {
    	listBooks = new ArrayList<String>();
    }
	@Override
	public void addBook(String name) {
		System.out.println("addbook:"+name);
		listBooks.add(name); 
		
	}
	@Override
	public List<String> getBooks() {
		System.out.println("getBooks:"+listBooks.size());		
		return listBooks;
	}

}
