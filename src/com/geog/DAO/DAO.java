package com.geog.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.geog.Model.Country;

public class DAO {
	private DataSource mysqlDS;
	
	/* ======================================================================================================
	 * Constructor
	 * ====================================================================================================== */
	public DAO() throws Exception {
		Context context = new InitialContext();
		String jndiName = "java:comp/env/jdbc/employeesdb14";
		mysqlDS = (DataSource) context.lookup(jndiName);
	}
	
	
	public ArrayList<Country> loadProducts() throws Exception {
		ArrayList<Country> countries = new ArrayList<Country>();
		
		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		myConn = mysqlDS.getConnection();

		String sql = "select * from country";

		myStmt = myConn.createStatement();

		myRs = myStmt.executeQuery(sql);

		// process result set
		while (myRs.next()) {
				
			// retrieve data from result set row
			String co_code = myRs.getString("descrip");
			String co_name = myRs.getString("descrip");
			String co_details = myRs.getString("descrip");

			// create new student object
			Country country = new Country(prodid, desc);

			countries.add(country);
		}	
		return countries;
	}

//	public void addProduct(Country product) throws Exception {
//		Connection myConn = null;
//		PreparedStatement myStmt = null;
//		ResultSet myRs = null;
//		
//		myConn = mysqlDS.getConnection();
//		String sql = "insert into product values (?, ?)";
//		myStmt = myConn.prepareStatement(sql);
//		myStmt.setInt(1, product.getProductID());
//		myStmt.setString(2, product.getDescription());
//		myStmt.execute();			
//	}

}
