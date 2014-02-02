package com.example.jeedemo.domain;

// many to one - developer
// many to many - distributor

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "budynek.all", query = "Select b from Budynek b"),
	@NamedQuery(name = "budynek.find", query = "Select ba from Budynek ba where ba.nazwa LIKE :name")
})
public class Budynek {
	
	private Long id;

	String nazwa;
	String numer;
	Date yob;
	
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

	@ManyToOne(cascade = { CascadeType.DETACH })
	public Ulica getUlica() {
		return ulica;
	}

	public void setUlica(Ulica ulica) {
		this.ulica = ulica;
	}
	
	@OneToOne(optional=false)
	@JoinColumn(name="LOKATOR_ID", unique=true, nullable=false, updatable=false)
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
	
	@ManyToMany
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
	
	@Past
	@Temporal(TemporalType.DATE)
	public Date getYob() {
		return yob;
	}

	public void setYob(Date yob) {
		this.yob = yob;
	}
	
	
	

}
