package com.mytech.shopmgmt.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mytech.shopmgmt.ejb.entities.Book;
import com.mytech.shopmgmt.ejb.facades.BookFacadeRemote;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("shopMgmtBean")
@SessionScoped
public class ShopMgmtBean implements Serializable {

	private static final long serialVersionUID = -4904541246430821656L;
	
	private List<Book> books;
	
	@EJB
	private BookFacadeRemote bookFacade;
	
	public ShopMgmtBean() {
		books = new ArrayList<Book>();
	}

	@PostConstruct
	public void initialze() {
		books = bookFacade.findAll();
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	
}
