package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
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
		return "list-ulica";
	}
	public String deleteUlica() {
		Ulica ulToDelete = uls.getRowData();
		ulm.deleteUlica(ulToDelete);
		return null;
	}
	public String editUlica(){
		ulm.editUlica(this.ul);
		return "list-ulica";
	}
	public String selectUlica(){
		this.ul = uls.getRowData();
		return "ul-mod";
	}
	
	public void uniqueName(FacesContext context, UIComponent component,
			Object value) {

		String name = (String) value;

		for (Ulica ul : getAllUls()) {
			if (ul.getName().equalsIgnoreCase(name)) {
				FacesMessage message = new FacesMessage(
						"Street with this name already exists");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
	
	public void uniqueNameMod(FacesContext context, UIComponent component,
			Object value) {

		String name = (String) value;

		for (Ulica ul : getAllUls()) {
			if (ul.getName().equalsIgnoreCase(name) && !name.equalsIgnoreCase(this.ul.getName())) {
				FacesMessage message = new FacesMessage(
						"Street with this name already exists");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
}
