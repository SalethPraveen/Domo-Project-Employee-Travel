package com.mindgate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.pojo.BookingDetails;
import com.mindgate.pojo.RequestDetails;
import com.mindgate.pojo.TravelAgentDetails;

@Repository
public class BookingDAOimpl implements BookingDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql, sqlsub;
	private int count,count1, temprequestId;
	@Autowired
	RequestDAO requestDAO;
	@Autowired
	TravelAgentDAO travelAgentDAO;

	@Override
	public boolean addBooking(BookingDetails bookingDetails) {
		sql = "INSERT INTO BOOKING_MASTER VALUES(BOOKING_ID.NEXTVAL,?,?,?,?,?,?,?,?)";
		Object[] args = new Object[] { bookingDetails.getRequestDetails().getRequestId(),
				bookingDetails.getBookingDate(), bookingDetails.getTotalfare(), bookingDetails.getBookingStatus(),
				bookingDetails.getHotelName(), bookingDetails.getTravelAgentDetails().getAgentId(),
				bookingDetails.getRoomNumber(), bookingDetails.getSeatNumber() };
		count = jdbcTemplate.update(sql, args);
		if (count > 0) {
			
			temprequestId = bookingDetails.getRequestDetails().getRequestId();
			System.out.println(temprequestId);
			
			sqlsub = "UPDATE REQUEST_MASTER SET REMARKS ='BOOKED' WHERE REQUEST_ID = ?";
			Object[] up = new Object[] { temprequestId};
			System.out.println(sqlsub);
			
			count1 = jdbcTemplate.update(sqlsub, up);

			

		
		return true;
		}
		
	return false;

	}

	@Override
	public boolean updateBooking(int bookingId, BookingDetails bookingDetails) {
		sql = "update BOOKING_MASTER set BOOKING_DATE = ?,TOTAL_FARE= ?,BOOKING_STATUS= ?,HOTEL_NAME= ?,ROOMNO= ?,SEATNO = ? where booking_Id = ?";

		Object[] args = new Object[] { bookingDetails.getBookingDate(), bookingDetails.getTotalfare(),
				bookingDetails.getBookingStatus(), bookingDetails.getHotelName(), bookingDetails.getRoomNumber(),
				bookingDetails.getSeatNumber(), bookingId };

		System.out.println("Update Call....");

		count = jdbcTemplate.update(sql, args);

		System.out.println("Update Count=================== :: " + count);

		if (count > 0)
			return true;

		return false;
	}

	@Override
	public boolean deleteBooking(int bookingId) {
		sql = "delete from BOOKING_MASTER where booking_Id = ?";

		Object[] args = new Object[] { bookingId };

		count = jdbcTemplate.update(sql, args);

		System.out.println("Delete Count :: " + count);
		if (count > 0)
			return true;

		return false;
	}

	@Override
	public BookingDetails getBooking(int bookingId) {
		sql = "select * from BOOKING_MASTER where booking_Id = ?";
		Object[] args = new Object[] { bookingId };

		BookingDetails bookingDetails = jdbcTemplate.queryForObject(sql, args, new BookingDetailsRowMapper() {
		});
		return bookingDetails;
	}

	@Override
	public List<BookingDetails> getAllBooking() {
		sql = "select * from BOOKING_MASTER";

		List<BookingDetails> bookingList = new ArrayList<BookingDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			BookingDetails bookingDetails = new BookingDetails();
			bookingDetails.setBookingId(Integer.parseInt(map.get("booking_Id").toString()));

			int request_Id = Integer.valueOf(map.get("Request_Id").toString());

			RequestDetails requestDetails = requestDAO.getRequest(request_Id);
			if (requestDetails == null)
				bookingDetails.setRequestDetails(new RequestDetails());
			else
				bookingDetails.setRequestDetails(requestDetails);
			requestDAO.getRequest(request_Id);
			bookingDetails.setBookingDate(map.get("booking_date").toString());
			bookingDetails.setTotalfare(Integer.parseInt(map.get("total_fare").toString()));
			bookingDetails.setBookingStatus(map.get("booking_status").toString());
			bookingDetails.setHotelName(map.get("hotel_name").toString());

			int agentId = Integer.valueOf(map.get("agent_Id").toString());

			TravelAgentDetails travelAgentDetails = travelAgentDAO.getAgent(agentId);
			if (requestDetails == null)
				bookingDetails.setTravelAgentDetails(new TravelAgentDetails());
			else
				bookingDetails.setTravelAgentDetails(travelAgentDetails);

			bookingDetails.setRoomNumber(Integer.parseInt(map.get("roomno").toString()));
			bookingDetails.setRoomNumber(Integer.parseInt(map.get("seatno").toString()));
			// we want to slab details

			bookingList.add(bookingDetails);
		}

		return bookingList;
	}

	class BookingDetailsRowMapper implements RowMapper<BookingDetails> {

		@Override
		public BookingDetails mapRow(ResultSet map, int rowNum) throws SQLException {
			BookingDetails bookingDetails = new BookingDetails();
			bookingDetails.setBookingId(map.getInt("booking_Id"));

			int requestId = Integer.valueOf(map.getInt("Request_Id"));

			RequestDetails requestDetails = requestDAO.getRequest(requestId);
			if (requestDetails == null)
				bookingDetails.setRequestDetails(new RequestDetails());
			else
				bookingDetails.setRequestDetails(requestDetails);
			requestDAO.getRequest(requestId);
			bookingDetails.setBookingDate(map.getString("booking_date"));
			bookingDetails.setTotalfare((map.getInt("total_fare")));
			bookingDetails.setBookingStatus(map.getString("booking_status"));
			bookingDetails.setHotelName(map.getString("hotel_name"));

			int agentId = Integer.valueOf(map.getString("agent_Id").toString());

			TravelAgentDetails travelAgentDetails = travelAgentDAO.getAgent(agentId);
			if (requestDetails == null)
				bookingDetails.setTravelAgentDetails(new TravelAgentDetails());
			else
				bookingDetails.setTravelAgentDetails(travelAgentDetails);

			bookingDetails.setRoomNumber(Integer.parseInt(map.getString("roomno")));
			bookingDetails.setSeatNumber(Integer.parseInt(map.getString("seatno")));
			// we want to slab details

			return bookingDetails;
		}

	}

	@Override
	public boolean agentupdateBookingStatus(int requestId, BookingDetails bookingDetails) {
		sql = "update BOOKING_MASTER set BOOKING_DATE = ?,TOTAL_FARE= ?,BOOKING_STATUS= ?,HOTEL_NAME= ?,ROOMNO= ?,SEATNO = ? where request_id = ?";

		Object[] args = new Object[] { bookingDetails.getBookingDate(), bookingDetails.getTotalfare(),
				bookingDetails.getBookingStatus(), bookingDetails.getHotelName(), bookingDetails.getRoomNumber(),
				bookingDetails.getSeatNumber(), bookingDetails.getRequestDetails().getRequestId() };

		System.out.println("Update Call....");

		count = jdbcTemplate.update(sql, args);

		System.out.println("Update Count=================== :: " + count);

		if (count > 0)
			return true;

		return false;
	}

}
