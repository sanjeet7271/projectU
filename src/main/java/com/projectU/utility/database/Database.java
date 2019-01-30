/**
 * 
 */
package com.projectU.utility.database;

/**
 * @author sanjeet.pandit
 *
 */
public interface Database {

	void getConnection();
	public void getQueryData(String query);
	public int insertOrUpdate(String query);
}
