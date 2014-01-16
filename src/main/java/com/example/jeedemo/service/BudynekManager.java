package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Budynek;
import com.example.jeedemo.domain.Lokator;
import com.example.jeedemo.domain.Ulica;
import com.example.jeedemo.domain.Wlasciciel;


@Stateless
public class BudynekManager {

	@PersistenceContext
	EntityManager em;
	
	public void addBudynek(Budynek budynek, Long[] wlasId, Long ulId, Long lokId) {
		budynek.setLokator(null);
		budynek.setUlica(null);
		budynek.setWlasciciele(new ArrayList<Wlasciciel>());
		
		  for(Long i: wlasId)
          {
                  Wlasciciel wlas = em.find(Wlasciciel.class, i);
                  
                  budynek.getWlasciciele().add(wlas);
          }
          Lokator lokator = em.find(Lokator.class, lokId);
          
          budynek.setLokator(lokator);
          
          Ulica ul = em.find(Ulica.class, ulId);
          
          budynek.setUlica(ul);
          budynek.setId(null);
          
		em.persist(budynek);
	}
	
	@SuppressWarnings("unchecked")
	public List<Budynek> getAllBudynek() {
		return em.createNamedQuery("budynek.all").getResultList();
	}
	
	public void deleteBudynek(Budynek budynek){
		   budynek = em.find(Budynek.class, budynek.getId());
           em.remove(budynek);
	}
}
