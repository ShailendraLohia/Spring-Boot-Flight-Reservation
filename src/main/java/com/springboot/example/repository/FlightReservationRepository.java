package com.springboot.example.repository;

import com.springboot.example.model.TripDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightReservationRepository extends CrudRepository<TripDetails,String> {
}
