package com.mindgate.pojo;

import org.springframework.stereotype.Component;

@Component
public class SlabDetails {
	

	private int slabId;
	private String designation;
	private double maximumTicketPrice;
	private double forEx;
	private int maximumNumberOfDays;
	private String tripMedium;
	private String internationalTrip;
	
	
	public SlabDetails() {
		// TODO Auto-generated constructor stub
	}


	public SlabDetails(int slabId, String designation, double maximumTicketPrice, double forEx, int maximumNumberOfDays,
			String tripMedium, String internationalTrip) {
		super();
		this.slabId = slabId;
		this.designation = designation;
		this.maximumTicketPrice = maximumTicketPrice;
		this.forEx = forEx;
		this.maximumNumberOfDays = maximumNumberOfDays;
		this.tripMedium = tripMedium;
		this.internationalTrip = internationalTrip;
	}


	public int getSlabId() {
		return slabId;
	}


	public void setSlabId(int slabId) {
		this.slabId = slabId;
	}


	public String getDesignation() {
		return designation;
	}


	public void setDesignation(String designation) {
		this.designation = designation;
	}


	public double getMaximumTicketPrice() {
		return maximumTicketPrice;
	}


	public void setMaximumTicketPrice(double maximumTicketPrice) {
		this.maximumTicketPrice = maximumTicketPrice;
	}


	public double getForEx() {
		return forEx;
	}


	public void setForEx(double forEx) {
		this.forEx = forEx;
	}


	public int getMaximumNumberOfDays() {
		return maximumNumberOfDays;
	}


	public void setMaximumNumberOfDays(int maximumNumberOfDays) {
		this.maximumNumberOfDays = maximumNumberOfDays;
	}


	public String getTripMedium() {
		return tripMedium;
	}


	public void setTripMedium(String tripMedium) {
		this.tripMedium = tripMedium;
	}


	public String getInternationalTrip() {
		return internationalTrip;
	}


	public void setInternationalTrip(String internationalTrip) {
		this.internationalTrip = internationalTrip;
	}


	@Override
	public String toString() {
		return "SlabDetails [slabId=" + slabId + ", designation=" + designation + ", maximumTicketPrice="
				+ maximumTicketPrice + ", forEx=" + forEx + ", maximumNumberOfDays=" + maximumNumberOfDays
				+ ", tripMedium=" + tripMedium + ", internationalTrip=" + internationalTrip + "]";
	}
	
	
	
	
}