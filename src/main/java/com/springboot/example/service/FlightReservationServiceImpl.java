package com.springboot.example.service;

import com.springboot.example.model.TripDetails;
import com.springboot.example.repository.FlightReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

@Service
public class FlightReservationServiceImpl {

    @Autowired
    private FlightReservationRepository flightReservationRepository;

    public TripDetails addJourney(TripDetails tripDetails) {

        return flightReservationRepository.save(tripDetails);
    }

    public Optional<TripDetails> getTripData(String emailId) {
        return flightReservationRepository.findById(emailId);
    }

//    private Date dateForamt(Date inputDate) {
//        DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
//        LocalDateTime localDateTime=LocalDateTime.parse(inputDate,dateTimeFormatter);
//
//    }
}
