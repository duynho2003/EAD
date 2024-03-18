package com.mytech.shopmgmt.ejb.facades;

import java.io.Serializable;
import java.util.List;

import com.mytech.shopmgmt.ejb.entities.Book;
import com.mytech.shopmgmt.ejb.entities.Customer;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class CustomerFacade
 */
@Stateless
@LocalBean
public class CustomerFacade extends AbstractFacade<Customer> implements CustomerFacadeRemote, Serializable{

	private static final long serialVersionUID = 1505615772566778483L;
	
	@PersistenceContext(unitName = "ShopMgmtEJB")
	private EntityManager em;
	
	public CustomerFacade() {
		super(Customer.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public List<Customer> findByName(String name) {
		TypedQuery<Customer> query = em.createNamedQuery("Customer.findByName", Customer.class);
		
		query.setParameter("name", name);
		
		return query.getResultList();
	}

}
