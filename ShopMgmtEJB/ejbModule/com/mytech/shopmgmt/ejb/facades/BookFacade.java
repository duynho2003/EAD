package com.mytech.shopmgmt.ejb.facades;

import java.io.Serializable;
import java.util.List;

import com.mytech.shopmgmt.ejb.entities.Book;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class BookFacade
 */
@Stateless
@LocalBean
public class BookFacade extends AbstractFacade<Book> implements BookFacadeRemote, Serializable {

	private static final long serialVersionUID = 679945351597691536L;
	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "ShopMgmtEJB")
	private EntityManager em;
	
	public BookFacade() {
		super(Book.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public List<Book> findByName(String name) {
		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.name LIKE :name", Book.class);
		query.setParameter("name", "%" + name + "%");
		
		return query.getResultList();
	}

	@Override
	public List<Book> findByPrice(double min, double max) {
		TypedQuery<Book> query = em.createQuery("SELECT b FROM Book b WHERE b.price BETWEEN ?1 AND ?2", Book.class);
		query.setParameter(1, min);
		query.setParameter(2, max);
		
		return query.getResultList();
	}
}
