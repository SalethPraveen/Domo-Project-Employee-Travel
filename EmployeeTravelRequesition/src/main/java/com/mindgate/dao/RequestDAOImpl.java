package com.mindgate.dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jayway.jsonpath.internal.function.numeric.Max;
import com.mindgate.pojo.EmployeeDetails;
import com.mindgate.pojo.RequestDetails;
import com.mindgate.pojo.SlabDetails;

@Repository
public class RequestDAOImpl implements RequestDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;
	private int count;

	@Autowired
	EmployeeDAO employeeDAO;

	@Override
	public boolean addRequest(RequestDetails requestdetails) {
		// TODO Auto-generated method stub
		System.out.println("in dao request");
		sql = "insert into request_master values(request_Id.nextVal,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] args = new Object[] { requestdetails.getEmployeeDetails().getEmployeeId(),
				requestdetails.getPurposeTrip(), requestdetails.getFromLocation(), requestdetails.getToLocation(),
				"NEW", "NOTHING", requestdetails.getInternationalTrip(), requestdetails.getForEx(),
				20, requestdetails.getFromDate(), requestdetails.getToDate() };
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;

		return false;
	}

	@Override
	public boolean updateRequest(int requestId, RequestDetails requestdetails) {
		// TODO Auto-generated method stub

		sql = "update request_master set status =? where request_Id = ?";

		Object[] args = new Object[] { requestdetails.getStatus(), requestId };

		count = jdbcTemplate.update(sql, args);

		System.out.println("Update Count :: " + count);

		if (count > 0)
			return true;

		return false;
	}

	@Override
	public boolean deleteRequest(int requestId) {
		// TODO Auto-generated method stub

		sql = "delete from request_master where request_Id = ?";

		Object[] args = new Object[] { requestId };

		count = jdbcTemplate.update(sql, args);

		System.out.println("Delete Count :: " + count);

		if (count > 0)
			return true;

		return false;
	}

	@Override
	public RequestDetails getRequest(int requestId) {
		// TODO Auto-generated method stub

		sql = "select * from request_master where request_Id = ?";
		Object[] args = new Object[] { requestId };
		RequestDetails requestDetails = jdbcTemplate.queryForObject(sql, args, new RequestDetailsRowMapper());
		System.out.println(requestDetails);
		return requestDetails;
		// return null;
	}

	@Override
	public List<RequestDetails> getAllRequest() {
		// TODO Auto-generated method stub

		sql = "select * from request_master";

		List<RequestDetails> requestDetailsList = new ArrayList<RequestDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			RequestDetails requestobj = new RequestDetails();
			requestobj.setRequestId(Integer.parseInt(map.get("request_id").toString()));

			int employeeId = Integer.valueOf(map.get("employee_id").toString());

			EmployeeDetails employeeDetails = employeeDAO.getEmployee(employeeId);
			if (employeeDetails == null)
				requestobj.setEmployeeDetails(new EmployeeDetails());
			else
				requestobj.setEmployeeDetails(employeeDetails);

			requestobj.setPurposeTrip(map.get("purpose_trip").toString());
			requestobj.setFromLocation(map.get("from_location").toString());
			requestobj.setToLocation(map.get("to_location").toString());
			requestobj.setStatus(map.get("status").toString());
			requestobj.setRemarks(map.get("remarks").toString());
			requestobj.setInternationalTrip(map.get("INTERNATIONAL_TRIP").toString());
			requestobj.setForEx(Integer.parseInt(map.get("forex").toString()));
			requestobj.setSeatNo(Integer.parseInt(map.get("seat_No").toString()));

			System.out.println("date  =========" + Timestamp.valueOf(map.get("fromDate").toString()));

			requestobj.setFromDate(Timestamp.valueOf(map.get("fromDate").toString()));
			requestobj.setToDate(Timestamp.valueOf(map.get("toDate").toString()));

			System.out.println(requestobj);
			requestDetailsList.add(requestobj);
		}

		return requestDetailsList;
	}

	class RequestDetailsRowMapper implements RowMapper<RequestDetails> {

		@Override
		public RequestDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			RequestDetails requestobj = new RequestDetails();
			requestobj.setRequestId((rs.getInt("request_id")));
			// requestobj.setEmployeeDetails(Integer.parseInt(map.get("employee_Id").toString()));
			int employeeId = (rs.getInt("employee_id"));

			EmployeeDetails employeeDetails = employeeDAO.getEmployee(employeeId);
			if (employeeDetails == null)
				requestobj.setEmployeeDetails(new EmployeeDetails());
			else
				requestobj.setEmployeeDetails(employeeDetails);

			requestobj.setPurposeTrip(rs.getString("purpose_trip"));
			requestobj.setFromLocation(rs.getString("from_location"));
			requestobj.setToLocation(rs.getString("to_location"));
			requestobj.setStatus(rs.getString("status"));
			requestobj.setRemarks(rs.getString("remarks"));
			requestobj.setInternationalTrip(rs.getString("international_Trip"));
			requestobj.setForEx(Integer.parseInt(rs.getString("forex")));
			requestobj.setSeatNo(Integer.parseInt(rs.getString("seat_No")));
			Timestamp fromDate = rs.getTimestamp("fromDate");
			// requestobj.setFromDate(Timestamp.valueOf(rs.getString("fromDate")));
			requestobj.setFromDate(fromDate);
			Timestamp toDate = rs.getTimestamp("toDate");
			requestobj.setToDate(toDate);

			// requestobj.setToDate(Date.valueOf(rs.getString("toDate")));

			return requestobj;
		}

	}

	@Override
	public boolean updateRequestStatus(int requestId, RequestDetails requestDetails) {
		System.out.println("In Update Request");
		sql = "update request_master set status =? where request_Id = ?";

		Object[] args = new Object[] { requestDetails.getStatus(), requestId };

		count = jdbcTemplate.update(sql, args);

		System.out.println("Update Count :: " + count);

		if (count > 0)
			return true;

		return false;
	}

	// @Override
	// public boolean mdRejectStatus(int requestId, RequestDetails
	// requestDetails) {
	// sql="select * from request_master where STATUS='rejected' ";
	//
	// Object[] args = new Object[] { requestDetails.getStatus(), requestId };
	//
	// count = jdbcTemplate.update(sql, args);
	//
	// System.out.println("Update Count :: " + count);
	//
	// if (count > 0)
	// return true;
	//
	// return false;
	//
	//
	// }

	@Override
	// public boolean updateMDRequestStatus(int requestId,RequestDetails
	// details)
	public List<RequestDetails> getRejectedList() {
		sql = "select * from request_master where status='waiting for MD'";
		/*
		 * Object[] args = new Object[] { details.getStatus(), requestId };
		 * 
		 * count = jdbcTemplate.update(sql, args);
		 * 
		 * System.out.println("Update Count :: " + count); return true;
		 */

		List<RequestDetails> requestDetailsList = new ArrayList<RequestDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			RequestDetails requestobj = new RequestDetails();
			requestobj.setRequestId(Integer.parseInt(map.get("request_id").toString()));

			int employeeId = Integer.valueOf(map.get("employee_id").toString());

			EmployeeDetails employeeDetails = employeeDAO.getEmployee(employeeId);
			if (employeeDetails == null)
				requestobj.setEmployeeDetails(new EmployeeDetails());
			else
				requestobj.setEmployeeDetails(employeeDetails);

			requestobj.setPurposeTrip(map.get("purpose_trip").toString());
			requestobj.setFromLocation(map.get("from_location").toString());
			requestobj.setToLocation(map.get("to_location").toString());
			requestobj.setStatus(map.get("status").toString());
			requestobj.setRemarks(map.get("remarks").toString());
			requestobj.setInternationalTrip(map.get("INTERNATIONAL_TRIP").toString());
			requestobj.setForEx(Integer.parseInt(map.get("forex").toString()));
			requestobj.setSeatNo(Integer.parseInt(map.get("seat_No").toString()));

			System.out.println("date  =========" + Timestamp.valueOf(map.get("fromDate").toString()));

			requestobj.setFromDate(Timestamp.valueOf(map.get("fromDate").toString()));
			requestobj.setToDate(Timestamp.valueOf(map.get("toDate").toString()));

			System.out.println(requestobj);
			requestDetailsList.add(requestobj);
		}

		return requestDetailsList;
	}

	@Override
	public List<RequestDetails> getTravelApproveList() {
		// TODO Auto-generated method stub

		sql = "select * from request_master where status='approved' and REMARKS = 'NOTHING'";
		List<RequestDetails> requestDetailsList = new ArrayList<RequestDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			RequestDetails requestobj = new RequestDetails();
			requestobj.setRequestId(Integer.parseInt(map.get("request_id").toString()));

			int employeeId = Integer.valueOf(map.get("employee_id").toString());

			EmployeeDetails employeeDetails = employeeDAO.getEmployee(employeeId);
			if (employeeDetails == null)
				requestobj.setEmployeeDetails(new EmployeeDetails());
			else
				requestobj.setEmployeeDetails(employeeDetails);

			requestobj.setPurposeTrip(map.get("purpose_trip").toString());
			requestobj.setFromLocation(map.get("from_location").toString());
			requestobj.setToLocation(map.get("to_location").toString());
			requestobj.setStatus(map.get("status").toString());
			requestobj.setRemarks(map.get("remarks").toString());
			requestobj.setInternationalTrip(map.get("INTERNATIONAL_TRIP").toString());
			requestobj.setForEx(Integer.parseInt(map.get("forex").toString()));
			requestobj.setSeatNo(Integer.parseInt(map.get("seat_No").toString()));

			System.out.println("date  =========" + Timestamp.valueOf(map.get("fromDate").toString()));

			requestobj.setFromDate(Timestamp.valueOf(map.get("fromDate").toString()));
			requestobj.setToDate(Timestamp.valueOf(map.get("toDate").toString()));

			System.out.println(requestobj);
			requestDetailsList.add(requestobj);
		}

		return requestDetailsList;
	}

	@Override
	public List<RequestDetails> getAllNewRequest() {

		sql = "select * from request_master where status='NEW'";
		System.out.println(sql);
		List<RequestDetails> requestDetailsList = new ArrayList<RequestDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			RequestDetails requestobj = new RequestDetails();
			requestobj.setRequestId(Integer.parseInt(map.get("request_id").toString()));

			int employeeId = Integer.valueOf(map.get("employee_id").toString());

			EmployeeDetails employeeDetails = employeeDAO.getEmployee(employeeId);
			if (employeeDetails == null)
				requestobj.setEmployeeDetails(new EmployeeDetails());
			else
				requestobj.setEmployeeDetails(employeeDetails);

			requestobj.setPurposeTrip(map.get("purpose_trip").toString());
			requestobj.setFromLocation(map.get("from_location").toString());
			requestobj.setToLocation(map.get("to_location").toString());
			requestobj.setStatus(map.get("status").toString());
			requestobj.setRemarks(map.get("remarks").toString());
			requestobj.setInternationalTrip(map.get("INTERNATIONAL_TRIP").toString());
			requestobj.setForEx(Integer.parseInt(map.get("forex").toString()));
			requestobj.setSeatNo(Integer.parseInt(map.get("seat_No").toString()));

			System.out.println("date  =========" + Timestamp.valueOf(map.get("fromDate").toString()));

			requestobj.setFromDate(Timestamp.valueOf(map.get("fromDate").toString()));
			requestobj.setToDate(Timestamp.valueOf(map.get("toDate").toString()));

			System.out.println(requestobj);
			requestDetailsList.add(requestobj);
		}

		return requestDetailsList;
	}

	@Override
	public boolean getSlabDetails(int requestId) {
		System.out.println("in get slab details//////////////////////////////////");

		sql = "select todate - fromdate as dateDiff from request_master where request_id = ?";
		System.out.println("in get slab details");
		System.out.println(sql);
		Object[] args = new Object[] { requestId };
		Map<String, Object> dateMap = jdbcTemplate.queryForMap(sql, args);
		String tempDays = dateMap.get("DATEDIFF").toString().substring(0, 2);
		System.out.println("Temp Days :: " + tempDays.trim());
		
		int days = Integer.parseInt(tempDays.trim());

		RequestDetails details = getRequest(requestId);
		System.out.println(details);
		EmployeeDetails employeeDetails = details.getEmployeeDetails();
		SlabDetails slabDetails = employeeDetails.getSlabDetails();
		System.out.println("max days :: " + slabDetails.getMaximumNumberOfDays());
		
		if (days <= slabDetails.getMaximumNumberOfDays()) {
			return true;
		}
		 else if(days == slabDetails.getMaximumNumberOfDays()) {
				return true;
			}
		
		return false;
		 
		
	}

	@Override
	public List<RequestDetails> managerviewrequest() {
		sql="select * from request_master where status= 'waiting for MD'";
		List<RequestDetails> requestDetailsList = new ArrayList<RequestDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			RequestDetails requestobj = new RequestDetails();
			requestobj.setRequestId(Integer.parseInt(map.get("request_id").toString()));

			int employeeId = Integer.valueOf(map.get("employee_id").toString());

			EmployeeDetails employeeDetails = employeeDAO.getEmployee(employeeId);
			if (employeeDetails == null)
				requestobj.setEmployeeDetails(new EmployeeDetails());
			else
				requestobj.setEmployeeDetails(employeeDetails);

			requestobj.setPurposeTrip(map.get("purpose_trip").toString());
			requestobj.setFromLocation(map.get("from_location").toString());
			requestobj.setToLocation(map.get("to_location").toString());
			requestobj.setStatus(map.get("status").toString());
			requestobj.setRemarks(map.get("remarks").toString());
			requestobj.setInternationalTrip(map.get("INTERNATIONAL_TRIP").toString());
			requestobj.setForEx(Integer.parseInt(map.get("forex").toString()));
			requestobj.setSeatNo(Integer.parseInt(map.get("seat_No").toString()));

			System.out.println("date  =========" + Timestamp.valueOf(map.get("fromDate").toString()));

			requestobj.setFromDate(Timestamp.valueOf(map.get("fromDate").toString()));
			requestobj.setToDate(Timestamp.valueOf(map.get("toDate").toString()));

			System.out.println(requestobj);
			requestDetailsList.add(requestobj);
		}

		return requestDetailsList;
	}
}
