package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Department;

public class JdbcDepartmentDao implements DepartmentDao {
	
	private final JdbcTemplate jdbcTemplate;

	public JdbcDepartmentDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Department getDepartment(int id) {

		//STEP 1: Declare the variable you want to return
		Department department = null;

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "SELECT department_id, name " +
					 "FROM department " +
					 "WHERE department_id = ?;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

		//STEP 4: If we have results and need to transfer them to objects, do that here
		if (results.next()) {
			department = mapRowToDepartment(results);
		}

		//STEP 5: Return the result if necessary
		return department;
	}

	@Override
	public List<Department> getAllDepartments() {

		//STEP 1: Declare the variable you want to return
		List<Department> departments = new ArrayList<>();

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "SELECT department_id, name " +
					 "FROM department;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		//STEP 4: If we have results and need to transfer them to objects, do that here
		while (results.next()) {
			departments.add(mapRowToDepartment(results));
		}

		//STEP 5: Return the result if necessary
		return departments;
	}

	@Override
	public void updateDepartment(Department updatedDepartment) {

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "UPDATE department " +
					 "SET name = ? " +
					 "WHERE department_id = ?;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		jdbcTemplate.update(sql, updatedDepartment.getName(), updatedDepartment.getId());

	}

	private Department mapRowToDepartment(SqlRowSet rowSet) {
		Department department = new Department();
		department.setId(rowSet.getInt("department_id"));
		department.setName(rowSet.getString("name"));
		return department;
	}
}
