package com.mytech.shopmgmt.ejb.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;

@Entity
@NamedQueries({ @NamedQuery(name = "CustomerOrder.findAll", query = "select o from Order o") })
@Table(name = "Orders")
public class Order implements Serializable {

	private static final long serialVersionUID = -477988438407492429L;
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String status;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "creation_date")
	private Date creationDate;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

	@OneToMany(mappedBy = "order", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<OrderItem> orderItemList;

	@Version
	private int version;

	public Order() {
	}

	public Order(String status, Customer customer) {
		setCreationDate(new Date(System.currentTimeMillis()));
		setStatus(status);
		setCustomer(customer);
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<OrderItem> getOrderItemList() {
		if (orderItemList == null) {
			orderItemList = new ArrayList<OrderItem>();
		}
		return orderItemList;
	}

	public void setOrderItemList(List<OrderItem> orderitemList) {
		this.orderItemList = orderitemList;
	}

	public OrderItem addOrderItem(OrderItem orderItem) {
		getOrderItemList().add(orderItem);
		orderItem.setOrder(this);
		return orderItem;
	}

	public OrderItem removeOrderItem(OrderItem orderItem) {
		getOrderItemList().remove(orderItem);
		orderItem.setOrder(null);
		return orderItem;
	}
}