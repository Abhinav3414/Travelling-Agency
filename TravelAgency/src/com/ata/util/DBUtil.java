package com.ata.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * This class is used to create a connection to Derby database.
 * @version 1.0
 * @author Abhinav , Abhilash
 */

public class DBUtil
{

	static Connection dbConnection;
	
	
	
	/**
	 * @param driverType Function Parameter
	 * @return Connection
	 */
	public static Connection getDBConnection(String driverType)
	{
		
		String dbUrl="jdbc:derby://localhost:1527/team01;create=true;user=me;password=mine";
		
	try {
			
		Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
		dbConnection=DriverManager.getConnection(dbUrl);
		
		} 
	catch (InstantiationException e) 
		{
		e.getMessage();
		}
		catch (IllegalAccessException e) 
		{
			e.getMessage();
		}
		catch (ClassNotFoundException e) 
		{
			e.getMessage();
		}
		catch (SQLException e) 
		{
			e.getMessage();
		}
		
		return dbConnection;
	}



}
