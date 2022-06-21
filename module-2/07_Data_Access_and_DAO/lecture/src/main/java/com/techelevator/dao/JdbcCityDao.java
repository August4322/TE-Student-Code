package com.techelevator.dao;

import com.techelevator.model.City;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCityDao implements CityDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcCityDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public City getCity(int cityId) {

        //STEP 1: Declare the variable you want to return
        City city = null;

        //STEP 2: Write out the SQL you want to execute and save it to a string
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE city_id = ?;";

        //STEP 3: Send the SQL to the database and then store the results if necessary
        //          -If we expect multiple rows / columns coming back (spreadsheet) then use jdbcTemplate.queryForRowSet
        //          -If we want only one result, we can use jdbcTemplate.queryForObject
        //          -If we do an update/delete, we use jdbcTemplate.update
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, cityId);

        //STEP 4: If we have results and need to transfer them to objects, do that here
        if (results.next()) {
            city = mapRowToCity(results);
        }

        //STEP 5: Return the result if necessary
        return city;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {

        //STEP 1: Declare the variable you want to return
        List<City> cities = new ArrayList<>();

        //STEP 2: Write out the SQL you want to execute and save it to a string
        String sql = "SELECT city_id, city_name, state_abbreviation, population, area " +
                     "FROM city " +
                     "WHERE state_abbreviation = ?;";

        //STEP 3: Send the SQL to the database and then store the results if necessary
        //          -If we expect multiple rows / columns coming back (spreadsheet) then use jdbcTemplate.queryForRowSet
        //          -If we want only one result, we can use jdbcTemplate.queryForObject
        //          -If we do an update/delete, we use jdbcTemplate.update
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);

        //STEP 4: If we have results and need to transfer them to objects, do that here
        while (results.next()) {
            cities.add(mapRowToCity(results));
        }

        //STEP 5: Return the result if necessary
        return cities;
    }

    @Override
    public City createCity(City city) {

        //STEP 1: Declare the variable you want to return
        //We can normally skip step 1 for creates
        //If you don't do step 1 you probably won't do step 4

        //STEP 2: Write out the SQL you want to execute and save it to a string
        String sql = "INSERT INTO city (city_name, state_abbreviation, population, area) " +
                     "VALUES (?, ?, ?, ?) RETURNING city_id;";

        //STEP 3: Send the SQL to the database and then store the results if necessary
        //          -If we expect multiple rows / columns coming back (spreadsheet) then use jdbcTemplate.queryForRowSet
        //          -If we want only one result, we can use jdbcTemplate.queryForObject
        //          -If we do an update/delete, we use jdbcTemplate.update
        //Any time we are creating we will either use queryForObject or update.
        //It depends on if you want the new id of the row you created.
        Integer newId = jdbcTemplate.queryForObject(sql, Integer.class,
                city.getCityName(), city.getStateAbbreviation(), city.getPopulation(), city.getArea());

        //STEP 4: If we have results and need to transfer them to objects, do that here
        //Already have it as an object

        //STEP 5: Return the result if necessary
        return getCity(newId);
    }

    @Override
    public void updateCity(City city) {

        //STEP 1: Declare the variable you want to return
        //Not returning, just updating

        //STEP 2: Write out the SQL you want to execute and save it to a string
        String sql = "UPDATE city " +
                    "SET city_name = ?, state_abbreviation = ?, population = ?, area = ? " +
                    "WHERE city_id = ?;";
        //STEP 3: Send the SQL to the database and then store the results if necessary
        //          -If we expect multiple rows / columns coming back (spreadsheet) then use jdbcTemplate.queryForRowSet
        //          -If we want only one result, we can use jdbcTemplate.queryForObject
        //          -If we do an update/delete, we use jdbcTemplate.update
        jdbcTemplate.update(sql, city.getCityName(), city.getStateAbbreviation(), city.getPopulation(),
                city.getArea(), city.getCityId());

        //STEP 4: If we have results and need to transfer them to objects, do that here
        //No return, just updating

        //STEP 5: Return the result if necessary
        //No return, just updating
    }

    @Override
    public void deleteCity(int cityId) {

        //STEP 1: Declare the variable you want to return
        //Not returning, just deleting

        //STEP 2: Write out the SQL you want to execute and save it to a string
        String sql = "DELETE FROM city WHERE city_id = ?;";

        //STEP 3: Send the SQL to the database and then store the results if necessary
        //          -If we expect multiple rows / columns coming back (spreadsheet) then use jdbcTemplate.queryForRowSet
        //          -If we want only one result, we can use jdbcTemplate.queryForObject
        //          -If we do an update/delete, we use jdbcTemplate.update
        jdbcTemplate.update(sql, cityId);

        //STEP 4: If we have results and need to transfer them to objects, do that here
        //No return, just deleting

        //STEP 5: Return the result if necessary
        //No return, just deleting
    }

    private City mapRowToCity(SqlRowSet rowSet) {

        //Initialize an empty object of what we want to create
        City city = new City();

        //Set the variables to fill the object
        city.setCityId(rowSet.getInt("city_id"));
        city.setCityName(rowSet.getString("city_name"));
        city.setStateAbbreviation(rowSet.getString("state_abbreviation"));
        city.setPopulation(rowSet.getInt("population"));
        city.setArea(rowSet.getDouble("area"));

        //Return object
        return city;
    }
}
