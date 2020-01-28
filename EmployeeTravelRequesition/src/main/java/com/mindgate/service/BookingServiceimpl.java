package com.mindgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.dao.BookingDAO;
import com.mindgate.pojo.BookingDetails;

@Service
public class BookingServiceimpl implements BookingService {
	@Autowired
    private BookingDAO bookingDAO;
	@Override
	public boolean addBooking(BookingDetails bookingDetails) {
		return bookingDAO.addBooking(bookingDetails);
	}

	@Override
	public boolean updateBooking(int bookingId, BookingDetails bookingDetails) {
		return bookingDAO.updateBooking(bookingId, bookingDetails);
	}

	@Override
	public boolean deleteBooking(int bookingId) {
		return bookingDAO.deleteBooking(bookingId);
	}

	@Override
	public BookingDetails getBooking(int bookingId) {
		return bookingDAO.getBooking(bookingId);
	}

	@Override
	public List<BookingDetails> getAllBooking() {
				return bookingDAO.getAllBooking();
	}

	@Override
	public boolean agentupdateBookingStatus(int requestId, BookingDetails bookingDetails) {
		
		return bookingDAO.agentupdateBookingStatus(requestId, bookingDetails);
	}
	
}