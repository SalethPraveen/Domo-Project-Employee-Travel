package com.mindgate.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.mindgate.pojo.EmployeeDetails;
import com.mindgate.pojo.SlabDetails;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	private String sql;
	private int count;
	@Autowired
	SlabServiceDAO slabServiceDAO;

	@Override
	public boolean addEmployee(EmployeeDetails employeeDetails) {
		
		System.out.println("in add employee");
		sql = "insert into employee_master values(Employee_Id.nextVal,?,?,?,?,?,?,?,?,?)";
		Object[] args = new Object[] { employeeDetails.getFirstName(), employeeDetails.getLastName(),
				employeeDetails.getDesignation(), employeeDetails.geteMail(), employeeDetails.getMobileNumber(),
				employeeDetails.getDateOfBirth(), employeeDetails.getPassword(),
				employeeDetails.getSlabDetails().getSlabId(),employeeDetails.getManagerId() };
		count = jdbcTemplate.update(sql, args);
		if (count > 0)
			return true;
		return false;

	}

	@Override
	public boolean updateEmployee(int employeeId, EmployeeDetails employeeDetails) {
		sql = "update employee_master set FIRST_NAME=? ,LAST_NAME=?,DESIGNATION=?,EMAIL=?,PHONE=?,DATEOFBIRTH=?,PASSWORD=?,SLAB_ID=?,MANAGER_ID=? where employee_Id = ?";

		Object[] args = new Object[] { employeeDetails.getFirstName(), employeeDetails.getLastName(),
				employeeDetails.getDesignation(), employeeDetails.geteMail(), employeeDetails.getMobileNumber(),
				employeeDetails.getDateOfBirth(), employeeDetails.getPassword(), employeeId, employeeDetails.getSlabDetails().getSlabId(),employeeDetails.getManagerId()
				};

		count = jdbcTemplate.update(sql, args);

		System.out.println("Update Count :: " + count);
		if (count > 0)
			return true;
		return true;

	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub

		sql = "delete from employee_master where employee_Id = ?";

		Object[] args = new Object[] { employeeId };

		count = jdbcTemplate.update(sql, args);

		System.out.println("Delete Count :: " + count);
		if (count > 0)
			return true;
		return true;

	}

	@Override
	public EmployeeDetails getEmployee(int employeeId) {

		sql = "select * from employee_master where employee_Id = ?";
		Object[] args = new Object[] { employeeId };

		EmployeeDetails employee = jdbcTemplate.queryForObject(sql, args, new EmployeeRowMapper() {
		});
		return employee;
	}

	@Override
	public List<EmployeeDetails> getAllEmployees() {
		sql = "select * from employee_master";

		List<EmployeeDetails> employeeList = new ArrayList<EmployeeDetails>();

		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

		for (Map<String, Object> map : rows) {
			EmployeeDetails employee = new EmployeeDetails();

			employee.setEmployeeId(Integer.parseInt(map.get("employee_Id").toString()));
			employee.setFirstName(map.get("first_name").toString());
			employee.setLastName(map.get("last_name").toString());
			employee.setDesignation(map.get("designation").toString());
			employee.seteMail(map.get("email").toString());
			employee.setMobileNumber(map.get("phone").toString());
			employee.setDateOfBirth(map.get("dateofbirth").toString());
			employee.setPassword(map.get("password").toString());
			employee.setManagerId(map.get("manager_id").toString());
			// we want to slab details

			int slabId = Integer.valueOf(map.get("Slab_Id").toString());

			SlabDetails slabDetails = slabServiceDAO.getSlab(slabId);
			if (slabDetails == null)
				employee.setSlabDetails(new SlabDetails());
			else
				employee.setSlabDetails(slabDetails);
			System.out.println(employee);

			employeeList.add(employee);
		}

		return employeeList;

	}

	class EmployeeRowMapper implements RowMapper<EmployeeDetails> {

		@Override
		public EmployeeDetails mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmployeeDetails employee = new EmployeeDetails();
			employee.setEmployeeId(rs.getInt("employee_Id"));
			employee.setFirstName(rs.getString("first_name"));
			employee.setLastName(rs.getString("last_name"));
			employee.setDesignation(rs.getString("designation").toString());
			employee.seteMail(rs.getString("email").toString());
			employee.setMobileNumber((rs.getString("phone")));
			employee.setDateOfBirth(rs.getString("dateofbirth").toString());
			employee.setPassword(rs.getString("password").toString());
			employee.setManagerId(rs.getString("manager_id").toString());
			int slabId = Integer.valueOf(rs.getString("Slab_Id"));
			SlabDetails slabDetails = slabServiceDAO.getSlab(slabId);
			if (slabDetails == null)
				employee.setSlabDetails(new SlabDetails());
			else
				employee.setSlabDetails(slabDetails);

			return employee;
		}

	}

	@Override
	public EmployeeDetails loginEmployee(EmployeeDetails employeeDetails) {
		EmployeeDetails employeeDetail = new EmployeeDetails();
		
		try {
			int employeeId = employeeDetails.getEmployeeId();
			System.out.println(employeeId);
			
			String password = employeeDetails.getPassword();
			System.out.println(password);

			System.out.println("--------------------------------");

			sql = "select * from employee_master where EMPLOYEE_ID=? and PASSWORD=?";

			Object[] args = new Object[] { employeeId, password };

			employeeDetail = jdbcTemplate.queryForObject(sql, args, new EmployeeRowMapper() {
			});
			System.out.println(employeeDetail);
			return employeeDetail;
		
		}

		catch (Exception e) {
			
			
			System.out.println(e);

			
		}
		return employeeDetail;

	}

}


