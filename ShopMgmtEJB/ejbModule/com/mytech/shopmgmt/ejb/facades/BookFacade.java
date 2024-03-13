package com.mytech.shopmgmt.ejb.facades;

import java.io.Serializable;

import com.mytech.shopmgmt.ejb.entities.Book;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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

}
