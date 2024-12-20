package com.d1nn.travelplanner.core.auth;

import java.util.List;

import com.d1nn.travelplanner.core.booking.domain.Accomodation;
import com.d1nn.travelplanner.core.booking.domain.Activity;
import com.d1nn.travelplanner.core.booking.domain.Booking;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;

@Data
public class User {
  @Id
  private String id;
  private String username;
  private String password;
  private String email;
  private String firstName;
  private String lastName;
  @DocumentReference
  private List<Role> roles;
  @DocumentReference
  private List<Accomodation> accomodations;
  @DocumentReference
  private List<Booking> bookings;
  @DocumentReference
  private List<Activity> activities;
}
