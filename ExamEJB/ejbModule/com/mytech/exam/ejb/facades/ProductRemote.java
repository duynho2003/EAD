package com.mytech.exam.ejb.facades;

import java.util.List;

import com.mytech.exam.ejb.entities.Product;

import jakarta.ejb.Remote;

@Remote
public interface ProductRemote {
	public void create(Product product);
	public void update(Product product);
	public void remove(Product product);
	public Product find(Object id);
	public List<Product> findAll();
	public List<Product> findByPrice(double min, double max);
}
