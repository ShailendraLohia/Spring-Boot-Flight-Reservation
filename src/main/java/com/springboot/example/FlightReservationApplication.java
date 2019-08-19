package com.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class FlightReservationApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlightReservationApplication.class,args);
    }
}
