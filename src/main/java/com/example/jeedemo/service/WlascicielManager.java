package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Wlasciciel;


@Stateless
public class WlascicielManager {

	@PersistenceContext
	EntityManager em;
	
	public void addWlasciciel(Wlasciciel wlasciciel) {

		wlasciciel.setId(null);
		em.persist(wlasciciel);
	}
	
	@SuppressWarnings("unchecked")
	public List<Wlasciciel> getAllWlasciciel() {
		return em.createNamedQuery("wlasciciel.all").getResultList();
	}
}
