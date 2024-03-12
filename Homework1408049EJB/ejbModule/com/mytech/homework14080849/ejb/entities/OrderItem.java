package com.mytech.homework14080849.ejb.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "Orderitems")
public class OrderItem implements Serializable {

	private static final long serialVersionUID = -8355310906255406820L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_item_id")
	private long id;

	@Min(value = 0, message = "Quantity must be at least 0")
	private int quantity;

	@Min(value = 0, message = "Price must be at least 0 VND")
	private double price;

	@Min(value = 0, message = "Total must be at least 0 VND")
	private double total;

	@ManyToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
}
