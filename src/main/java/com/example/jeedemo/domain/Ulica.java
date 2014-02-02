package com.example.jeedemo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "ulica.all", query = "Select u from Ulica u"),
	@NamedQuery(name = "ulica.isfree", query = "Select u from Ulica u WHERE u.id = :id AND u.id not in (Select bu.ulica.id from Budynek bu)")
})
public class Ulica {
	
	private Long id;

	String name;
	
	
	public Ulica() {

	}

	public Ulica(String name) {
		super();
		this.name = name;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
