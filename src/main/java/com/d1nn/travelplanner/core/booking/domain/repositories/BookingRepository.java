package com.d1nn.travelplanner.core.booking.domain.repositories;

import com.d1nn.travelplanner.core.booking.domain.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByUserId(String userId);
}
