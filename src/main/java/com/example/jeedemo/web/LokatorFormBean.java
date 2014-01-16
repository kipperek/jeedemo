package com.example.jeedemo.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Lokator;
import com.example.jeedemo.service.LokatorManager;


@SessionScoped
@Named("lokBean")
public class LokatorFormBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Lokator lok = new Lokator();
	
	private ListDataModel<Lokator> loks = new ListDataModel<Lokator>();

	@Inject
	private LokatorManager lokm;
	
	public Lokator getLok() {
		return lok;
	}

	public void setLok(Lokator lok) {
		this.lok = lok;
	}

	public ListDataModel<Lokator> getAllLoks() {
		loks.setWrappedData(lokm.getAllLokator());
		return loks;
	}
	
	public ListDataModel<Lokator> getFreeLoks() {
		List<Lokator> newLoks = new ArrayList<Lokator>();		
		for(Lokator l : lokm.getAllLokator()){
			if(l.getBudynek() == null)
				newLoks.add(l);
		}
		loks = new ListDataModel<Lokator>();
		loks.setWrappedData(newLoks);
		return loks;
	}
	
	// Actions
	
	public String addLokator() {
		lokm.addLokator(lok);
		//return "list";
		return null;
	}
}
