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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.Size;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "vin.all", query = "Select v from Vin v")
})
public class Vin {
	
	private Long id;
	String vin;
	
	Model model;

	public Vin() {

	}

	public Vin(String vin) {
		super();
		this.vin = vin;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@Size(min = 8, max = 16)
	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}
	
	@OneToOne
	@PrimaryKeyJoinColumn
	public Model getModel() {
		return model;
	}

	public void setMake(Model model) {
		this.model = model;
	}

}
