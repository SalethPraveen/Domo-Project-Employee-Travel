package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.SlabDetails;

public interface SlabService {
	public boolean addSlab(SlabDetails slabDetails);

	public boolean updateSlab(int slabId, SlabDetails slabDetails);

	public boolean deleteSlab(int slabId);

	public SlabDetails getSlab(int slabId);

	public List<SlabDetails> getAllSlab();

}
