package com.HospitalManagement;


import java.util.Arrays;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@Path("/Hospitals")
public class HospitalResource {
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Hospital> getHospitals() {
	
	Hospital hos1 = new Hospital();
	hos1.setName("Cancer Hospital");
	hos1.setAddress("Colombo");
	hos1.setCharge(1000);
	hos1.setPhonenumber("0111234567");
	hos1.setRoomcount(125); 
	

	Hospital hos2 = new Hospital();
	hos2.setName("Cancer Hospital");
	hos2.setAddress("Colombo");
	hos2.setCharge(1000);
	hos2.setPhonenumber("0111234567");
	hos2.setRoomcount(125);
	
	List<Hospital> Hospitals = Arrays.asList(hos1,hos2);
	
		return Hospitals;

	}

	
	
	
	 

}
