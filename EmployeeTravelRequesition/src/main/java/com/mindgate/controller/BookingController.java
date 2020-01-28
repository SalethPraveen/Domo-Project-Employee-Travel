package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.pojo.BookingDetails;
import com.mindgate.service.BookingServiceimpl;
@CrossOrigin(value ="*")
@RestController
@RequestMapping("/booking")
public class BookingController {
	@Autowired
	private BookingServiceimpl bookingService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public boolean addBooking(@RequestBody BookingDetails bookingdetails) {
		System.out.println("controller -------------");
		System.out.println(bookingdetails);
		return bookingService.addBooking(bookingdetails);
	}

	@RequestMapping(value = "/{bookingId}", method = RequestMethod.PUT)
	public boolean updateBooking(@PathVariable("bookingId") int bookingId, @RequestBody BookingDetails bookingdetails) {
		System.out.println(bookingId);
		
		return bookingService.updateBooking(bookingId, bookingdetails);
	}

	@RequestMapping(value = "/{bookingId}", method = RequestMethod.DELETE)
	public boolean deleteBooking(@PathVariable("bookingId") int bookingId) {
		return bookingService.deleteBooking(bookingId);

	}

	@RequestMapping(value = "/{bookingId}", method = RequestMethod.GET)
	public BookingDetails getRequest(@PathVariable("bookingId") int bookingId) {
		return bookingService.getBooking(bookingId);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<BookingDetails> getAllBooking() {
		//System.out.println("HI");
		return bookingService.getAllBooking();

	}
	@RequestMapping(value = "/agentupdatebooking/{requestId}", method = RequestMethod.PUT)
	public boolean agentupdateBookingStatus(int requestId, BookingDetails bookingDetails)
	{
		return bookingService.agentupdateBookingStatus(requestId, bookingDetails);
	}

}
