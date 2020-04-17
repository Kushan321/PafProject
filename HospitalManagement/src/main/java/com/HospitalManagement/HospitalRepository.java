package com.HospitalManagement;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;



public class HospitalRepository {
	
	List<Hospital> hospitals;
	
	public HospitalRepository() {
		
		hospitals = new ArrayList<>();
		
		Hospital hos1 = new Hospital();
		hos1.setHospitalid(1);
		hos1.setName("Cancer Hospital");
		hos1.setAddress("Colombo");
		hos1.setCharge(1000);
		hos1.setPhonenumber("0111234567");
		hos1.setRoomcount(125); 
		

		Hospital hos2 = new Hospital();
		hos2.setHospitalid(2);
		hos2.setName("Cancer Hospital");
		hos2.setAddress("Kandy");
		hos2.setCharge(2000);
		hos2.setPhonenumber("0111269867");
		hos2.setRoomcount(90);  
		
		hospitals.add(hos1);
		hospitals.add(hos2);
		
	}
	
	
	public List<Hospital> getHospitals()
	{
		
		return hospitals;
	}
	
	public Hospital getHospital(int hospitalid) {
		
		Hospital hos1 =null;
		
		for(Hospital hos : hospitals)
		{
			if(hos.getHospitalid()==hospitalid)
				return hos;
			
		}
		
		
		return null;
	}


	public void create(Hospital hos1) {
		// TODO Auto-generated method stub
		hospitals.add(hos1);
		
	}
	
	
	
	
	
	
	
	
	
	
/*	
	
	Connection con = null;
	
   public HospitalRepository() {
		
		String url ="jdbc:mysql://localhost:3307/testpaf";
		String username = "root";
		String password = "";	
		
		try {
			 
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection(url, username, password);
			 System.out.println("Connected");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public String viewHospital() {
		
		String sql = "select * from hospital";
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Hospital hos = new Hospital();
				hos.setHospitalid(rs.getInt(1));
				hos.setName(rs.getString(2));
				hos.setAddress(rs.getString(3));
				hos.setCharge(rs.getInt(4));
				hos.setPhonenumber(rs.getString(5));
				hos.setRoomcount(rs.getInt(6));
				 
			}
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		return sql;
			
	}
	
	public void createHospital(Hospital hos1) {
		
		String sql = "insert into hospital values(?,?,?,?,?)"; 
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(2, hos1.getName());
			st.setString(3, hos1.getAddress());
			st.setInt(4, hos1.getCharge());
			st.setString(5, hos1.getPhonenumber());
			st.setInt(6, hos1.getRoomcount());
			
			st.executeUpdate();
				 
			}
		 
		catch(Exception e) {
			
			System.out.println(e);
		}
	}
	
	*/

}
