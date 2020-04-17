package com.HospitalManagement;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hospital {

	private String name;
	private String address;
	private int charge;
	private String phonenumber;
	private int roomcount;
	
	
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
	
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public int getCharge() {
		return charge;
	}
	public void setCharge(int charge) {
		this.charge = charge;
	}
	public int getRoomcount() {
		return roomcount;
	}
	public void setRoomcount(int roomcount) {
		this.roomcount = roomcount;
	}
	@Override
	public String toString() {
		return "Hospital [name=" + name + ", address=" + address + ", charge=" + charge + ", phonenumber=" + phonenumber
				+ ", roomcount=" + roomcount + "]";
	}
	public void setHospitalid(int int1) {
		// TODO Auto-generated method stub
		
	}
	public int getHospitalid() {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	
}
