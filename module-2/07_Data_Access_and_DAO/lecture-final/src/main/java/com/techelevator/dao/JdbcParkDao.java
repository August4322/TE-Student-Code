package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;
    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Park getPark(int parkId) {

        // Step 1
        Park park = null;


        //Step 2
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                "FROM park " +
                "WHERE park_id = ? ;";

        //Step 3
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);

        // Step 4
        if(results.next()) {
            park = mapRowToPark(results);
        }

        // Step 5
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {

        // STEP 1 - Declare whatever variable you want to return
        List<Park> parks = new ArrayList<>();

        // STEP 2 - Write out the SQL we want to execute and save it to a string
        String sql = "SELECT park.park_id, park_name, date_established, area, has_camping " +
                     " FROM PARK " +
                     " JOIN PARK_STATE ON PARK.PARK_ID = PARK_STATE.PARK_ID " +
                     " WHERE PARK_STATE.STATE_ABBREVIATION = ?;" ;

        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows or columns coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result (one row, one column - literally just one thing), we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        // STEP 4 - If we have results and need to transfer them to objects, do that here
        while(results.next()){
            parks.add(mapRowToPark(results));
        }

        // STEP 5 - Return the result if necessary
        return parks;
    }

    @Override
    public Park createPark(Park park) {

        // STEP 1 - Declare whatever variable you want to return


        // STEP 2 - Write out the SQL we want to execute and save it to a string
        String sql = "INSERT INTO park( park_name, date_established, area, has_camping) " +
                    " VALUES (?, ?, ?, ? ) RETURNING park_id;";

        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows or columns coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result (one row, one column - literally just one thing), we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class, park.getParkName(), park.getDateEstablished(),
                                                        park.getArea(), park.getHasCamping());

        // STEP 4 - If we have results and need to transfer them to objects, do that here


        // STEP 5 - Return the result if necessary
        return getPark(newId);
    }

    @Override
    public void updatePark(Park park) {

        // STEP 1 - Declare whatever variable you want to return


        // STEP 2 - Write out the SQL we want to execute and save it to a string
        String sql = "UPDATE park " +
                    "SET park_name = ?, date_established = ?, area = ?, has_camping = ? " +
                    "WHERE park_id = ? ;";

        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows or columns coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result (one row, one column - literally just one thing), we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update
        jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea(),
                park.getHasCamping(), park.getParkId());

        // STEP 4 - If we have results and need to transfer them to objects, do that here


        // STEP 5 - Return the result if necessary

    }

    @Override
    public void deletePark(int parkId) {

        // STEP 1 - Declare whatever variable you want to return

        // STEP 2 - Write out the SQL we want to execute and save it to a string
        String sql = "DELETE FROM park_state " +
                " WHERE park_id = ? ;";

        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows or columns coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result (one row, one column - literally just one thing), we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update
        jdbcTemplate.update(sql, parkId);


        // STEP 2 - Write out the SQL we want to execute and save it to a string
        sql = "DELETE FROM park " +
                    " WHERE park_id = ? ;";

        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows or columns coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result (one row, one column - literally just one thing), we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update
        jdbcTemplate.update(sql, parkId);

        // STEP 4 - If we have results and need to transfer them to objects, do that here


        // STEP 5 - Return the result if necessary

    }

    @Override
    public void addParkToState(int parkId, String stateAbbreviation) {
        // STEP 1 - Declare whatever variable you want to return


        // STEP 2 - Write out the SQL we want to execute and save it to a string
        String sql = "INSERT INTO park_state (park_id, state_abbreviation) " +
                     "VALUES(?, ?);";

        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows or columns coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result (one row, one column - literally just one thing), we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update
        jdbcTemplate.update(sql, parkId, stateAbbreviation);

        // STEP 4 - If we have results and need to transfer them to objects, do that here


        // STEP 5 - Return the result if necessary
    }

    @Override
    public void removeParkFromState(int parkId, String stateAbbreviation) {
// STEP 1 - Declare whatever variable you want to return


        // STEP 2 - Write out the SQL we want to execute and save it to a string
        String sql = "DELETE FROM park_state " +
                     " WHERE park_id = ? AND state_abbreviation = ?;";

        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows or columns coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result (one row, one column - literally just one thing), we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update
        jdbcTemplate.update(sql, parkId, stateAbbreviation);

        // STEP 4 - If we have results and need to transfer them to objects, do that here


        // STEP 5 - Return the result if necessary

    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();

        // all the transfers down here
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));


        if(rowSet.getDate("date_established") != null) {
            park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        }

        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));

        return park;
    }
}
