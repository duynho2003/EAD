package com.mytech.shopmgmt.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.mytech.shopmgmt.ejb.beans.CartBean;
import com.mytech.shopmgmt.ejb.entities.Book;
import com.mytech.shopmgmt.ejb.entities.Category;
import com.mytech.shopmgmt.ejb.entities.Customer;
import com.mytech.shopmgmt.ejb.facades.BookFacadeRemote;
import com.mytech.shopmgmt.ejb.facades.CategoryFacade;
import com.mytech.shopmgmt.ejb.facades.CustomerFacade;

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
	private List<Customer> customers;

	private Customer customer;
	private Book book;
	private long categoryId;

	// Search
	private String name;
	private double minPrice;
	private double maxPrice;

	//Checkout
	private String customerId;
	private Map<Long, Boolean> checkedBooks = new HashMap<Long, Boolean>();
	private String checkedOutMessage;
	
	@EJB
	private BookFacadeRemote bookFacade;

	@EJB
	private CategoryFacade categoryFacade;

	@EJB
	private CustomerFacade customerFacade;

	@EJB
	private CartBean cartBean;
	
	public ShopMgmtBean() {
		books = new ArrayList<Book>();
	}

	@PostConstruct
	public void initialze() {
		books = bookFacade.findAll();
		categories = categoryFacade.findAll();
		customers = customerFacade.findAll();
	}
	
	//Checkout
	public String checkOut() {
		Set<Long> bookIds = checkedBooks.keySet();
		for (Long id : bookIds) {
			Boolean value = checkedBooks.get(id);
			if (value) {
				//Add book to cart
				System.out.println("Book id to add:" + id);
				Book book = bookFacade.find(id);
				cartBean.addItem(book);
				
				checkedOutMessage = "Checked Out";
			}
		}
		Customer customer = customerFacade.find(customerId);
		checkedOutMessage = cartBean.checkout(customer);
		
		return "checkout";
	}

	// Search
	public String findByName() {
		books = bookFacade.findByName(name);
		return "books";
	}

	public String findByPrice() {
		books = bookFacade.findByPrice(minPrice, maxPrice);
		return "books";
	}

	// Add customer
	public String displayCreateCustomer() {
		customer = new Customer();

		return "add_customer";
	}

	public String performCreateCustomer() {
		customerFacade.create(customer);
		customers = customerFacade.findAll();
		return "customers";
	}

	// Add book
	public String displayCreateBook() {
		book = new Book();

		return "add_book";
	}

	public String performCreateBook() {
		// Need refactor to fix issue.
		Category category = categoryFacade.find(categoryId);
		book.setCategory(category);
		bookFacade.create(book);
		//
		books = bookFacade.findAll();
		return "books";
	}

	//Getter & Setter
	public List<Book> getBooks() {
		return books;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}

	public Map<Long, Boolean> getCheckedBooks() {
		return checkedBooks;
	}

	public void setCheckedBooks(Map<Long, Boolean> checkedBooks) {
		this.checkedBooks = checkedBooks;
	}

	public String getCheckedOutMessage() {
		return checkedOutMessage;
	}

	public void setCheckedOutMessage(String checkedOutMessage) {
		this.checkedOutMessage = checkedOutMessage;
	}
}
