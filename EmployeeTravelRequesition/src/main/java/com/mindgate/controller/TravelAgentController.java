package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.pojo.TravelAgentDetails;
import com.mindgate.service.TravelAgentServiceImpl;
@CrossOrigin(value="*")
@RestController
@RequestMapping("agent")
public class TravelAgentController {

	@Autowired
	private TravelAgentServiceImpl agentServiceImpl;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public boolean addagent(@RequestBody TravelAgentDetails agentDetails) {
		return agentServiceImpl.addAgent(agentDetails);
	}

	@RequestMapping(value = "/{agentId}", method = RequestMethod.PUT)
	public boolean updateAgent(@PathVariable("agentId") int agentId, @RequestBody TravelAgentDetails agentDetails) {
		return agentServiceImpl.updateAgent(agentId, agentDetails);
	}

	@RequestMapping(value = "/{agentId}", method = RequestMethod.DELETE)
	public boolean deleteRequest(@PathVariable("agentId") int agentId) {
		return agentServiceImpl.deleteAgent(agentId);
	}

	@RequestMapping(value = "/{agentId}", method = RequestMethod.GET)
	public TravelAgentDetails getAgent(@PathVariable("agentId") int agentId) {
		return agentServiceImpl.getAgent(agentId);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<TravelAgentDetails> getAllAgent() {
		return agentServiceImpl.getAllAgent();
	}

	// travelAgentLogin
	@RequestMapping(value = "/agentLogin", method = RequestMethod.POST)
	public TravelAgentDetails loginEmployee(@RequestBody TravelAgentDetails travelAgentDetails) {
		System.out.println(travelAgentDetails);
		System.out.println("loginEmployee");
		return agentServiceImpl.agentLogin(travelAgentDetails);

	}
}
