package com.d1nn.travelplanner.core.booking.domain.repositories;

import com.d1nn.travelplanner.core.booking.domain.Flight;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FlightRepository extends MongoRepository<Flight, String> {
    Flight findByAirline(String airline);
    Flight findByDepartureAirport(String departureAirport);
    Flight findByDestinationAirport(String destinationAirport);
    Flight findByDepartureDateTime(String departureDateTime);
    Flight findByArrivalDateTime(String arrivalDateTime);
    Flight findByPrice(double price);
    Flight findByAvailableSeats(int availableSeats);
}
