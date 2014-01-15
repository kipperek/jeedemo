package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;
import com.example.jeedemo.domain.*;
import com.example.jeedemo.service.*;


@SessionScoped
@Named("wlasBean")
public class WlascicielFormBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Wlasciciel wlas = new Wlasciciel();
	
	private ListDataModel<Wlasciciel> wlass = new ListDataModel<Wlasciciel>();

	@Inject
	private WlascicielManager wlasm;
	
	public Wlasciciel getWlas() {
		return wlas;
	}

	public void setWlas(Wlasciciel wlas) {
		this.wlas = wlas;
	}

	public ListDataModel<Wlasciciel> getAllWlass() {
		wlass.setWrappedData(wlasm.getAllWlasciciel());
		return wlass;
	}
	
	// Actions
	
	public String addWlasciciel() {
		wlasm.addWlasciciel(wlas);
		//return "list";
		return null;
	}
}
