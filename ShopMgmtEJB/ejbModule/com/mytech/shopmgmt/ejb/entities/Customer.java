package com.mytech.shopmgmt.ejb.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Entity implementation class for Entity: Customer
 * https://www.baeldung.com/javax-validation
 *
 */
@Entity
@Table(name = "Customers")
@NamedQueries({ @NamedQuery(name = "Customer.findAll", query = "SELECT e FROM Customer e"),
		@NamedQuery(name = "Customer.findByCustomerId", query = "SELECT e FROM Customer e WHERE e.id = :id"),
		@NamedQuery(name = "Customer.findByName", query = "SELECT e FROM Customer e WHERE e.name = :name"),
		@NamedQuery(name = "Customer.findByAge", query = "SELECT e FROM Customer e WHERE e.age = :age") })
public class Customer implements Serializable {

	private static final long serialVersionUID = 8720861645626740988L;

	@Id
	@NotNull
	@Size(min = 3, max = 12)
	@Column(name = "custId")
	private String id;

	@Size(max = 64)
	@Column(name = "custName")
	private String name;

	@Size(max = 64)
	@Column(name = "custPassoword")
	private String password;

	@Column(name = "custAge")
	@Min(value = 18, message = "Age should not be less than 18")
	private Integer age;

	@OneToMany(mappedBy = "customer", cascade = { CascadeType.ALL }, orphanRemoval = true)
	private List<Order> orderList;

	public Customer(@NotNull @Size(min = 3, max = 12) String id, @Size(max = 64) String name,
			@Size(max = 64) String password, @Min(value = 18, message = "Age should not be less than 18") Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.age = age;
	}

	public Customer() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Order> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<Order> orderList) {
		this.orderList = orderList;
	}

	public Order addOrder(Order order) {
		getOrderList().add(order);
		order.setCustomer(this);
		return order;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.myaptech.Customerapp.entity.Customer[ CustomerID=" + id + " ]";
	}
}
