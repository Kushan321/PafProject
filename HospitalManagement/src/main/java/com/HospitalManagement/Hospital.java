package com.HospitalManagement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hospital {

	private String name;
	private String address;
	private String charge;
	private String phonenumber;
	private String roomcount;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCharge() {
		return charge;
	}
	public void setCharge(String charge) {
		this.charge = charge;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getRoomcount() {
		return roomcount;
	}
	public void setRoomcount(String roomcount) {
		this.roomcount = roomcount;
	}
	@Override
	public String toString() {
		return "Hospital [name=" + name + ", address=" + address + ", charge=" + charge + ", phonenumber=" + phonenumber
				+ ", roomcount=" + roomcount + "]";
	}
	
	
	
}
