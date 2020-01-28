package com.mindgate.service;

import java.util.List;

import com.mindgate.pojo.EmployeeDetails;

public interface EmployeeService {
	
	public boolean addEmployee(EmployeeDetails employeeDetails);

	public boolean updateEmployee(int employeeId, EmployeeDetails employeeDetails);

	public boolean deleteEmployee(int employeeId);

	public EmployeeDetails getEmployee(int employeeId);

	public List<EmployeeDetails> getAllEmployees();
	
	public EmployeeDetails loginEmployee(EmployeeDetails employeedetails);
}
