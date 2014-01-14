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

@Entity
@NamedQueries({ 
	@NamedQuery(name = "make.all", query = "Select m from Make m")
})
public class Make {
	
	private Long id;

	String name;
	List<Syndicate> syndicates = new ArrayList<Syndicate>();
	
	public Make() {

	}

	public Make(String name) {
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
	
	@ManyToMany
	public List<Syndicate> getSyndicates() {
		return syndicates;
	}

	public void setSyndicates(List<Syndicate> syndicates) {
		this.syndicates = syndicates;
	}

}
