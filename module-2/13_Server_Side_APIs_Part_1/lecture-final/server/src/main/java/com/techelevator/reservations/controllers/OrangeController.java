package com.techelevator.reservations.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrangeController {

    @RequestMapping(path="/time", method= RequestMethod.GET)
    public String checkTime(){
        return getTheTime();
    }

    private String getTheTime() {
        return "It's Morbin' Time";
    }
}
