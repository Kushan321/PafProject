package com.kushan.PaymentManagement;



import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

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


@DELETE
@Path("/")
@Consumes(MediaType.APPLICATION_XML)
@Produces(MediaType.TEXT_PLAIN)
public String deleteItem(String paymentData)
{
//Convert the input string to an XML document
 Document doc = Jsoup.parse(paymentData, "", Parser.xmlParser());

//Read the value from the element <itemID>
 String PaymentID= doc.select("paymentid").text();
 String output = payobj.deletePayment(PaymentID);
return output;
}


}



