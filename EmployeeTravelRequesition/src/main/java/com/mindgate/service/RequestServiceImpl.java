package com.mindgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.dao.RequestDAO;
import com.mindgate.pojo.RequestDetails;

@Service
public class RequestServiceImpl implements RequestService {
	@Autowired
	private RequestDAO requestDAO;

	@Override
	public boolean addRequest(RequestDetails requestdetails) {
		// TODO Auto-generated method stub
		return requestDAO.addRequest(requestdetails);
	}

	@Override
	public boolean updateRequest(int requestId, RequestDetails requestdetails) {
		// TODO Auto-generated method stub
		return requestDAO.updateRequest(requestId, requestdetails);
	}
	/*
	 * public boolean approveRequest(int requestId, RequestDetails
	 * requestdetails) { // TODO Auto-generated method stub return
	 * requestDAO.approveRequest(requestId, requestdetails); } public boolean
	 * rejectRequest(int requestId, RequestDetails requestdetails) { // TODO
	 * Auto-generated method stub return requestDAO.rejectRequest(requestId,
	 * requestdetails); }
	 */

	@Override
	public boolean deleteRequest(int requestId) {
		// TODO Auto-generated method stub
		return requestDAO.deleteRequest(requestId);
	}

	@Override
	public RequestDetails getRequest(int requestId) {
		// TODO Auto-generated method stub
		return requestDAO.getRequest(requestId);
	}

	@Override
	public List<RequestDetails> getAllRequest() {
		// TODO Auto-generated method stub
		return requestDAO.getAllRequest();
	}

	public boolean updateRequestStatus(int requestId, RequestDetails requestDetails) {

		return requestDAO.updateRequestStatus(requestId, requestDetails);
	}

	@Override
	public List<RequestDetails> getRejectedList() {
		// TODO Auto-generated method stub
		return requestDAO.getRejectedList();
	}

	@Override
	public List<RequestDetails> getTravelApproveList() {
		// TODO Auto-generated method stub
		return requestDAO.getTravelApproveList();
	}

	@Override
	public List<RequestDetails> getAllNewRequest() {
		// TODO Auto-generated method stub
		return requestDAO.getAllNewRequest();
	}

	@Override
	public boolean getSlabDetails(int requestId) {

		return requestDAO.getSlabDetails(requestId);
	}

	@Override
	public List<RequestDetails> managerviewrequest() {
		// TODO Auto-generated method stub
		return requestDAO.managerviewrequest();
	}

	

	// public boolean mdRejectStatus(int requestId, RequestDetails
	// requestDetails) {
	//
	// return requestDAO.mdRejectStatus(requestId, requestDetails);
	// }

	/*
	 * @Override public boolean updateMDRequestStatus(int requestId,
	 * RequestDetails details) {
	 * 
	 * return requestDAO.updateMDRequestStatus(requestId, details); }
	 */

}