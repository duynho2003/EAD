package com.mytech.shopmgmt.ejb.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mytech.shopmgmt.ejb.entities.Book;
import com.mytech.shopmgmt.ejb.entities.Customer;
import com.mytech.shopmgmt.ejb.entities.Order;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateful;
import jakarta.jms.Connection;
import jakarta.jms.JMSException;
import jakarta.jms.MapMessage;
import jakarta.jms.MessageProducer;
import jakarta.jms.Session;
import jakarta.jms.Topic;
import jakarta.jms.TopicConnectionFactory;

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
	
	@EJB
	private OrderBMTBean orderBMTBean;
	
	@Resource(lookup = "java:/OrderMessageConnectionFactory")
	private TopicConnectionFactory topicConnectionFactory;
	
	@Resource(lookup = "java:/jms/orderMessageTopic2208a")
	private Topic statusTopic;
	
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
		//Order order = orderCMTBean.createOrderUsingSupport(customer, cartItems);
		Order order = orderBMTBean.createOrderUsingRequired(customer, cartItems);
		if (order != null) {
			sendOrderStatus();
			return "Checked Out Success";
		}
		return "Failed to check out";
	}
	
	private String sendOrderStatus() {
		String from = "shopapp@ymail.com";
		String to = "user@gmail.com";
		String content = "Your order has been processed with order id #1234567890";

		try {
		System.out.println("sendOrderStatus:: Before status TopicCF connection");
		Connection connection = topicConnectionFactory.createConnection();
		System.out.println("sendOrderStatus:: Created connection");
		connection.start();
		System.out.println("sendOrderStatus:: statted connection");
		System.out.println("sendOrderStatus:: Starting Topic Session");
		Session topicSession = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

		MessageProducer publisher = topicSession.createProducer(statusTopic);
		System.out.println("sendOrderStatus:: created producer");
		MapMessage message = topicSession.createMapMessage();
		message.setStringProperty("from", from);
		message.setStringProperty("to", to);
		message.setStringProperty("subject", "Status of your book order");
		message.setStringProperty("content", content);
		System.out.println("sendOrderStatus:: before send");
		publisher.send(message);
		System.out.println("sendOrderStatus:: after send");
		} catch (JMSException e) {
		e.printStackTrace();
		}

		return "Created a MapMessage and sent it to StatusTopic";
		}
}
