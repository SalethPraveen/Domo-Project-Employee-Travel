package com.mindgate.pojo;

import org.springframework.stereotype.Component;

@Component
public class EmployeeDetails {
	//emp_master table
	private int employeeId;
	private String firstName;
	private String lastName;
	
	private String designation;
	
	private String eMail;
	private String mobileNumber;
	private String DateOfBirth;
	private String password;
	private SlabDetails slabDetails;
	private String ManagerId;
	

	public EmployeeDetails() {
		// TODO Auto-generated constructor stub
	}


	public EmployeeDetails(int employeeId, String firstName, String lastName, String designation, String eMail,
			String mobileNumber, String dateOfBirth, String password, SlabDetails slabDetails, String managerId) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.eMail = eMail;
		this.mobileNumber = mobileNumber;
		DateOfBirth = dateOfBirth;
		this.password = password;
		this.slabDetails = slabDetails;
		ManagerId = managerId;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
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


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public String geteMail() {
		return eMail;
	}


	public void seteMail(String eMail) {
		this.eMail = eMail;
	}


	public String getMobileNumber() {
		return mobileNumber;
	}


	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}


	public String getDateOfBirth() {
		return DateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public SlabDetails getSlabDetails() {
		return slabDetails;
	}


	public void setSlabDetails(SlabDetails slabDetails) {
		this.slabDetails = slabDetails;
	}


	public String getManagerId() {
		return ManagerId;
	}


	public void setManagerId(String managerId) {
		ManagerId = managerId;
	}


	@Override
	public String toString() {
		return "EmployeeDetails [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", designation=" + designation + ", eMail=" + eMail + ", mobileNumber=" + mobileNumber
				+ ", DateOfBirth=" + DateOfBirth + ", password=" + password + ", slabDetails=" + slabDetails
				+ ", ManagerId=" + ManagerId + "]";
	}

	
}
