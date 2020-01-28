package com.mindgate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindgate.pojo.EmployeeDetails;
import com.mindgate.service.EmployeeServiceImpl;
@CrossOrigin(value ="*")
@RestController

@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeSerivce;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public boolean addEmployee(@RequestBody EmployeeDetails employeedetails) {
		//System.out.println(employeedetails);
		System.out.println("cotroller add emp");
		return employeeSerivce.addEmployee(employeedetails);

	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<EmployeeDetails> getAllEmployee() {
		//System.out.println("in getAllEmployee");
		return employeeSerivce.getAllEmployees();

	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.PUT)
	public boolean updateEmployee(@PathVariable("employeeId") int employeeId,
			@RequestBody EmployeeDetails employeeDetails) {
		return employeeSerivce.updateEmployee(employeeId, employeeDetails);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.DELETE)
	public boolean deleteEmployee(@PathVariable("employeeId") int employeeId) {
		return employeeSerivce.deleteEmployee(employeeId);
	}

	@RequestMapping(value = "/{employeeId}", method = RequestMethod.GET)
	public EmployeeDetails getEmployee(@PathVariable("employeeId") int employeeId) {
		return employeeSerivce.getEmployee(employeeId);

	}
	
	@RequestMapping(value = "/loginEmployee", method = RequestMethod.POST)
	public EmployeeDetails loginEmployee(@RequestBody EmployeeDetails employeedetails) {
		System.out.println(employeedetails);
		System.out.println("loginEmployee");
		return employeeSerivce.loginEmployee(employeedetails);

	}
	
	

}