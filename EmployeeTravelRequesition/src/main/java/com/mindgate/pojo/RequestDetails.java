package com.mindgate.pojo;

import java.sql.Timestamp;

import org.springframework.stereotype.Component;

@Component
public class RequestDetails {

	private int requestId;
	private EmployeeDetails employeeDetails;
	private String purposeTrip;
	
	private String fromLocation;
	private String toLocation;
	private String status;
	private String remarks;
	private String internationalTrip;
	private int forEx;
	private int seatNo;
	private Timestamp fromDate; 
	private Timestamp toDate;
	
	public RequestDetails() {
		// TODO Auto-generated constructor stub
	}

	public RequestDetails(int requestId, EmployeeDetails employeeDetails, String purposeTrip, String fromLocation,
			String toLocation, String status, String remarks, String internationalTrip, int forEx, int seatNo,
			Timestamp fromDate, Timestamp toDate) {
		super();
		this.requestId = requestId;
		this.employeeDetails = employeeDetails;
		this.purposeTrip = purposeTrip;
		this.fromLocation = fromLocation;
		this.toLocation = toLocation;
		this.status = status;
		this.remarks = remarks;
		this.internationalTrip = internationalTrip;
		this.forEx = forEx;
		this.seatNo = seatNo;
		this.fromDate = fromDate;
		this.toDate = toDate;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public EmployeeDetails getEmployeeDetails() {
		return employeeDetails;
	}

	public void setEmployeeDetails(EmployeeDetails employeeDetails) {
		this.employeeDetails = employeeDetails;
	}

	public String getPurposeTrip() {
		return purposeTrip;
	}

	public void setPurposeTrip(String purposeTrip) {
		this.purposeTrip = purposeTrip;
	}

	public String getFromLocation() {
		return fromLocation;
	}

	public void setFromLocation(String fromLocation) {
		this.fromLocation = fromLocation;
	}

	public String getToLocation() {
		return toLocation;
	}

	public void setToLocation(String toLocation) {
		this.toLocation = toLocation;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getInternationalTrip() {
		return internationalTrip;
	}

	public void setInternationalTrip(String internationalTrip) {
		this.internationalTrip = internationalTrip;
	}

	public int getForEx() {
		return forEx;
	}

	public void setForEx(int forEx) {
		this.forEx = forEx;
	}

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public Timestamp getFromDate() {
		return fromDate;
	}

	public void setFromDate(Timestamp fromDate) {
		this.fromDate = fromDate;
	}

	public Timestamp getToDate() {
		return toDate;
	}

	public void setToDate(Timestamp toDate) {
		this.toDate = toDate;
	}

	@Override
	public String toString() {
		return "RequestDetails [requestId=" + requestId + ", employeeDetails=" + employeeDetails + ", purposeTrip="
				+ purposeTrip + ", fromLocation=" + fromLocation + ", toLocation=" + toLocation + ", status=" + status
				+ ", remarks=" + remarks + ", internationalTrip=" + internationalTrip + ", forEx=" + forEx + ", seatNo="
				+ seatNo + ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}

	

		}