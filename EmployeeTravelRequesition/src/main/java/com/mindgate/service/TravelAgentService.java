package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.RequestDetails;
import com.mindgate.pojo.TravelAgentDetails;

public interface TravelAgentService {
	
	public boolean addAgent(TravelAgentDetails travelAgentDetails);

	public boolean updateAgent(int agentId, TravelAgentDetails travelAgentDetails);

	public boolean deleteAgent(int agentId);

	public TravelAgentDetails getAgent(int agentId);

	public List<TravelAgentDetails> getAllAgent();

	//travelAgentLogin
	public TravelAgentDetails agentLogin(TravelAgentDetails travelAgentDetails);

}
