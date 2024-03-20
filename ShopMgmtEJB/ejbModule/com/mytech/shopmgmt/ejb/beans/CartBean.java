package com.mytech.shopmgmt.ejb.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mytech.shopmgmt.ejb.entities.Book;
import com.mytech.shopmgmt.ejb.entities.Customer;
import com.mytech.shopmgmt.ejb.entities.Order;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;

/**
 * Session Bean implementation class CartBean
 */
@Stateful
@LocalBean
public class CartBean implements CartBeanRemote, Serializable {
	
	private static final long serialVersionUID = -2061815439945370029L;

	private List<Book> cartItems;
	
	@EJB
	private OrderCMTBean orderCMTBean; 
	
	public CartBean() {
        
    }
	
	@PostConstruct
	public void initialize() {
		cartItems = new ArrayList<Book>();
		System.out.println("CartBean::initialize");
	}
	
	public void addItem(Book item) {
		cartItems.add(item);
		System.out.println("CartBean::addItem");
	}
	
	public void removeItem(Book item) {
		cartItems.remove(item);
		System.out.println("CartBean::removeItem");
	}
	
	public List<Book> getCartItems(){
		System.out.println("CartBean::getCartItems");
		return cartItems;
	}
	
	public String checkout(Customer customer) {
		Order order = orderCMTBean.createOrderUsingSupport(customer, cartItems);
		if (order != null) {
			return "Checked Out Success";
		}
		return "Failed to check out";
	}
}
