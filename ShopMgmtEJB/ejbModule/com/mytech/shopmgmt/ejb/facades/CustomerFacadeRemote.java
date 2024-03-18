package com.mytech.shopmgmt.ejb.facades;

import java.util.List;

import com.mytech.shopmgmt.ejb.entities.Customer;

import jakarta.ejb.Remote;

@Remote
public interface CustomerFacadeRemote {
	public void create(Customer customer);
	public void update(Customer customer);
	public void remove(Customer customer);
	public Customer find(Object id);
	public List<Customer> findAll();
	public List<Customer> findByName(String name);
}
