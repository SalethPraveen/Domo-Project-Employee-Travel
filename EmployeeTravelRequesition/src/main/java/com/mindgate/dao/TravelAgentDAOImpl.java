package com.mindgate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.TraversableResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.dao.RequestDAOImpl.RequestDetailsRowMapper;
import com.mindgate.pojo.RequestDetails;
import com.mindgate.pojo.TravelAgentDetails;

@Repository
public class TravelAgentDAOImpl implements TravelAgentDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;
	private int count;
	
	

	@Override
	public boolean addAgent(TravelAgentDetails travelAgentDetails) {
		sql = "insert into travel_agent_master values(AGENT_ID.nextval,?,?,?,?,?)";
		Object[] args = new Object[] {  travelAgentDetails.getPassword(),
				travelAgentDetails.getFirstName(), travelAgentDetails.getLastName(),
				travelAgentDetails.getMobileNumber(), travelAgentDetails.getEmail() };
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;

		return false;
	}

	@Override
	public boolean updateAgent(int agentId, TravelAgentDetails travelAgentDetails) {
		sql = "update travel_agent_master set password = ?,first_name =?,last_name =?, mobile_number=?, agent_email=? where agent_Id = ?";

		Object[] args = new Object[] { travelAgentDetails.getPassword(), travelAgentDetails.getFirstName(), travelAgentDetails.getLastName(), travelAgentDetails.getMobileNumber(), travelAgentDetails.getEmail(), agentId};

		count = jdbcTemplate.update(sql, args);

		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteAgent(int agentId) {
		// TODO Auto-generated method stub
		
		sql = "delete from travel_agent_master where agent_Id = ?";

		Object[] args = new Object[] { agentId };

		count = jdbcTemplate.update(sql, args);

		System.out.println("Delete Count :: " + count);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public TravelAgentDetails getAgent(int agentId) {
		// TODO Auto-generated method stub
		
		sql = "select * from travel_agent_master where agent_Id = ?";
		Object[] args = new Object[] { agentId };

		TravelAgentDetails travelAgentDetails = jdbcTemplate.queryForObject(sql, args, new TravelAgentDetailsRowMapper());
		return travelAgentDetails;
		
		//return null;
	}

	@Override
	public List<TravelAgentDetails> getAllAgent() {
		// TODO Auto-generated method stub
		
		
		sql = "select * from travel_agent_master";

		List<TravelAgentDetails> agentDetails = new ArrayList<TravelAgentDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			TravelAgentDetails agentDetails1 = new TravelAgentDetails();
			agentDetails1.setAgentId(Integer.parseInt(map.get("agent_id").toString()));
			agentDetails1.setPassword(map.get("password").toString());
			agentDetails1.setFirstName(map.get("first_name").toString());
			agentDetails1.setLastName(map.get("last_name").toString());
			agentDetails1.setMobileNumber(map.get("MOBILE_NUMBER").toString());
			agentDetails1.setEmail(map.get("AGENT_EMAIL").toString());
			agentDetails.add(agentDetails1);
		}
		return agentDetails;
	
	}
	class TravelAgentDetailsRowMapper implements RowMapper<TravelAgentDetails> 
	{

		@Override
		public TravelAgentDetails mapRow(ResultSet rs, int arg1) throws SQLException {
			// TODO Auto-generated method stub\
			
			TravelAgentDetails travelAgentDetails = new TravelAgentDetails();
			
			travelAgentDetails.setAgentId(rs.getInt("agent_id"));
			travelAgentDetails.setPassword(rs.getString("password"));
			travelAgentDetails.setFirstName(rs.getString("first_name"));
			travelAgentDetails.setLastName(rs.getString("last_name"));
			travelAgentDetails.setMobileNumber(rs.getString("mobile_number"));
			travelAgentDetails.setEmail(rs.getString("agent_email"));
			
			return travelAgentDetails;
		}
		
	}
	//travelAgentLogin
	@Override
	public TravelAgentDetails agentLogin(TravelAgentDetails travelAgentDetails)
	{
		//TravelAgentDetails travelAgentDetails = new TravelAgentDetails();
		
		
			int agentId = travelAgentDetails.getAgentId();
			System.out.println(agentId);
			
			String password = travelAgentDetails.getPassword();
			System.out.println(password);

			System.out.println("--------------------------------");

			sql = "SELECT * FROM TRAVEL_AGENT_MASTER  WHERE AGENT_ID=? AND PASSWORD=?";

			Object[] args = new Object[] { agentId, password };

			travelAgentDetails = jdbcTemplate.queryForObject(sql, args, new TravelAgentDetailsRowMapper() {
				
			
			});
			//System.out.println(travelAgentDetails);
			return travelAgentDetails;
			

	}

}
