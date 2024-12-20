package com.d1nn.travelplanner.core.booking.domain;

import java.util.Date;
import java.util.List;

import com.d1nn.travelplanner.core.auth.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;

@Data
public class Booking {
  @Id
  private String id;
  private String userId;
  private Date date;
  private double totalPrice;
  private String status;

  @DocumentReference
  private List<Activity> activities;

  @DocumentReference
  private List<Accomodation> accomodations;

  @DocumentReference
  private Flight flight;

  @DocumentReference
  private User user;
}
