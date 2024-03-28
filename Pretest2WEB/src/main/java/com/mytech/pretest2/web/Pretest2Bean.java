package com.mytech.pretest2.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mytech.pretest2.ejb.entities.Laptop;
import com.mytech.pretest2.ejb.facades.LaptopRemote;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("pretest2Bean")
@SessionScoped
public class Pretest2Bean implements Serializable {

	private static final long serialVersionUID = -7223555914932449113L;

	// khai bao List model
	private List<Laptop> laptops;

	private Laptop laptop;

	// Search
	private String name;
	private double minPrice;
	private double maxPrice;

	@EJB
	private LaptopRemote laptopFacade;

	public Pretest2Bean() {
		setLaptops(new ArrayList<Laptop>());
	}

	@PostConstruct
	public void initialze() {
		setLaptops(laptopFacade.findAll());
	}

	// Search (POST)
	public String findByName() {
		laptops = laptopFacade.findByName(name);
		return "laptops";
	}

	public String findByPrice() {
		laptops = laptopFacade.findByPrice(minPrice, maxPrice);
		return "laptops";
	}

	// Add laptop (GET)
	public String displayCreateLaptop() {
		laptop = new Laptop();
		return "add";
	}

	// Edit laptop (GET)
	public String displayUpdateLaptop(Laptop item) {
		laptop = item;
		return "edit";
	}

	// Add laptop (POST)
	public String performCreateLaptop() {
		laptopFacade.create(laptop);
		//
		laptops = laptopFacade.findAll();
		return "laptops";
	}

	// Edit laptop (POST)
	public String performUpdateLaptop() {
		laptopFacade.update(laptop);
		//
		laptops = laptopFacade.findAll();
		return "laptops";
	}

	// xoa laptop
	public String deleteLaptop(Laptop item) {
		laptopFacade.remove(item);
		//
		laptops = laptopFacade.findAll();
		return "laptops";
	}

	// Getter & Setter

	public List<Laptop> getLaptops() {
		return laptops;
	}

	public void setLaptops(List<Laptop> laptops) {
		this.laptops = laptops;
	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(double minPrice) {
		this.minPrice = minPrice;
	}

	public double getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(double maxPrice) {
		this.maxPrice = maxPrice;
	}
	
	
}
