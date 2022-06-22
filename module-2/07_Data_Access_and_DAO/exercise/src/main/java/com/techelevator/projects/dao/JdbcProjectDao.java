package com.techelevator.projects.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.projects.model.Project;

public class JdbcProjectDao implements ProjectDao {

	private final JdbcTemplate jdbcTemplate;

	public JdbcProjectDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Project getProject(int projectId) {
		//STEP 1: Declare the variable you want to return
		Project project = null;

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "SELECT project_id, name, from_date, to_date " +
					 "FROM project " +
					 "WHERE project_id = ?;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, projectId);

		//STEP 4: If we have results and need to transfer them to objects, do that here
		if (results.next()) {
			project = mapRowToProject(results);
		}

		//STEP 5: Return the result if necessary
		return project;
	}

	@Override
	public List<Project> getAllProjects() {

		//STEP 1: Declare the variable you want to return
		List<Project> projects = new ArrayList<>();

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "SELECT project_id, name, from_date, to_date " +
					 "FROM project;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

		//STEP 4: If we have results and need to transfer them to objects, do that here
		while (results.next()) {
			projects.add(mapRowToProject(results));
		}

		//STEP 5: Return the result if necessary
		return projects;

	}

	@Override
	public Project createProject(Project newProject) {

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql = "INSERT INTO project (name, from_date, to_date) " +
					 "VALUES (?, ?, ?) RETURNING project_id;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
				newProject.getName(), newProject.getFromDate(), newProject.getToDate());

		//STEP 5: Return the result if necessary
		return getProject(newId);
	}

	@Override
	public void deleteProject(int projectId) {

		//STEP 2: Write out the SQL you want to execute and save it to a string
		String sql1 = "DELETE FROM project_employee WHERE project_id = ?;";
		String sql2 = "DELETE FROM project WHERE project_id = ?;";

		//STEP 3: Send the SQL to the database and then store the results if necessary
		jdbcTemplate.update(sql1, projectId);
		jdbcTemplate.update(sql2, projectId);
	}
	
	private Project mapRowToProject(SqlRowSet rowSet) {
		Project project = new Project();
		project.setId(rowSet.getInt("project_id"));
		project.setName(rowSet.getString("name"));
		if(rowSet.getDate("from_date") != null) {
			project.setFromDate(rowSet.getDate("from_date").toLocalDate());
		}
		if(rowSet.getDate("to_date") != null) {
			project.setToDate(rowSet.getDate("to_date").toLocalDate());
		}
		return project;
	}

}
