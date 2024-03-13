package com.mytech.shopmgmt.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mytech.shopmgmt.ejb.entities.Book;
import com.mytech.shopmgmt.ejb.entities.Category;
import com.mytech.shopmgmt.ejb.facades.BookFacadeRemote;
import com.mytech.shopmgmt.ejb.facades.CategoryFacade;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("shopMgmtBean")
@SessionScoped
public class ShopMgmtBean implements Serializable {

	private static final long serialVersionUID = -4904541246430821656L;
	
	private List<Book> books;
	private List<Category> categories;
	
	private Book book;
	private long categoryId;
	
	@EJB
	private BookFacadeRemote bookFacade;
	
	@EJB
	private CategoryFacade categoryFacade;
	
	public ShopMgmtBean() {
		books = new ArrayList<Book>();
	}

	@PostConstruct
	public void initialze() {
		books = bookFacade.findAll();
		categories = categoryFacade.findAll();
	}
	
	//
	public String displayCreateBook() {
		book = new Book();
		
		return "add_book";
	}
	
	public String performCreateBook() {
		//Need refactor to fix issue
		Category category = categoryFacade.find(categoryId);
		book.setCategory(category);
		bookFacade.create(book);
		
		//
		books = bookFacade.findAll();
		return "books";
	}
	
	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}
	
	
}
