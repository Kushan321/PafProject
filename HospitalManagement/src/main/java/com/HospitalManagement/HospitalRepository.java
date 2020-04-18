package com.HospitalManagement;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class HospitalRepository{

	Connection con = null;
	
   public HospitalRepository() {
		
		String url ="jdbc:mysql://127.0.0.1:3307/testpaf?serverTimezone=UTC";
		String username = "root";
		String password = "";	
		
		try {
			 
			 Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection(url, username, password);
			 System.out.println("Connected");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public List<Hospital> viewHospital() {
		
		List<Hospital> hospitals = new ArrayList<>();
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
				
				hospitals.add(hos);
				 
			}
		}
		catch(Exception e) {
			
			System.out.println(e);
		}
		return hospitals;
			
	}
	
	public Hospital viewHospital(int hospitalid) {
		
		String sql = "select * from hospital where hospitalid="+hospitalid;
		Hospital hos = new Hospital();
		try {
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
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
		 
		return hos;
	}
	
	
	
	public void create(Hospital hos1) {
		
		String sql = "insert into hospital values(?,?,?,?,?,?)"; 
		
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, hos1.getHospitalid());
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
	
	public void update(Hospital hos1) {
		
		String sql = "update hospital set name=?, address=?, charge=?, phonenumber=?, roomcount=? where hospitalid=?"; 
		
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(6, hos1.getHospitalid());
			st.setString(1, hos1.getName());
			st.setString(2, hos1.getAddress());
			st.setInt(3, hos1.getCharge());
			st.setString(4, hos1.getPhonenumber());
			st.setInt(5, hos1.getRoomcount());
			
			st.executeUpdate();
				 
			}
		 
		catch(Exception e) {
			
			System.out.println(e);
		}
	}

	public void delete(int hospitalid) {

		String sql = "delete from hospital where hospitalid=?"; 
		
		
		try {
			
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, hospitalid);
			st.executeUpdate();
				 
			}
		 
		catch(Exception e) {
			
			System.out.println(e);
		}
		
		
	}


}
