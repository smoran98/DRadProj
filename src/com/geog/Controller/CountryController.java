package com.geog.Controller;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import com.geog.DAO.DAO;
import com.geog.Model.Country;
import com.mysql.jdbc.exceptions.jdbc4.CommunicationsException;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

@ManagedBean
@SessionScoped
public class CountryController {
	
	ArrayList<Country> countries;
	private DAO dao;


	public CountryController() {
		super();
		countries = new ArrayList<Country>();
		try {
			dao = new DAO();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public CountryController(ArrayList<Country> countries) {
		super();
		this.countries = countries;
	}

	public ArrayList<Country> getCountries() {
		return countries;
	}

	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}
	
	
	public void loadCountries() throws Exception {
		countries.clear();
		if (dao != null) {
			try {
				countries = dao.loadCountries();
				System.out.println(countries.size());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
//	public String addProduct(Country country) {
//		if (dao != null) {
//			try {
//				dao.addProduct(product);
//				return "index";
//			} catch (MySQLIntegrityConstraintViolationException e) {
//				FacesMessage message = new FacesMessage("Error: Product ID " + product.getProductID() + " already exists");
//				FacesContext.getCurrentInstance().addMessage(null, message);
//				return null;
//			} catch (CommunicationsException e) {
//				FacesMessage message = new FacesMessage("Error: Cannot connect to Database");
//				FacesContext.getCurrentInstance().addMessage(null, message);
//				return null;
//			} catch (Exception e) {
//				FacesMessage message = new FacesMessage("Error while trying to insert Product " + product.getProductID());
//				FacesContext.getCurrentInstance().addMessage(null, message);
//				return null;
//			}
//		}
//		return null;
//	}


}
