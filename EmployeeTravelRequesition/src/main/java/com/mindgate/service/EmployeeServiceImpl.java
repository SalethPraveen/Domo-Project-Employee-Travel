package com.mindgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.dao.EmployeeDAOimpl;
import com.mindgate.pojo.EmployeeDetails;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeDAOimpl employeeDAO;
	
	@Override
	public boolean addEmployee(EmployeeDetails employeeDetails) {
	    
		return employeeDAO.addEmployee(employeeDetails);
	}

	@Override
	public boolean updateEmployee(int employeeId, EmployeeDetails employeeDetails) {
		
		return employeeDAO.updateEmployee(employeeId,employeeDetails);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		
		return employeeDAO.deleteEmployee(employeeId);
	}

	@Override
	public EmployeeDetails getEmployee(int employeeId) {
		
		return employeeDAO.getEmployee(employeeId);
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		return  employeeDAO.getAllEmployees();
	}

	@Override
	public EmployeeDetails loginEmployee(EmployeeDetails employeedetails) {
		// TODO Auto-generated method stub
		return  employeeDAO.loginEmployee( employeedetails);
	}

}
