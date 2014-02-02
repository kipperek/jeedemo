package com.example.jeedemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Budynek;
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
	
	@SuppressWarnings("unchecked")
	public List<Lokator> getFreeLokator(){
		List<Budynek> budynki = em.createNamedQuery("budynek.all").getResultList();
		List<Lokator> newLoks = em.createNamedQuery("lokator.all").getResultList();
		
		List<Lokator> toDelete = new ArrayList<Lokator>();
			for(Budynek b : budynki)
			{
				for(Lokator l : newLoks){
					if(b.getLokator().getId() == l.getId())
						toDelete.add(l);
				}
			}
			for(Lokator l : toDelete)
				newLoks.remove(l);
		
		
		return newLoks;
		
	}
	public void deleteLokator(Lokator lokator){
		   lokator = em.find(Lokator.class, lokator.getId());
		   if(em.createNamedQuery("lokator.isfree").setParameter("id", lokator.getId()).getResultList().size() > 0)
			   em.remove(lokator);
	}
	public void editLokator(Lokator changed)
	{
		em.merge(changed);
	}
	
}
