package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JdbcEmployeeDao implements EmployeeDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcEmployeeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {

		//STEP 1: Declare the variable you want to return
		List<Department> departments = new ArrayList<>();

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "SELECT department_id, name " +
				"FROM department;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		//STEP 4: If we have results and need to transfer them to objects, do that here
		while (results.next()) {
			departments.add(mapRowToEmployee(results));
		}

		//STEP 5: Return the result if necessary
		return departments;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {



		return List.of(new Employee());
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {



		return new ArrayList<>();
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {


	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {


	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {



		return new ArrayList<>();
	}

	private Employee mapRowToEmployee(SqlRowSet rowSet) {
		Employee employee = new Employee();
		employee.setId(rowSet.getInt("employee_id"));
		employee.setDepartmentId(rowSet.getInt("department_id"));
		employee.setFirstName(rowSet.getString("first_name"));
		employee.setLastName(rowSet.getString("last_name"));
		if(rowSet.getDate("birth_date") != null) {
			employee.setBirthDate(rowSet.getDate("birth_date").toLocalDate());
		}
		if(rowSet.getDate("hire_date") != null) {
			employee.setHireDate(rowSet.getDate("hire_date").toLocalDate());
		}
		return employee;
	}

}
