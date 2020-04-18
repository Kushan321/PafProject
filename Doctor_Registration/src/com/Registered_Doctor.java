package com;

import java.sql.Date;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Timer;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import model.Doctor;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

@Path("/RegisterDoctor")
public class Registered_Doctor {

	Doctor doctor = new Doctor();
	
	    // Get all types
		@GET
		@Path("/DoctorDetails")
		@Produces(MediaType.TEXT_HTML)
		public String readAllTypes() {
			return doctor.viewDoctorDetails();
		}

	
		// Add Doctor
		@POST
		@Path("/DoctorDetails")
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String enterType(@FormParam("firstname")String fname,
				                @FormParam("lastname")String lname,
				                @FormParam("email")String demail,
				                @FormParam("password")String dpass,
				                @FormParam("phonenumber")int phone,
				                @FormParam("specalization")String specal,
				                @FormParam("charges")int dcharges,
				                @FormParam("type")String dtype)
		{
				                
			
			String output = doctor.addDoctor(fname, lname, demail, dpass, phone, specal, dcharges, dtype);
			return output;

		}
		
		
		// Delete Doctor
		@DELETE
		@Path("/DoctorDetails")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteAppointmentSchedule(String DoctorData) {
			// Convert the input string to a JSON object
			JsonObject jsonObject = new JsonParser().parse(DoctorData).getAsJsonObject();

			// Read the value from the element <ID>
			int DocId = jsonObject.get("doctorid").getAsInt();
			String output = doctor.RemoveDoctor(DocId);
			return output;
		}
		
		
		// Update Doctor details
		@PUT
		@Path("/DoctorDetails")
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateAppType(String DoctorData) {

			// Convert the input string to a JSON object
			JsonObject jsonObject = new JsonParser().parse(DoctorData).getAsJsonObject();

			// Read the values from the JSON object
			int did = jsonObject.get("doctorid").getAsInt();
			String fname = jsonObject.get("firstname").getAsString();
			String lname = jsonObject.get("lastname").getAsString();
			String demail = jsonObject.get("email").getAsString();
			String dpass = jsonObject.get("password").getAsString();
			int phone =jsonObject.get("phonenumber").getAsInt();
			String specal = jsonObject.get("specalization").getAsString();
			int dcharges =jsonObject.get("charges").getAsInt();
			String dtype = jsonObject.get("type").getAsString();

			String output = doctor.updateDoctor(did,fname, lname, demail, dpass, phone, specal, dcharges, dtype);
			return output;
		}

		
}
