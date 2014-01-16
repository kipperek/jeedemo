package com.example.jeedemo.domain;

// many to one - developer
// many to many - distributor

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

/**
 * @author student
 *
 */
@Entity
@NamedQueries({ 
	@NamedQuery(name = "lokator.all", query = "Select l from Lokator l")
})
public class Lokator {
	
	private Long id;
	String imie;
	String nazwisko;
	
	Budynek budynek;

	public Lokator() {

	}

	public Lokator(String imie, String nazwisko) {
		super();
		this.imie = imie;
		this.nazwisko = nazwisko;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 2)
	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}
	
	@OneToOne(optional=false, mappedBy="lokator")
	public Budynek getBudynek() {
		return budynek;
	}

	public void setBudynek(Budynek budynek) {
		this.budynek = budynek;
	}
	
	@Size(min = 2)
	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}
	

}
