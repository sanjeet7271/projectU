/**
 * 
 */
package com.projectU.utility.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.log4j.Logger;
import org.testng.Assert;

import com.projectU.framework.Setup;

/**
 * @author sanjeet.pandit
 *
 */
public class Oracle extends Setup implements Database  {

	private static Logger logger = Logger.getLogger(Oracle.class);
	private Connection con;
	private String connectionString = "";
	private String userName = "";
	private String password = "";
	private ResultSet rs = null;
	private Statement stmt;
	
	/* 
	 * @see com.jstorm.utility.database.Database#getConnection()
	 */
	public void getConnection() {
		this.connectionString = dbConfig.get("connectionString");
		this.userName = dbConfig.get("userName");
		this.password = dbConfig.get("password");

		logger.info("ConnectionString is : " + this.connectionString);
		logger.info("User Name : " + this.userName);
		logger.info("Password : " + this.password);
		try {
			this.con = DriverManager.getConnection(this.connectionString, this.userName, this.password);
			logger.info("Connection sucessfully created.");
		} catch (Exception e) {
			logger.error("Not able to connect Database");
			Assert.fail("Not able to connect Database" + e.getMessage());
		}
		
	}
	/* (non-Javadoc)
	 * @see com.jstorm.utility.database.Database#getQueryData()
	 */
	public void getQueryData(String query) {
		logger.info("Get data for query : " + query);
		try {
			stmt = this.con.createStatement();
			rs = stmt.executeQuery(query);
			logger.info("Query executed sucessfully.");
		} catch (Exception e) {
			logger.error("Not able to execute query.");
		}
	}
	/* (non-Javadoc)
	 * @see com.jstorm.utility.database.Database#insertOrUpdate()
	 */
	public int insertOrUpdate(String query) {
		int rowCount = 0;
		logger.info("Insert/Update query : " + query);
		try {
			stmt = this.con.createStatement();
			rowCount = stmt.executeUpdate(query);
			logger.info("Query executed sucessfully.");
		} catch (Exception e) {
			logger.error("Not able to execute query.");
		}
		return rowCount;		
	}

}
