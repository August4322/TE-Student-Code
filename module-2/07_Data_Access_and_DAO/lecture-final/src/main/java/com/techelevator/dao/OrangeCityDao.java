package com.techelevator.dao;

import com.techelevator.model.City;

import javax.sql.DataSource;
import java.util.List;

public class OrangeCityDao implements CityDao {

    public OrangeCityDao(DataSource source) {

    }

    @Override
    public City getCity(int cityId) {
        return null;
    }

    @Override
    public List<City> getCitiesByState(String stateAbbreviation) {
        return null;
    }

    @Override
    public List<City> getCitiesByStateName(String name) {
        return null;
    }

    @Override
    public City createCity(City city) {
        return null;
    }

    @Override
    public void updateCity(City city) {

    }

    @Override
    public void deleteCity(int cityId) {

    }
}
