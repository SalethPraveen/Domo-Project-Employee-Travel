package com.mindgate.pojo;

import org.springframework.stereotype.Component;

@Component
public class TravelAgentDetails {
	private int agentId;
	private String password;
	private String firstName;
	private String lastName;
	private String mobileNumber;
	private String Email;
	
	
	public TravelAgentDetails() {
		// TODO Auto-generated constructor stub
	}


	public TravelAgentDetails(int agentId, String password, String firstName, String lastName, String mobileNumber,
			String email) {
		super();
		this.agentId = agentId;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mobileNumber = mobileNumber;
		this.Email = email;
	}


	public int getAgentId() {
		return agentId;
	}


	public void setAgentId(int agentId) {
		this.agentId = agentId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	@Override
	public String toString() {
		return "TravelAgentDetails [agentId=" + agentId + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", mobileNumber=" + mobileNumber + ", Email=" + Email + "]";
	}
	
	
	
	
}
