package com.mytech.exam.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mytech.exam.ejb.entities.Category;
import com.mytech.exam.ejb.entities.Product;
import com.mytech.exam.ejb.facades.CategoryFacade;
import com.mytech.exam.ejb.facades.ProductRemote;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

@Named("SaleServlet")
@SessionScoped
public class SaleServlet implements Serializable {

	private static final long serialVersionUID = -1878556815707946806L;

	// khai bao List model
	private List<Product> products;
	private List<Category> categories;

	private Product product;
	private Category category;
	private long categoryid;

	// Search
	private double minPrice;
	private double maxPrice;

	@EJB
	private ProductRemote productFacade;

	@EJB
	private CategoryFacade categoryFacade;

	public SaleServlet() {
		products = new ArrayList<Product>();
	}

	@PostConstruct
	public void initialze() {
		products = productFacade.findAll();
		categories = categoryFacade.findAll();
	}

	public String findByPrice() {
		products = productFacade.findByPrice(minPrice, maxPrice);
		return "products";
	}

	// Add product (GET)
	public String displayCreateProduct() {
		product = new Product();
		
		return "create";
	}

	// Add product (POST)
	public String performCreateProduct() {
		
		Category category = categoryFacade.find(categoryid);
		product.setCategory(category);
		productFacade.create(product);
		//
		products = productFacade.findAll();
		return "products";
	}

	// Getter and setter

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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

	public ProductRemote getProductFacade() {
		return productFacade;
	}

	public void setProductFacade(ProductRemote productFacade) {
		this.productFacade = productFacade;
	}

	public CategoryFacade getCategoryFacade() {
		return categoryFacade;
	}

	public void setCategoryFacade(CategoryFacade categoryFacade) {
		this.categoryFacade = categoryFacade;
	}
	
	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

}