package com.techelevator.hotels.services;

import com.techelevator.hotels.model.City;
import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.PictureOfTheDay;
import com.techelevator.hotels.model.Review;
import org.springframework.web.client.RestTemplate;

public class HotelService {

    private static final String API_BASE_URL = "http://localhost:3000/";
    private final RestTemplate restTemplate = new RestTemplate();

    public Hotel[] listHotels() {

        String url = API_BASE_URL + "hotels";
        Hotel[] results = restTemplate.getForObject(url, Hotel[].class);
        return results;
    }

    public Review[] listReviews() {

        String url = API_BASE_URL + "reviews";
        Review[] results = restTemplate.getForObject(url, Review[].class);
        return results;
    }

    public Hotel getHotelById(int id) {

        String url = API_BASE_URL + "hotels/" + id;
        Hotel hotel = restTemplate.getForObject(url, Hotel.class);
        return hotel;
    }

    public Review[] getReviewsByHotelId(int hotelID) {

        // http://localhost:3000/reviews?hotelID=1
        String url = API_BASE_URL + "reviews?hotelID=" + hotelID;
        Review[] results = restTemplate.getForObject(url, Review[].class);
        return results;
    }

    public Hotel[] getHotelsByStarRating(int stars) {
        // http://localhost:3000/hotels?stars=3
        String url = API_BASE_URL + "hotels?stars=" + stars;
        Hotel[] hotels = restTemplate.getForObject(url, Hotel[].class);

        return hotels;
    }

    public PictureOfTheDay getWithCustomQuery(){
        String url = "https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY";
        PictureOfTheDay potd = restTemplate.getForObject(url, PictureOfTheDay.class);
        return potd;
    }

}
