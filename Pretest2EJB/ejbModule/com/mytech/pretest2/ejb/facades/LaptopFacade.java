package com.mytech.pretest2.ejb.facades;

import java.io.Serializable;

import com.mytech.pretest2.ejb.entities.Laptop;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

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

}
