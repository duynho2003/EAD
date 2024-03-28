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
public class Pretest2Bean implements Serializable{

	private static final long serialVersionUID = -7223555914932449113L;
	
	private List<Laptop> laptops;
	
	private Laptop laptop;
	
	@EJB
	private LaptopRemote laptopFacade;
	
	public Pretest2Bean() {
		setLaptops(new ArrayList<Laptop>());
	}
	
	@PostConstruct
	public void initialze() {
		setLaptops(laptopFacade.findAll());
	}

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
}
