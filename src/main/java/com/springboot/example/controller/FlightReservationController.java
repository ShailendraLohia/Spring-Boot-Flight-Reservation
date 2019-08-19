package com.springboot.example.controller;

import com.springboot.example.model.TripDetails;
import com.springboot.example.service.FlightReservationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FlightReservationController {

    @Autowired
    private FlightReservationServiceImpl flightReservationService;

    @GetMapping("/reservation")
    public String bookReservation() {
        return "Reservation Booked!";
    }

    @PostMapping("/trip/reservation")
    public TripDetails addJourney(@RequestBody TripDetails tripDetails) {
        return flightReservationService.addJourney(tripDetails);
    }

    @GetMapping("/trip/reservation/{emailId}")

    public Optional<TripDetails> retrieveJourneyDetails(@PathVariable String emailId) {
        return flightReservationService.getTripData(emailId);
    }
}
