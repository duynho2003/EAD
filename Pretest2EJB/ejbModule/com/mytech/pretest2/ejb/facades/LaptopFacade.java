package com.mytech.pretest2.ejb.facades;

import java.io.Serializable;
import java.util.List;

import com.mytech.pretest2.ejb.entities.Laptop;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

/**
 * Session Bean implementation class LaptopFacade
 */
@Stateless
@LocalBean
public class LaptopFacade extends AbstractFacade<Laptop> implements LaptopRemote, Serializable {

	private static final long serialVersionUID = 3209108444702137239L;

	//gọi persistence.xml bên JPA => kết nối Database
	@PersistenceContext(unitName = "Pretest2EJB")
	private EntityManager em;
	
	public LaptopFacade() {
		super(Laptop.class);
    }

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	@Override
	public List<Laptop> findByName(String name) {
		TypedQuery<Laptop> query = em.createQuery("SELECT l FROM Laptop l WHERE l.name LIKE :name", Laptop.class);
		query.setParameter("name", "%" + name + "%");
		
		return query.getResultList();
	}

	@Override
	public List<Laptop> findByPrice(double min, double max) {
		TypedQuery<Laptop> query = em.createQuery("SELECT l FROM Laptop l WHERE l.price BETWEEN ?1 AND ?2", Laptop.class);
		query.setParameter(1, min);
		query.setParameter(2, max);
		
		return query.getResultList();
	}
}
