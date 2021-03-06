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
	String find ="";
	
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
	public List<Budynek> getBudynkiByName(String find){
		this.find = find;
		return em.createNamedQuery("budynek.find").setParameter("name", "%" + this.find + "%").getResultList();
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Budynek> getAllBudynek() {
		return em.createNamedQuery("budynek.all").getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Lokator> getFreeLoks4Mod(Budynek budynek) {
		List<Lokator> loks = em.createNamedQuery("lokator.free").getResultList();
		loks.add(budynek.getLokator()); 
		return loks;
	}
	
	public void deleteBudynek(Budynek budynek){
		   budynek = em.find(Budynek.class, budynek.getId());
           em.remove(budynek);
	}
	
    public void editBudynek(Budynek changed,Long[] wlasId, Long ulId, Long lokId)
    {
    	changed.setLokator(null);
    	changed.setUlica(null);
    	changed.setWlasciciele(new ArrayList<Wlasciciel>());
			
			  for(Long i: wlasId)
	          {
	                  Wlasciciel wlas = em.find(Wlasciciel.class, i);
	                  
	                  changed.getWlasciciele().add(wlas);
	          }
	          Lokator lokator = em.find(Lokator.class, lokId);
	          
	          changed.setLokator(lokator);
	          
	          Ulica ul = em.find(Ulica.class, ulId);
	          
	          changed.setUlica(ul);
            em.merge(changed);
    }
}
