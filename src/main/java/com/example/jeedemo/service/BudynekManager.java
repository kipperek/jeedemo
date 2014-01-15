package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Budynek;


@Stateless
public class BudynekManager {

	@PersistenceContext
	EntityManager em;
	
	public void addBudynek(Budynek budynek) {

		budynek.setId(null);
		em.persist(budynek);
	}
	
	@SuppressWarnings("unchecked")
	public List<Budynek> getAllBudynek() {
		return em.createNamedQuery("budynek.all").getResultList();
	}
}
