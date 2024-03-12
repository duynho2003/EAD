package com.mytech.homework14080849.ejb.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = -5695972650848527414L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "customer_id")
	private long id;

	@Column(name = "customer_name", length = 50)
	@Size(min = 8, message = "Customer name must be at least 8 characters")
	private String name;

	@Column(name = "customer_email", length = 100, unique = true)
	@Email(message = "Invalid email format")
	private String email;

	@Column(name = "customer_pasword", length = 100)
	@Size(min = 8, message = "Password must be at least 8 characters")
	private String pasword;

	@Column(name = "customer_address", length = 100)
	@Size(min = 8, message = "Address must be at least 8 characters")
	private String address;

}
