package com.mytech.exam.ejb.facades;

import java.io.Serializable;
import java.util.List;

import com.mytech.exam.ejb.entities.Product;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class ProductFacade
 */
@Stateless
@LocalBean
public class ProductFacade extends AbstractFacade<Product> implements ProductRemote, Serializable {

	private static final long serialVersionUID = 679945351597691536L;
	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "ExamEJB")
	private EntityManager em;

	public ProductFacade() {
		super(Product.class);
	}

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public List<Product> findByPrice(double min, double max) {
		TypedQuery<Product> query = em.createQuery("SELECT b FROM Product b WHERE b.price BETWEEN ?1 AND ?2", Product.class);
		query.setParameter(1, min);
		query.setParameter(2, max);

		return query.getResultList();
	}
}
