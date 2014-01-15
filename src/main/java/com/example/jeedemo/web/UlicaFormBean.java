package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Ulica;
import com.example.jeedemo.service.UlicaManager;


@SessionScoped
@Named("ulBean")
public class UlicaFormBean implements Serializable{

	private static final long serialVersionUID = 1L;

	private Ulica ul = new Ulica();
	
	private ListDataModel<Ulica> uls = new ListDataModel<Ulica>();

	@Inject
	private UlicaManager ulm;
	
	public Ulica getUl() {
		return ul;
	}

	public void setUl(Ulica ul) {
		this.ul = ul;
	}

	public ListDataModel<Ulica> getAllUls() {
		uls.setWrappedData(ulm.getAllUlica());
		return uls;
	}
	
	// Actions
	
	public String addUlica() {
		ulm.addUlica(ul);
		//return "list";
		return null;
	}
}
