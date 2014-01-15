package com.example.jeedemo.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.jeedemo.domain.Ulica;


@Stateless
public class UlicaManager {

	@PersistenceContext
	EntityManager em;
	
	public void addUlica(Ulica ulica) {

		ulica.setId(null);
		em.persist(ulica);
	}
	
	@SuppressWarnings("unchecked")
	public List<Ulica> getAllUlica() {
		return em.createNamedQuery("ulica.all").getResultList();
	}
}
