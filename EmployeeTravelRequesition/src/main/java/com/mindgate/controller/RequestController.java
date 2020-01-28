package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.pojo.RequestDetails;
import com.mindgate.service.RequestServiceImpl;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("request")
public class RequestController {

	@Autowired
	private RequestServiceImpl requestServiceImpl;

	@RequestMapping(value = "/addrequest", method = RequestMethod.POST)
	public boolean addRequest(@RequestBody RequestDetails requestDetails) {
		System.out.println("in controller request----------------------------" + '\n' + requestDetails);
		return requestServiceImpl.addRequest(requestDetails);
	}

	@RequestMapping(value = "/{requestId}", method = RequestMethod.PUT)
	public boolean updateRequest(@PathVariable("requestId") int requestId, @RequestBody RequestDetails requestDetails) {
		return requestServiceImpl.updateRequest(requestId, requestDetails);
	}

	@RequestMapping(value = "/statusupdate/{requestId}", method = RequestMethod.PUT)
	public boolean updateRequestStatus(@PathVariable("requestId") int requestId,
			@RequestBody RequestDetails requestDetails) {
		System.out.println("updateRequestStatus");
		return requestServiceImpl.updateRequestStatus(requestId, requestDetails);
	}
	/*
	 * @RequestMapping(value = "/rejectstatus", method = RequestMethod.GET)
	 * public boolean updateMDRequestStatus(@PathVariable("requestId") int
	 * requestId, @RequestBody RequestDetails requestDetails) {
	 * System.out.println("updateRequestStatus"); return
	 * requestServiceImpl.updateMDRequestStatus(requestId, requestDetails); }
	 */

	/*
	 * @RequestMapping(value = "/app/{requestId}", method = RequestMethod.PUT)
	 * public boolean approveRequest(@PathVariable("requestId") int
	 * requestId, @RequestBody RequestDetails requestDetails) { return
	 * requestServiceImpl.approveRequest(requestId, requestDetails); }
	 * 
	 * @RequestMapping(value = "/rej/{requestId}", method = RequestMethod.PUT)
	 * public boolean rejectRequest(@PathVariable("requestId") int
	 * requestId, @RequestBody RequestDetails requestDetails) { return
	 * requestServiceImpl.rejectRequest(requestId, requestDetails); }
	 */

	@RequestMapping(value = "/{requestId}", method = RequestMethod.DELETE)
	public boolean deleteRequest(@PathVariable("requestId") int requestId) {
		return requestServiceImpl.deleteRequest(requestId);
	}

	@RequestMapping(value = "/{requestId}", method = RequestMethod.GET)
	public RequestDetails getRequest(@PathVariable("requestId") int requestId) {
		return requestServiceImpl.getRequest(requestId);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<RequestDetails> getAllRequest() {
		System.out.println("get all");

		return requestServiceImpl.getAllRequest();
	}

	@RequestMapping(value = "/getNewRequests", method = RequestMethod.GET)
	public List<RequestDetails> getAllNewRequest() {
		System.out.println("get all New Requests");

		return requestServiceImpl.getAllNewRequest();
	}

	@RequestMapping(value = "/reject", method = RequestMethod.GET)
	public List<RequestDetails> getRejectedList() {
		System.out.println("md goisng list get all");

		return requestServiceImpl.getRejectedList();
	}

	@RequestMapping(value = "/travelAgentGetList", method = RequestMethod.GET)
	public List<RequestDetails> getTravelApproveList() {
		System.out.println("travel going list get all");

		return requestServiceImpl.getTravelApproveList();
	}

	@RequestMapping(value = "/getslabdetails/{requestId}", method = RequestMethod.GET)
	public boolean getSlabDetails(@PathVariable("requestId") int requestId) {
		return requestServiceImpl.getSlabDetails(requestId);
	}

	@RequestMapping(value = "/managerviewrequest", method = RequestMethod.GET)
	public List<RequestDetails> managerviewrequest() {
		System.out.println("get all");
		return requestServiceImpl.managerviewrequest();
		}

	
}