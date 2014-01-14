package com.example.jeedemo.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "synd.all", query = "Select s from Syndicate s")
})
public class Syndicate {
	
	private Long id;

	String name;
	
	List<Make> makes = new ArrayList<Make>();
	
	public Syndicate() {

	}

	public Syndicate(String name) {
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
	
	@ManyToMany(mappedBy = "syndicates")
	public List<Make> getMakes() {
		return makes;
	}

	public void setMakes(List<Make> makes) {
		this.makes = makes;
	}
	
	

}
