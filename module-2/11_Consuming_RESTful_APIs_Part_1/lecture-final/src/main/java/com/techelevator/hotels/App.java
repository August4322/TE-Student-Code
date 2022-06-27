package com.techelevator.hotels;

import com.techelevator.hotels.model.Hotel;
import com.techelevator.hotels.model.PictureOfTheDay;
import com.techelevator.hotels.model.Review;
import com.techelevator.hotels.services.ConsoleService;
import com.techelevator.hotels.services.HotelService;

public class App {

    private final ConsoleService consoleService = new ConsoleService();
    private final HotelService hotelService = new HotelService();

    public static void main(String[] args) {
        App app = new App();
        app.run();
    }

    private void run() {
        int menuSelection = -1;

        while (menuSelection != 0) {
            consoleService.printMainMenu();
            menuSelection = consoleService.promptForMenuSelection();
            if (menuSelection == 1) {
                Hotel[] hotels = hotelService.listHotels();
                for(Hotel hotel : hotels) {
                    System.out.println(hotel.toString());
                }
            } else if (menuSelection == 2) {
                Review[] reviews = hotelService.listReviews();
                for(Review review : reviews) {
                    System.out.println(review);
                }
            } else if (menuSelection == 3) {
                Hotel hotel = hotelService.getHotelById(1);
                System.out.println(hotel);
            } else if (menuSelection == 4) {
                Review[] reviews = hotelService.getReviewsByHotelId(1);
                for(Review review : reviews) {
                    System.out.println(review);
                }
            } else if (menuSelection == 5) {
                Hotel[] hotels = hotelService.getHotelsByStarRating(3);
                for(Hotel hotel : hotels) {
                    System.out.println(hotel);
                }
            } else if (menuSelection == 6) {
               PictureOfTheDay pic = hotelService.getWithCustomQuery();
               System.out.println(pic.getPhotographer());
                System.out.println(pic.getTitle());
                System.out.println(pic.getExplanation());
                System.out.println(pic.getUrl());
            } else if (menuSelection == 0) {
                continue;
            } else {
                System.out.println("Invalid Selection");
            }
            consoleService.pause();
        }
    }

}
