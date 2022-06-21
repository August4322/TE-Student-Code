package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(int parkId) {

        //STEP 1: Declare the variable you want to return
        Park park = null;

        //STEP 2: Write out the SQL you want to execute and save it to a string
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE park_id = ?;";

        //STEP 3: Send the SQL to the database and then store the results if necessary
        //          -If we expect multiple rows / columns coming back (spreadsheet) then use jdbcTemplate.queryForRowSet
        //          -If we want only one result, we can use jdbcTemplate.queryForObject
        //          -If we do an update/delete, we use jdbcTemplate.update
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);

        //STEP 4: If we have results and need to transfer them to objects, do that here
        if (results.next()) {
            park = mapRowToPark(results);
        }

        //STEP 5: Return the result if necessary
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {

        //STEP 1: Declare the variable you want to return
        List<Park> parks = new ArrayList<>();

        //STEP 2: Write out the SQL you want to execute and save it to a string
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "JOIN park_state ON park.park_id = park_state.park_id " +
                     "WHERE state_abbreviation = ?;";

        //STEP 3: Send the SQL to the database and then store the results if necessary
        //          -If we expect multiple rows / columns coming back (spreadsheet) then use jdbcTemplate.queryForRowSet
        //          -If we want only one result, we can use jdbcTemplate.queryForObject
        //          -If we do an update/delete, we use jdbcTemplate.update
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        //STEP 4: If we have results and need to transfer them to objects, do that here
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }

        //STEP 5: Return the result if necessary
        return parks;
    }

    @Override
    public Park createPark(Park park) {

        //STEP 1: Declare the variable you want to return
        //We can normally skip step 1 for creates
        //If you don't do step 1 you probably won't do step 4

        //STEP 2: Write out the SQL you want to execute and save it to a string
        String sql = "INSERT INTO park (park_id, park_name, date_established, area, has_camping) " +
                     "VALUES (?, ?, ?, ?) RETURNING park_id;";

        //STEP 3: Send the SQL to the database and then store the results if necessary
        //          -If we expect multiple rows / columns coming back (spreadsheet) then use jdbcTemplate.queryForRowSet
        //          -If we want only one result, we can use jdbcTemplate.queryForObject
        //          -If we do an update/delete, we use jdbcTemplate.update
        //Any time we are creating we will either use queryForObject or update.
        //It depends on if you want the new id of the row you created.
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                park.getParkName(), park.getDateEstablished(), park.getArea(), park.getHasCamping());

        //STEP 4: If we have results and need to transfer them to objects, do that here
        //Already have it as an object

        //STEP 5: Return the result if necessary
        return getPark(newId);
    }

    @Override
    public void updatePark(Park park) {

        //STEP 1: Declare the variable you want to return
        //Not returning, just updating

        //STEP 2: Write out the SQL you want to execute and save it to a string
        String sql = "UPDATE park " +
                     "SET park_name = ?, date_established = ?, area = ?, has_camping = ? " +
                     "WHERE park_id = ?;";

        //STEP 3: Send the SQL to the database and then store the results if necessary
        //          -If we expect multiple rows / columns coming back (spreadsheet) then use jdbcTemplate.queryForRowSet
        //          -If we want only one result, we can use jdbcTemplate.queryForObject
        //          -If we do an update/delete, we use jdbcTemplate.update
        jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(), park.getHasCamping(), park.getParkId());

        //STEP 4: If we have results and need to transfer them to objects, do that here
        //No return, just updating

        //STEP 5: Return the result if necessary
        //No return, just updating
    }

    @Override
    public void deletePark(int parkId) {

        //STEP 1: Declare the variable you want to return
        //Not returning, just deleting

        //STEP 2: Write out the SQL you want to execute and save it to a string
        String sql = "DELETE FROM park WHERE park_id = ?;";

        //STEP 3: Send the SQL to the database and then store the results if necessary
        //          -If we expect multiple rows / columns coming back (spreadsheet) then use jdbcTemplate.queryForRowSet
        //          -If we want only one result, we can use jdbcTemplate.queryForObject
        //          -If we do an update/delete, we use jdbcTemplate.update
        jdbcTemplate.update(sql, parkId);

        //STEP 4: If we have results and need to transfer them to objects, do that here
        //No return, just deleting

        //STEP 5: Return the result if necessary
        //No return, just deleting

    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {



    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {




    }

    private Park mapRowToPark(SqlRowSet rowSet) {

        //Initialize an empty object of what we want to create
        Park park = new Park();

        //Set the variables to fill the object
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));

        //Need to add the .toLocalDate in order to parse the date
        if(rowSet.getDate("date_established") != null) {
            park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        }

        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));

        //Return object
        return park;
    }
}
