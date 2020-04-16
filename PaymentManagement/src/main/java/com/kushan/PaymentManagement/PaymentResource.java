package com.kushan.PaymentManagement;



import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.kushan.PaymentManagement.Payment;

@Path("/payments")
public class PaymentResource {
Payment payobj = new Payment();
@GET
@Path("/")
@Produces(MediaType.TEXT_HTML)
public String readItems()
 {
 return payobj.readPayments() ;
 }



@POST
@Path("/")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
@Produces(MediaType.TEXT_PLAIN)
public String insertPayment(@FormParam("patientid") int patientid,
 @FormParam("appointmentid") int appointmentid,
 @FormParam("date") String date,
 @FormParam("cardtype") String cardtype,
 @FormParam("cardnumber") String cardnumber,
 @FormParam("expirydate") String expirydate,
 @FormParam("pinnumber") String pinnumber,
 @FormParam("amount") String amount)
{
 String output = payobj.insertPayment(patientid, appointmentid,date, cardtype, cardnumber, expirydate, pinnumber, amount);
return output;
}

}



