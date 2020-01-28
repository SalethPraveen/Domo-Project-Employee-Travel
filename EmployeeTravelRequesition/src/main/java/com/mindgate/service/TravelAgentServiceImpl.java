package com.mindgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.dao.RequestDAOImpl;
import com.mindgate.dao.TravelAgentDAO;
import com.mindgate.pojo.RequestDetails;
import com.mindgate.pojo.TravelAgentDetails;
@Service
public class TravelAgentServiceImpl  implements TravelAgentService {
	
	@Autowired
	private TravelAgentDAO	travelAgentDAO ;

	@Override
	public boolean addAgent(TravelAgentDetails travelAgentDetails) {
		// TODO Auto-generated method stub
		return travelAgentDAO.addAgent(travelAgentDetails);
	}

	@Override
	public boolean updateAgent(int agentId, TravelAgentDetails travelAgentDetails) {
		// TODO Auto-generated method stub
		return travelAgentDAO.updateAgent(agentId, travelAgentDetails);
	}

	@Override
	public boolean deleteAgent(int agentId) {
		// TODO Auto-generated method stub
		return travelAgentDAO.deleteAgent(agentId);
	}

	@Override
	public TravelAgentDetails getAgent(int agentId) {
		// TODO Auto-generated method stub
		return travelAgentDAO.getAgent(agentId);
	}

	@Override
	public List<TravelAgentDetails> getAllAgent() {
		// TODO Auto-generated method stub
		return travelAgentDAO.getAllAgent();
	}
	//travelAgentLogin
	public TravelAgentDetails agentLogin(TravelAgentDetails travelAgentDetails) {
		return  travelAgentDAO.agentLogin(travelAgentDetails);
	}

	
	
	
}
