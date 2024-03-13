package com.mytech.shopmgmt.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mytech.shopmgmt.ejb.entities.Book;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named(value = "shopMgmtBean")
@SessionScoped
public class ShopMgmtBean implements Serializable {

	private static final long serialVersionUID = -686172580582109616L;
	private List<Book> books;

	public ShopMgmtBean() {
		books = new ArrayList<Book>();
	}

	public List<Book> getBooks() {
		return books;
	}
}
