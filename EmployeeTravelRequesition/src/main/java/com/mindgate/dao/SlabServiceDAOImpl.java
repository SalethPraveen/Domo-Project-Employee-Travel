package com.mindgate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.pojo.SlabDetails;

@Repository
public class SlabServiceDAOImpl implements SlabServiceDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private String sql;
	private int count;

	@Override
	public boolean addSlab(SlabDetails slabDetails) {
		// TODO Auto-generated method stub
		sql = "INSERT INTO SLAB_TABLE VALUES(slab_Id.nextVal,?,?,?,?,?,?)";
		Object[] args = new Object[] { slabDetails.getDesignation(), slabDetails.getMaximumTicketPrice(),
				slabDetails.getForEx(), slabDetails.getMaximumNumberOfDays(), 
				slabDetails.getTripMedium(),slabDetails.getInternationalTrip() };
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return true;

	}

	@Override
	public boolean updateSlab(int slabId, SlabDetails slabDetails) {
		sql = "UPDATE SLAB_TABLE SET  DESIGNATION =?, MAXIMUM_TICKET_AMOUNT= ?,FOREX=?,MAX_NUMBER_OF_DAYS=?,TRIP_MEDIUM=? ,INTERNATIONAL_TRIP=? WHERE SLAB_ID = ?";

		Object[] args = new Object[] { slabDetails.getDesignation(), slabDetails.getMaximumTicketPrice(),
				slabDetails.getForEx(), slabDetails.getMaximumNumberOfDays(), slabDetails.getTripMedium(),
				slabDetails.getInternationalTrip(), slabId };

		count = jdbcTemplate.update(sql, args);
		System.out.println();
		if (count > 0)
			return true;
		return false;

	}

	@Override
	public boolean deleteSlab(int slabId) {
		sql = "DELETE FROM SLAB_TABLE WHERE SLAB_ID = ?";

		Object[] args = new Object[] { slabId };

		count = jdbcTemplate.update(sql, args);

		System.out.println("Delete Count :: " + count);

		if (count > 0)
			return true;
		return false;
	}

	@Override
	public SlabDetails getSlab(int slabId) {
		sql = "SELECT * FROM SLAB_TABLE where SLAB_ID = ?";

		Object[] args = new Object[] { slabId };

		SlabDetails slabdetails = jdbcTemplate.queryForObject(sql, args, new RowMapper<SlabDetails>() {

			@Override
			public SlabDetails mapRow(ResultSet arg0, int arg1) throws SQLException {
				SlabDetails slabdetails = new SlabDetails();
				slabdetails.setSlabId(arg0.getInt("slab_id"));
				slabdetails.setDesignation(arg0.getString("designation"));

				slabdetails.setMaximumTicketPrice(arg0.getDouble("Maximum_Ticket_amount"));
				slabdetails.setForEx(arg0.getDouble("forex"));
				slabdetails.setMaximumNumberOfDays(arg0.getInt("max_number_of_days"));
				slabdetails.setInternationalTrip(arg0.getString("trip_medium"));
				slabdetails.setTripMedium(arg0.getString("international_trip"));
				
				return slabdetails;
			}
		});

		return slabdetails;

	}

	@Override
	public List<SlabDetails> getAllSlab() {
		sql = "select*from SLAB_TABLE";
		List<SlabDetails> slabList = new ArrayList<SlabDetails>();
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			SlabDetails slabDetails = new SlabDetails();
			slabDetails.setSlabId(Integer.parseInt(map.get("SLAB_ID").toString()));
			slabDetails.setDesignation(map.get("designation").toString());
			slabDetails.setMaximumTicketPrice(Double.parseDouble(map.get("MAXIMUM_TICKET_AMOUNT").toString()));
			slabDetails.setForEx(Double.parseDouble(map.get("forex").toString()));
			slabDetails.setMaximumNumberOfDays(Integer.parseInt(map.get("max_number_of_days").toString()));
			
			slabDetails.setTripMedium(map.get("TRIP_MEDIUM").toString());
			slabDetails.setInternationalTrip(map.get("INTERNATIONAL_TRIP").toString());
			slabList.add(slabDetails);

		}

		return slabList;
	}
	
	
	
	
	

}
