# Spring-Boot-Flight-Reservation

#Cassandra- UDT
CREATE TYPE journey_details (    
   startDateOfJourney timestamp,  
   returnDateOfJourney timestamp,  
   totalNumberOfPassenger int,
   cityToTravel text,
   flightName text,
   flightNumber text  
);

# Cassandra Table Using UDT
CREATE TABLE trip_details (  
   emailId text,  
   trip_data FROZEN<journey_details>, 
   PRIMARY KEY (emailId)  
); 

