package com.mindgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.dao.SlabServiceDAO;
import com.mindgate.pojo.SlabDetails;

@Service
public class SlabServiceImpl implements SlabService {
	
	public SlabServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Autowired 
	private SlabServiceDAO ServiceDAO;
	
	 

	@Override
	public boolean addSlab(SlabDetails slabDetails) {
		// TODO Auto-generated method stub
		return ServiceDAO.addSlab(slabDetails);
	}

	@Override
	public boolean updateSlab(int slabId, SlabDetails slabDetails) {
		// TODO Auto-generated method stub
		return ServiceDAO.updateSlab(slabId, slabDetails);
	}

	@Override
	public boolean deleteSlab(int slabId) {
		// TODO Auto-generated method stub
		return ServiceDAO.deleteSlab(slabId);
	}

	@Override
	public SlabDetails getSlab(int slabId) {
		// TODO Auto-generated method stub
		return ServiceDAO.getSlab(slabId);
	}

	@Override
	public List<SlabDetails> getAllSlab() {
		// TODO Auto-generated method stub
		return ServiceDAO.getAllSlab();
	}

}