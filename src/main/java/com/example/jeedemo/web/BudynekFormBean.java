package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Budynek;
import com.example.jeedemo.domain.Lokator;
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
	
	private String findName = "";
	
	public String getFindName(){
		return findName;
	}
	public void setFindName(String findName){
		this.findName = findName;
	}
	
	
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
	
	public ListDataModel<Budynek> getBudynkiByName() {
		budynki.setWrappedData(bm.getBudynkiByName(findName));
		return budynki;
	}
	
	public ListDataModel<Lokator> getFreeLoks4Mod() {
		ListDataModel<Lokator> loks = new ListDataModel<Lokator>();
		loks.setWrappedData(bm.getFreeLoks4Mod(this.budynek));
		return loks;
	}
	

	// Actions
	
	public String addBudynek() {

		bm.addBudynek(budynek, wlasId, ulId, lokId);
		return "search";
		//return null;
	}
	public String selectBudynek(){
		this.budynek = budynki.getRowData();
		return "edit";
	}
	public String editBudynek(){
		bm.editBudynek(this.budynek, wlasId, ulId, lokId);
		return "search";
	}
	public String deleteBudynek() {
		Budynek budynekToDelete = budynki.getRowData();
		bm.deleteBudynek(budynekToDelete);
		return null;
	}
}