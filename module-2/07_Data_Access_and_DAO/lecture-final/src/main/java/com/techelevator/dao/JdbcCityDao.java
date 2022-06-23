package com.techelevator.dao;

import com.techelevator.model.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCityDao implements CityDao {

    /*
    // STEP 1 - Declare whatever variable you want to return


        // STEP 2 - Write out the SQL we want to execute and save it to a string
        String sql = "";

        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows or columns coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result (one row, one column - literally just one thing), we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update


        // STEP 4 - If we have results and need to transfer them to objects, do that here


        // STEP 5 - Return the result if necessary
     */


    private final JdbcTemplate jdbcTemplate;

    public JdbcCityDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public City getCity(int cityId) {

        // STEP 1 - Declare whatever variable you want to return
        City city = null;

        // STEP 2 - Write out the SQL we want to execute and save it to a string
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE city_id = ?;";

        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows or columns coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result (one row, one column - literally just one thing), we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cityId);

        // STEP 4 - If we have results and need to transfer them to objects, do that here
        if (results.next()) {
            city = mapRowToCity(results);
        }

        // STEP 5 - Return the result if necessary
        return city;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        // Step 1 - Creating data type we want to return
        List<City> cities = new ArrayList<>();

        // Step 2 - Creating sql as a string
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE state_abbreviation = ?;";

        // Step 3 - sending sql to database and storing the results
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        // Step 4 - transferring the data from the row set to our custom objects
        while (results.next()) {
            cities.add(mapRowToCity(results));
        }

        // Step 5 - returning our final objects
        return cities;
    }

    @Override
    public List<City> getCitiesByStateName(String name) {

        // STEP 1 - Declare whatever variable you want to return
        List<City> cities = new ArrayList<City>();

        // STEP 2 - Write out the SQL we want to execute and save it to a string
        String sql = "SELECT city_id, city_name, city.state_abbreviation, city.population, city.area " +
                        "FROM city " +
                        "JOIN state ON city.state_abbreviation = state.state_abbreviation " +
                        "WHERE state_name ILIKE ?;"; // USE ILIKE INSTEAD OF LIKE IN JAVA !!!

        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows or columns coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result (one row, one column - literally just one thing), we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update
        String nameWithWildcards = "%" + name + "%";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, nameWithWildcards);

        // STEP 4 - If we have results and need to transfer them to objects, do that here
        while(results.next()){
            City city = mapRowToCity(results);
            cities.add(city);
        }

        // STEP 5 - Return the result if necessary
        return cities;

    }

    @Override
    public City createCity(City city) {
        // Step 1 - create the data type to return
        // We can normally skip this for creates

        // Step 2 - SQL as a string
        String sql = "INSERT INTO city (city_name, state_abbreviation, population, area) " +
                     "VALUES (?, ?, ?, ?) RETURNING city_id;";


        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result, we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update
        // Any time that we are creating we will either use queryForObject or update. It depends if you want the new id of the row you created
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                city.getCityName(), city.getStateAbbreviation(), city.getPopulation(), city.getArea());

        // Step 4 - Transfer data from rowset to object if necessary

        // Step 5 - return the result
        return getCity(newId);
    }

    @Override
    public void updateCity(City city) {
        // Step 1 - Declare the datatype we want to return

        //Step 2 - Store the sql in a string
        String sql = "UPDATE city " +
                    "SET city_name = ?, state_abbreviation = ?, population = ?, area = ? " +
                    "WHERE city_id = ?;";

        // STEP 3 - Send the SQL to the database and then store the results if necessary
        //         a) If we expect multiple rows coming back (a spreadsheet) then we use jdbcTemplate.queryForRowSet
        //         b) If we want only one result, we can use jdbcTemplate.queryForObject
        //         c) If we are doing an update or delete, we use jdbcTemplate.update
        jdbcTemplate.update(sql, city.getCityName(), city.getStateAbbreviation(), city.getPopulation(),
                city.getArea(), city.getCityId());

        //Step 4 - transfer data unnecessary
        //Step 5 - not returning anything
    }

    @Override
    public void deleteCity(int cityId) {
        String sql = "DELETE FROM city WHERE city_id = ?;";
        jdbcTemplate.update(sql, cityId);
    }

    private City mapRowToCity(SqlRowSet rowSet) {
        City city = new City();

        int id = rowSet.getInt("city_id");
        city.setCityId(id);


        city.setCityName(rowSet.getString("city_name"));

        city.setStateAbbreviation(rowSet.getString("state_abbreviation"));
        city.setPopulation(rowSet.getInt("population"));
        city.setArea(rowSet.getDouble("area"));
        return city;
    }
}
