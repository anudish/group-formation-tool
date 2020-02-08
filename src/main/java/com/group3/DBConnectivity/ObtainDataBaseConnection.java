package com.group3.DBConnectivity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ObtainDataBaseConnection {
	static Connection databaseConnection;
    
	public static Connection obtainDatabaseConnection()   {
		
			try {
			Class.forName(ConnectionParameters.DRIVER_NAME);
			 databaseConnection =DriverManager.getConnection(  
					ConnectionParameters.DEV_SERVER_URL+"/"+ConnectionParameters.DEV_SERVER_DATABASE_NAME,ConnectionParameters.DEV_SERVER_DATABSE_USER_NAME,ConnectionParameters.DEV_SERVER_DATABSE_PASSWORD);
		     
		
		}catch(Exception e) {
			
			System.out.println("Error occured while connecting to remote database : "+e);
		}
			return databaseConnection;
	}
	
	public static boolean terminateConnection() {
		     try {
		    	 
		    	 if(databaseConnection.isClosed()==false) {
					 
					 databaseConnection.close();
				
				 
				 
			 }
		    	 
		     }catch(SQLException e ) {System.out.println("Error terminating connection with server "+e);}
			 
			 return true;
		
		
	}
}
