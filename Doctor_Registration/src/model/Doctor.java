package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Doctor {
	public Connection connect() {
		Connection con = null;

		try {

			Class.forName("com.mysql.jdbc.Driver");
			con= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/testpaf", "root", "");	
			System.out.print("Successfully connected");

		} catch (Exception e) {

			System.out.print("connection fail");
			e.printStackTrace();
			System.out.print(e);
		}

		return con;
	}
	
	//View Doctor Details

	public String viewDoctorDetails() {

		String output = "";
		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for reading.";
			}
			
			// Prepared the HTML table to be displayed
			output = "<h2>Registered Doctor</h2>" 
					
					+"<table border=\"1\"><tr><th>Doctor ID</th>"
					+ "<th>First Name</th>" 
					+ "<th>Last Name</th>" 
					+ "<th>Email</th>"
					+ "<th>Phone No</th>"
					+ "<th>Specalization</th>"
					+ "<th>Charges</th>"
					+ "<th>type</th>"
					+"<th>Update</th>"
					+"<th>Remove</th></tr>";
			
			String query = "select * from registereddoctor";
			
			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			
			while (resultSet.next()) {
				int d_id =    resultSet.getInt("doctorid");
				String fname =  resultSet.getString("firstname");
				String lname =  resultSet.getString("lastname");
				String demail =  resultSet.getString("email");
				String dphone =  resultSet.getString("phonenumber");
				String dspec =  resultSet.getString("specalization");
				int dcharge =  resultSet.getInt("charges");
				String dtype =  resultSet.getString("type");

				
				output += "<tr><td>" + d_id + "</td>";
				output += "<td>" + fname + "</td>";
				output += "<td>" + lname + "</td>";
				output += "<td>" + demail + "</td>";
				output += "<td>" + dphone + "</td>";
				output += "<td>" + dspec + "</td>";
				output += "<td>" + dcharge + "</td>";
				output += "<td>" + dtype + "</td>";
				
				// Buttons
				output += "<td><input name=\"btnUpdate\" type=\"button\"value=\"Update\" class=\"btn btn-secondary\"></td>"+ "<td><form method=\"post\" action=\"items.jsp\">"+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\"class=\"btn btn-danger\">"
				+ "<input name=\"doctorid\" type=\"hidden\" value=\"" + d_id+ "\">" + "</form></td></tr>";

			}

			con.close();
			
			output += "</table>";

		} catch (Exception e) {
			output = "Error while reading the Doctors Details.";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	//Insert Doctor Details
	public String addDoctor(String first_name, String last_name, String D_email,String D_password, int phoneNo, String specali ,int dcharges, String Dtype) {

		String output = "";
		try {

			Connection con = connect();

			if (con == null) {
				return "Error while connecting to the database";
			}

			// create a prepared statement
			String query = " INSERT INTO doctorreg (firstname, lastname,email,password,phonenumber,specalization,charges,type) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement preparedStatement = con.prepareStatement(query);

			// Binding values
			preparedStatement.setString(1, first_name);
			preparedStatement.setString(2, last_name);
			preparedStatement.setString(3, D_email);
			preparedStatement.setString(4, D_password);
			preparedStatement.setInt(5, phoneNo);
			preparedStatement.setString(6, specali);
			preparedStatement.setInt(7, dcharges);
			preparedStatement.setString(8, Dtype);

			// Execute the statement
			preparedStatement .execute();
			con.close();
			output = "Inserted successfully";

		} catch (Exception e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	//Delete Doctor Details
	public String RemoveDoctor(int DoC_id) {
		String output = "";
		try {

			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}

			// create a prepared statement
			String query = "DELETE FROM doctorreg WHERE doctorid=?";
			PreparedStatement preparedStatement = con.prepareStatement(query);

			// binding values
			preparedStatement.setInt(1, DoC_id);

			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Deleted successfully [ Doctor Id : "+DoC_id +" ]";

		} catch (Exception e) {

			output = "Error while deleting the Doctor" + DoC_id;
			System.err.println(e.getMessage());
		}

		return output;
	}
	
	//Update Doctor Details
	public String updateDoctor(int id ,String first_name, String last_name, String D_email,String D_password, int phoneNo, String specali ,int dcharges, String Dtype) {

		String output = "";

		try {
			Connection con = connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement
			String query = "UPDATE doctorreg SET firstname =?,lastname =?,email =?,password=?,phonenumber =?,specalization =?,charges =?,type=? WHERE doctorid =?";
			PreparedStatement preparedStatement = con.prepareStatement(query);

			// binding values

			preparedStatement.setString(1, first_name);
			preparedStatement.setString(2, last_name);
			preparedStatement.setString(3, D_email);
			preparedStatement.setString(4, D_password);
			preparedStatement.setInt(5, phoneNo);
			preparedStatement.setString(6, specali);
			preparedStatement.setInt(7, dcharges);
			preparedStatement.setString(8, Dtype);
			preparedStatement.setInt(9, id);
			// execute the statement
			preparedStatement.execute();
			con.close();
			output = "Updated successfully [ ID : "+id+" ]";
		} catch (Exception e) {
			output = "Error while updating the Doctor " + id;
			System.err.println(e.getMessage());
		}
		
		return output;
	}

}
