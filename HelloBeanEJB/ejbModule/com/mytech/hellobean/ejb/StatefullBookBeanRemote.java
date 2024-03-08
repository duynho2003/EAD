package com.mytech.hellobean.ejb;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface StatefullBookBeanRemote {
	void addBook(String name);
	List<String> getBooks();
}
