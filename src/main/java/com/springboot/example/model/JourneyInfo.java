package com.springboot.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@UserDefinedType(value="journey_details")
public class JourneyInfo {
    private Date startDateOfJourney;
    private Date returnDateOfJourney;
    private int totalNumberOfPassenger;
    private String cityToTravel;
    private String flightName;
    private String flightNumber;
}
