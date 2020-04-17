package com.HospitalManagement;


import java.sql.*;



public class HospitalRepository {
	
	Connection con = null;
	
	public HospitalRepository() {
		
		String url ="jdbc:mysql://localhost:3307/testpaf";
		String username = "root";
		String password = "";	
		
		try {
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(url,username,password);
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	
	

}
