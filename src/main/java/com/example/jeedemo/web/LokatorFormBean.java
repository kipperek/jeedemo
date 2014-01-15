package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import com.example.jeedemo.domain.*;
import com.example.jeedemo.service.*;


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
	
	// Actions
	
	public String addLokator() {
		lokm.addLokator(lok);
		//return "list";
		return null;
	}
}
