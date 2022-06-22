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
		List<Employee> employees = new ArrayList<>();

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
					 "FROM employee;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		//STEP 4: If we have results and need to transfer them to objects, do that here
		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}

		//STEP 5: Return the result if necessary
		return employees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {

		//STEP 1: Declare the variable you want to return
		List<Employee> employee = new ArrayList<>();

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "SELECT employee_id, department_id, first_name, last_name, birth_date, hire_date " +
					 "FROM employee " +
					 "WHERE first_name ILIKE ? AND last_name ILIKE ?;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		String firstNameSearchWithWildcards = "%" + firstNameSearch + "%";
		String lastNameSearchWithWildcards = "%" + lastNameSearch + "%";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, firstNameSearchWithWildcards, lastNameSearchWithWildcards);

		//STEP 4: If we have results and need to transfer them to objects, do that here
		while (results.next()) {
			employee.add(mapRowToEmployee(results));
		}

		//STEP 5: Return the result if necessary
		return employee;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(int projectId) {

		//STEP 1: Declare the variable you want to return
		List<Employee> employees = new ArrayList<>();

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date " +
					 "FROM employee " +
					 "JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
					 "JOIN project ON project_employee.project_id = project.project_id " +
					 "WHERE project.project_id = ?;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		//STEP 4: If we have results and need to transfer them to objects, do that here
		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}

		//STEP 5: Return the result if necessary
		return employees;
	}

	@Override
	public void addEmployeeToProject(int projectId, int employeeId) {

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "INSERT INTO project_employee(project_id, employee_id) " +
					 "VALUES (?, ?);";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		jdbcTemplate.update(sql, projectId, employeeId);

	}

	@Override
	public void removeEmployeeFromProject(int projectId, int employeeId) {

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "DELETE FROM project_employee WHERE project_id = ? AND employee_id = ?;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		jdbcTemplate.update(sql, projectId, employeeId);

	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		//STEP 1: Declare the variable you want to return
		List<Employee> employees = new ArrayList<>();

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "SELECT employee.employee_id, department_id, first_name, last_name, birth_date, hire_date, project_employee.project_id " +
					 "FROM employee " +
					 "LEFT JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
					 "WHERE project_employee.project_id IS NULL;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		//STEP 4: If we have results and need to transfer them to objects, do that here
		while (results.next()) {
			employees.add(mapRowToEmployee(results));
		}

		//STEP 5: Return the result if necessary
		return employees;
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
