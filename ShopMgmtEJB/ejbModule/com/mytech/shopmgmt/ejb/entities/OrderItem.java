package com.mytech.shopmgmt.ejb.entities;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@NamedQueries({ @NamedQuery(name = "OrderItem.findAll", query = "select o from OrderItem o") })
@Table(name = "OrderItems")
public class OrderItem {

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Temporal(TemporalType.DATE)
	@Column(name = "order_date")
	private Date orderDate;

	private int quantity;
	private double price;

	@Temporal(TemporalType.DATE)
	@Column(name = "ship_date")
	private Date shipDate;

	@Column(length = 4000)
	private String status;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderItem() {
	}

	public OrderItem(int quantity, Book book, Date orderDate, double price, Date shipDate, String status, Order order) {
		setOrderDate(orderDate);
		setPrice(price);
		setShipDate(shipDate);
		setStatus(status);
		setOrder(order);
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getShipDate() {
		return shipDate;
	}

	public void setShipDate(Date shipDate) {
		this.shipDate = shipDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}