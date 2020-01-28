package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.BookingDetails;


public interface BookingService {
	

	public boolean addBooking(BookingDetails bookingDetails);

	public boolean updateBooking(int bookingId, BookingDetails bookingDetails);

	public boolean deleteBooking(int bookingId);

	public BookingDetails getBooking(int bookingId);

	public List<BookingDetails> getAllBooking();
	
	public boolean agentupdateBookingStatus(int requestId, BookingDetails bookingDetails);

}
