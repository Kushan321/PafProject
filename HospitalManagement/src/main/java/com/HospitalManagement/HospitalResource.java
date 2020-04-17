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
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public List<Hospital> viewHospital() {
	
 
		return repo.viewHospital();

	}

	@GET
	@Path("/hospital/{hospitalid}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Hospital viewHospital(@PathParam("hospitalid") int hospitalid) {
		
		
		return repo.viewHospital(hospitalid);
		
	}
	
	
	@POST
	@Path("/hospital")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Hospital createHospital(Hospital hos1) {
		
		System.out.println(hos1);
		repo.create(hos1);
		
		return hos1;
		
	}
	
	@PUT
	@Path("/hospital")
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Hospital updateHospital(Hospital hos1) {
		
		System.out.println(hos1);
		
		if(repo.viewHospital(hos1.getHospitalid()).getHospitalid()==0) 
		{
			repo.create(hos1);
		}
		else 
		{
			repo.update(hos1);
		}
		
		return hos1;
		
	}
	
	 

}
