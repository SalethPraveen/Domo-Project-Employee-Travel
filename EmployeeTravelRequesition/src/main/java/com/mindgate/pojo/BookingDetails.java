package com.mindgate.pojo;

import org.springframework.stereotype.Component;

@Component
public class BookingDetails {
	//booking_detail table
	private int bookingId;
	private RequestDetails requestDetails;
	private String bookingDate;
	private int totalfare;
	private String bookingStatus;
	private String hotelName;
	private int roomNumber;
	private int seatNumber;
	private TravelAgentDetails travelAgentDetails;
	public BookingDetails() {
		// TODO Auto-generated constructor stub
	}
	public BookingDetails(int bookingId, RequestDetails requestDetails, String bookingDate, int totalfare,
			String bookingStatus, String hotelName, int roomNumber, int seatNumber,
			TravelAgentDetails travelAgentDetails) {
		super();
		this.bookingId = bookingId;
		this.requestDetails = requestDetails;
		this.bookingDate = bookingDate;
		this.totalfare = totalfare;
		this.bookingStatus = bookingStatus;
		this.hotelName = hotelName;
		this.roomNumber = roomNumber;
		this.seatNumber = seatNumber;
		this.travelAgentDetails = travelAgentDetails;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public RequestDetails getRequestDetails() {
		return requestDetails;
	}
	public void setRequestDetails(RequestDetails requestDetails) {
		this.requestDetails = requestDetails;
	}
	public String getBookingDate() {
		return bookingDate;
	}
	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}
	public int getTotalfare() {
		return totalfare;
	}
	public void setTotalfare(int totalfare) {
		this.totalfare = totalfare;
	}
	public String getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public TravelAgentDetails getTravelAgentDetails() {
		return travelAgentDetails;
	}
	public void setTravelAgentDetails(TravelAgentDetails travelAgentDetails) {
		this.travelAgentDetails = travelAgentDetails;
	}
	@Override
	public String toString() {
		return "BookingDetails [bookingId=" + bookingId + ", requestDetails=" + requestDetails + ", bookingDate="
				+ bookingDate + ", totalfare=" + totalfare + ", bookingStatus=" + bookingStatus + ", hotelName="
				+ hotelName + ", roomNumber=" + roomNumber + ", seatNumber=" + seatNumber + ", travelAgentDetails="
				+ travelAgentDetails + "]";
	}
	
}