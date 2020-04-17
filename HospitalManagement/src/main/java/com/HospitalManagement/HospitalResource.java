package com.HospitalManagement;


import java.util.Arrays;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

@Path("/hospitals")
public class HospitalResource {
	
	
	HospitalRepository repo = new HospitalRepository();
	
	
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Hospital> getHospitals() {
	
 
		return repo.getHospitals();

	}

	@POST
	@Path("/hospital")
	public Hospital createHospital(Hospital hos1) {
		
		System.out.println(hos1);
		repo.create(hos1);
		
		return hos1;
		
	}
	
	
	 

}
