package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Budynek;
import com.example.jeedemo.service.BudynekManager;


@SessionScoped
@Named("budBean")
public class BudynekFormBean implements Serializable 
{

	private static final long serialVersionUID = 1L;

	private Budynek budynek = new Budynek();

	private ListDataModel<Budynek> budynki = new ListDataModel<Budynek>();
	
	private Long[] wlasId = new Long[1];
	private Long ulId;
	private Long lokId;
	
	public Long[] getWlasId() {
		return wlasId;
	}

	public void setWlasId(Long[] wlasId) {
		this.wlasId = wlasId;
	}

	public Long getUlId() {
		return ulId;
	}

	public void setUlId(Long ulId) {
		this.ulId = ulId;
	}
	
	public Long getLokId() {
		return lokId;
	}

	public void setLokId(Long lokId) {
		this.lokId = lokId;
	}



	@Inject
	private BudynekManager bm;
	
	public Budynek getBudynek() {
		return budynek;
	}

	public void setBudynek(Budynek budynek) {
		this.budynek = budynek;
	}

	public ListDataModel<Budynek> getAllBudynki() {
		budynki.setWrappedData(bm.getAllBudynek());
		return budynki;
	}

	// Actions
	
	public String addBudynek() {

		bm.addBudynek(budynek, wlasId, ulId, lokId);
		return "list";
		//return null;
	}

	public String deleteBudynek() {
		Budynek budynekToDelete = budynki.getRowData();
		bm.deleteBudynek(budynekToDelete);
		return null;
	}
}