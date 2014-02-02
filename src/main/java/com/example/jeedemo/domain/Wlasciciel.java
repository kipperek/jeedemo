package com.example.jeedemo.domain;

// many to one - developer
// many to many - distributor

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "wlasciciel.all", query = "Select w from Wlasciciel w")
})
public class Wlasciciel {
	
	private Long id;

	String imie;
	String nazwisko;
	
	List<Budynek> budynki = new ArrayList<Budynek>();
	
	public Wlasciciel() {

	}

	public Wlasciciel(String imie) {
		super();
		this.imie = imie;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}	
	
	@ManyToMany(mappedBy = "wlasciciele")
	public List<Budynek> getBudynki() {
		return budynki;
	}

	public void setBudynki(List<Budynek> budynki) {
		this.budynki= budynki;
	}
	@Size(min = 2)
	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}
	@Size(min = 2)
	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	
	
}
