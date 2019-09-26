/**
 * 
 */
package com.projectU.utility.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.apache.log4j.Logger;

/**
 * @author sanjeet.pandit
 *
 */
public class MSSql implements Database{
	
	private static Logger logger = Logger.getLogger(MSSql.class);
	private Connection con;
	private String connectionString = "";
	private String userName = "";
	private String password = "";
	private ResultSet rs = null;
	private Statement stmt;
	

	/* (non-Javadoc)
	 * @see com.jstorm.utility.database.Database#getConnection()
	 */
	public void getConnection() {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.jstorm.utility.database.Database#getQueryData(java.lang.String)
	 */
	public void getQueryData(String query) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see com.jstorm.utility.database.Database#insertOrUpdate(java.lang.String)
	 */
	public int insertOrUpdate(String query) {
		// TODO Auto-generated method stub
		return 0;
	}



}
