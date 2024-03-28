package com.mytech.pretest2.ejb.facades;

import java.util.List;

import com.mytech.pretest2.ejb.entities.Laptop;

import jakarta.ejb.Remote;

@Remote
public interface LaptopRemote {
	public void create(Laptop laptop);
	public void update(Laptop laptop);
	public void remove(Laptop laptop);
	public Laptop find(Object id);
	public List<Laptop> findAll();
	public List<Laptop> findByName(String name);
	public List<Laptop> findByPrice(double min, double max);
}
