package com.mytech.shopmgmt.ejb.facades;

import java.util.List;

import com.mytech.shopmgmt.ejb.entities.Book;

import jakarta.ejb.Remote;

@Remote
public interface BookFacadeRemote {
	public void create(Book book);
	public void update(Book book);
	public void remove(Book book);
	public Book find(Object id);
	public List<Book> findAll();
	public List<Book> findByName(String name);
	public List<Book> findByPrice(double min, double max);
}
