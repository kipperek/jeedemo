package com.example.jeedemo.domain;

// many to one - developer
// many to many - distributor

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "mdoel.all", query = "Select m from Game m")
})
public class Model {
	
	private Long id;

	String name;
	
	Make make;
	Vin vin;
		
	public Model() {

	}

	public Model(String name) {
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

	@ManyToOne(cascade = { CascadeType.ALL })
	public Make getMake() {
		return make;
	}

	public void setMake(Make make) {
		this.make = make;
	}
	
	@OneToOne(mappedBy="model", cascade=CascadeType.ALL)
	public Vin getVin() {
		return vin;
	}

	public void setVin(Vin vin) {
		this.vin = vin;
	}
	

}
