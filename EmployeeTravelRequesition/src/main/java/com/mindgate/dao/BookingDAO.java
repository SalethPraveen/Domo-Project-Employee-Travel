package com.mindgate.dao;

import java.util.List;

import com.mindgate.pojo.BookingDetails;


public interface BookingDAO {
	public boolean addBooking(BookingDetails bookingDetails);

	public boolean updateBooking(int bookingId, BookingDetails bookingDetails);

	public boolean deleteBooking(int bookingId);

	public BookingDetails getBooking(int bookingId);

	public List<BookingDetails> getAllBooking();
	
	public boolean agentupdateBookingStatus(int requestId, BookingDetails bookingDetails);


}
