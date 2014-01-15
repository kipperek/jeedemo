package com.example.jeedemo.domain;

// many to one - developer
// many to many - distributor

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "budynek.all", query = "Select b from Budynek b")
})
public class Budynek {
	
	private Long id;

	String nazwa;
	String numer;
	
	Ulica ulica;
	Lokator lokator;
	List<Wlasciciel> wlasciciele = new ArrayList<Wlasciciel>();
		
	public Budynek() {

	}

	public Budynek(String nazwa) {
		super();
		this.nazwa = nazwa;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne(cascade = { CascadeType.ALL })
	public Ulica getUlica() {
		return ulica;
	}

	public void setUlica(Ulica ulica) {
		this.ulica = ulica;
	}
	
	@OneToOne(mappedBy="budynek", cascade=CascadeType.ALL)
	public Lokator getLokator() {
		return lokator;
	}

	public void setLokator(Lokator lokator) {
		this.lokator = lokator;
	}

	public String getNumer() {
		return numer;
	}

	public void setNumer(String numer) {
		this.numer = numer;
	}
	
	@ManyToMany(mappedBy = "budynki")
	public List<Wlasciciel> getWlasciciele() {
		return wlasciciele;
	}

	public void setWlasciciele(List<Wlasciciel> wlasciciele) {
		this.wlasciciele = wlasciciele;
	}

	public String getNazwa() {
		return nazwa;
	}

	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	
	
	

}
