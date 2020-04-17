package model.kushan.PaymentManagement;
import java.sql.*;

public class Payment {
	//A common method to connect to the DB
		private Connection connect()
		 {
		 Connection con = null;
		 try
		 {
			 Class.forName("com.mysql.jdbc.Driver");
			   con = DriverManager.getConnection("jdbc:mysql://localhost/testpaf","root","");
		 }
		 catch (Exception e)
		 {e.printStackTrace();}
		 return con;
		 } 
		
		public String insertPayment(int patientID,int appointmentID, String date, String cardtype, String cardnumber,String expd,String pno,String amount)
		 {
		 String output = "";
		 try
		 {
		 Connection con = connect();
		 if (con == null)
		 {return "Error while connecting to the database for inserting."; }
		 // create a prepared statement
		 String query = "insert into payment(`paymentid`,`patientid`,`appointmentid`,`date`,`cardtype`,`cardnumber`,`expirydate`,`pinnumber`,`amount`)"+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
		 PreparedStatement preparedStmt = con.prepareStatement(query);
		 // binding values
		 preparedStmt.setInt(1, 0);
		 preparedStmt.setInt(2, patientID);
		 preparedStmt.setInt(3, appointmentID);
     	 preparedStmt.setString(4, date);
		 preparedStmt.setString(5, cardtype);
		 preparedStmt.setString(6, cardnumber);
		 preparedStmt.setString(7, expd);
		 preparedStmt.setString(8, pno);
		 preparedStmt.setDouble(9, Double.parseDouble(amount));
	
		 
		//execute the statement
		preparedStmt.execute();
		con.close();
		output = "Payment successfully recieved";
		}
		catch (Exception e)
		{
		output = "Error while inserting the item.";
		System.err.println(e.getMessage());
		}
		return output;
		}
		
		public String readPayments()
		{
		String output = "";
		try
		{
		Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for reading."; }
		// Prepare the html table to be displayed
		output = "<table border=\"1\"><tr><th>PaymentID</th><th>PatientID</th><th>AppointmentID</th><th>Date</th><th>Amount</th></tr>";
		String query = "select paymentid,patientid,appointmentid,date,amount from payment";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		// iterate through the rows in the result set
		while (rs.next())
		{
		String PaymentID = Integer.toString(rs.getInt("paymentid"));
		String PatientID = rs.getString("patientid");
		String AppointmentID = rs.getString("appointmentid");
		String Date = rs.getString("date");
		String Amount = Double.toString(rs.getDouble("amount"));

		// Add into the html table
		output += "<tr><td>" + PaymentID + "</td>";
		output += "<td>" + PatientID + "</td>";
		output += "<td>" + AppointmentID + "</td>";
		output += "<td>" + Date + "</td>";
		output += "<td>" + Amount + "</td>";
		// buttons
		//output += "<td><input name=\"btnUpdate\" type=\"button\" value=\"Update\" class=\"btn btn-secondary\"></td>"
	//	+ "<td><form method=\"post\" action=\"items.jsp\">"
		//+ "<input name=\"btnRemove\" type=\"submit\" value=\"Remove\" class=\"btn btn-danger\">"
	//	+ "<input name=\"itemID\" type=\"hidden\" value=\"" + PaymentID
	//	+ "\">" + "</form></td></tr>";
		}
		con.close();
		// Complete the html table
		output += "</table>";
		}
		catch (Exception e)
		{
		output = "Error while reading the items.";
		System.err.println(e.getMessage());
		}
		return output;
		} 
		
		public String deletePayment(String PaymentID)
		{
		String output = "";
		try
		{
		Connection con = connect();
		if (con == null)
		{return "Error while connecting to the database for deleting."; }
		// create a prepared statement
		String query = "delete from payment where paymentid=?";
		PreparedStatement preparedStmt = con.prepareStatement(query);
		// binding values
		preparedStmt.setInt(1, Integer.parseInt(PaymentID));
		// execute the statement
		preparedStmt.execute();
		con.close();
		output = "Deleted successfully";
		}
		catch (Exception e)
		{
		output = "Error while deleting the item.";
		System.err.println(e.getMessage());
		}
		return output;
		}
}
