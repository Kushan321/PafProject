package com;

//For REST Service
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
//For JSON
import com.google.gson.*;

import model.Patient;

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.nodes.Document;

@Path("/Patients")
public class PatientService {
	Patient pObj = new Patient();

	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String readItems() {
		return pObj.readPatients();
	}

	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String addPatient(@FormParam("name") String name, @FormParam("password") String password,
			@FormParam("email") String email, @FormParam("phonenumber") String phonenumber,
			@FormParam("address") String address) {
		String output = pObj.addPatient(name, password, email, phonenumber, address);
		return output;
	}

	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatient(String patientData) {
		// Convert the input string to a JSON object
		JsonObject pObject = new JsonParser().parse(patientData).getAsJsonObject();
		// Read the values from the JSON object
		String patientid = pObject.get("patientid").getAsString();
		String name = pObject.get("name").getAsString();
		String password = pObject.get("password").getAsString();
		String email = pObject.get("email").getAsString();
		String phonenumber = pObject.get("phonenumber").getAsString();
		String address = pObject.get("address").getAsString();

		String output = pObj.updatePatient(patientid, name, password, email, phonenumber, address);
		return output;
	}

	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String patientData) {
		// Convert the input string to an XML document
		Document doc = Jsoup.parse(patientData, "", Parser.xmlParser());
		// Read the value from the element <patientID>
		String patientid = doc.select("patientid").text();
		String output = pObj.deletePatient(patientid);
		return output;
	}

}