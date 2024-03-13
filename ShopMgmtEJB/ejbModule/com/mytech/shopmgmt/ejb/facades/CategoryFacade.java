package com.mytech.shopmgmt.ejb.facades;

import com.mytech.shopmgmt.ejb.entities.Category;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class CategoryFacade
 */
@Stateless
@LocalBean
public class CategoryFacade extends AbstractFacade<Category> implements CategoryFacadeRemote {

	@PersistenceContext(unitName = "ShopMgmtEJB")
	private EntityManager em;
	
    public CategoryFacade() {
        super(Category.class);
    }

    @Override
	protected EntityManager getEntityManager() {
    	return em;
    }
}
