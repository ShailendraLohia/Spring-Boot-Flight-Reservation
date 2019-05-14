package com.springboot.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(value="trip_details")
public class TripDetails {

    @PrimaryKey
    private String emailId;
    private JourneyInfo trip_data;
    /*@Column
    private Date startDateOfJourney;
    @Column
    private Date returnDateOfJourney;
    @Column
    private int totalNumberOfPassenger;
    @Column
    private String cityToTravel;
    @Column
    private String flightName;
    @Column
    private String flightNumber;*/

}
