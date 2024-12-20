package com.d1nn.travelplanner.core.booking.domain.repositories;

import com.d1nn.travelplanner.core.booking.domain.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ActivityRepository extends MongoRepository<Activity, String> {
    List<Activity> findByName(String name);
    List<Activity> findByLocation(String location);
}
