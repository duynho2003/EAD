package com.mytech.exam.ejb.facades;

import java.util.List;

import com.mytech.exam.ejb.entities.Category;

import jakarta.ejb.Remote;

@Remote
public interface CategoryFacadeRemote {

	public void create(Category category);
	public void update(Category category);
	public void remove(Category category);
	public Category find(Object id);
	public List<Category> findAll();
}
