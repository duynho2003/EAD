package com.mytech.homework14080849.ejb.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Orders")
public class Order implements Serializable {

	private static final long serialVersionUID = -3035843923364667672L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private long id;

	@Column(name = "order_name", length = 50)
	@Size(min = 8, message = "Name must be at least 8 characters")
	private String name;

	@Column(name = "order_email", length = 100, unique = true)
	@Email(message = "Invalid email format")
	private String email;

	@Column(name = "order_phone")
	@Digits(integer = 15, fraction = 0, message = "Phone must be a numeric value with up to 15 digits")
	private String phone;

	@Column(name = "order_address", length = 100)
	@Size(min = 8, message = "Address must be at least 8 characters")
	private String address;

	@Column(name = "order_date", length = 50)
	private Date date;

	@ManyToOne
	@JoinColumn(name = "customer_id", nullable = false)
	private Customer customer;

	@OneToMany(mappedBy = "order")
	private List<OrderItem> orderItems;
}
