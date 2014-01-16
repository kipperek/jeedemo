package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.jeedemo.domain.Lokator;

@Stateless
public class LokatorManager {

	@PersistenceContext
	EntityManager em;
	
	public void addLokator(Lokator lokator) {

		lokator.setId(null);
		em.persist(lokator);
	}
	
	@SuppressWarnings("unchecked")
	public List<Lokator> getAllLokator() {
		return em.createNamedQuery("lokator.all").getResultList();
	}
	
}
