package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Budynek;
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
	@SuppressWarnings("unchecked")
	public void deleteWlasciciel(Wlasciciel wlas){
		boolean del = true;
		wlas = em.find(Wlasciciel.class, wlas.getId());
		List<Budynek> budynki = em.createNamedQuery("budynek.all").getResultList();
		for(Budynek b : budynki){
			if(del){
			for(Wlasciciel w : b.getWlasciciele())
					if(w.getId() == wlas.getId()){
						del = false;
						break;
					}
			}else{
				break;
			}
		}
		
		if(del)	
			em.remove(wlas);
	}
	public void editWlasciciel(Wlasciciel changed)
	{
		em.merge(changed);
	}
}
