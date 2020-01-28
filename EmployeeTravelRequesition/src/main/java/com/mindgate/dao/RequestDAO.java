package com.mindgate.dao;

import java.util.List;

import com.mindgate.pojo.RequestDetails;

public interface RequestDAO {

	public boolean addRequest(RequestDetails requestdetails);

	public boolean updateRequest(int requestId, RequestDetails requestdetails);
	// public boolean approveRequest(int requestId, RequestDetails
	// requestdetails);
	// public boolean rejectRequest(int requestId, RequestDetails
	// requestdetails);

	public boolean deleteRequest(int requestId);

	public RequestDetails getRequest(int requestId);

	public List<RequestDetails> getAllRequest();

	public List<RequestDetails> getAllNewRequest();

	public boolean updateRequestStatus(int requestId, RequestDetails requestDetails);

	public List<RequestDetails> getRejectedList();

	public List<RequestDetails> getTravelApproveList();// public boolean
														// updateMDRequestStatus(int
														// requestId,RequestDetails
														// details);

	// public boolean mdRejectStatus(int requestId, RequestDetails
	// requestDetails);

	public boolean getSlabDetails(int requestId);
	
	public List<RequestDetails> managerviewrequest();

}
