package com.d1nn.travelplanner.core.booking.domain.repositories;

import com.d1nn.travelplanner.core.booking.domain.Accomodation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AccomodationRepository extends MongoRepository<Accomodation, String> {
    List<Accomodation> findByName(String name);
    List<Accomodation> findByLocation(String location);
}
