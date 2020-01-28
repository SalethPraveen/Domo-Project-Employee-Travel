package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.pojo.SlabDetails;
import com.mindgate.service.SlabServiceImpl;
@CrossOrigin(value ="*")
@RestController
@RequestMapping("/SlabService")
public class SlabController {
	@Autowired
	private SlabServiceImpl slabservice;

	// @PostMapping("/addEmployee")

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public boolean addSlab(@RequestBody SlabDetails slabdetails) {
		System.out.println(slabdetails);
		return slabservice.addSlab(slabdetails);

	}

	@RequestMapping(value = "/{slabId}", method = RequestMethod.PUT)
	public boolean updateEmployee(@PathVariable("slabId") int slabId, @RequestBody SlabDetails slabdetails) {
System.out.println(slabdetails);
		return slabservice.updateSlab(slabId, slabdetails);
	}

	@RequestMapping(value = "/{slabId}", method = RequestMethod.DELETE)
	public boolean deleteSlab(@PathVariable("slabId") int slabId) {
		return slabservice.deleteSlab(slabId);
	}

	@RequestMapping(value = "/{slabId}", method = RequestMethod.GET)
	public SlabDetails getSlab(@PathVariable("slabId") int slabId) {
		return slabservice.getSlab(slabId);
	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<SlabDetails> getAllSlab() {
		System.out.println("in getAllEmployee");
		return slabservice.getAllSlab();
	}

}
