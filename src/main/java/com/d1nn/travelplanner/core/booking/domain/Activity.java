package com.d1nn.travelplanner.core.booking.domain;

import java.util.List;

import com.d1nn.travelplanner.core.auth.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.Data;

@Data
public class Activity {
  @Id
  private String id;
  private String name;
  private String location;
  private String date;
  private String time;
  private double price;
  private int capacity;

  @DocumentReference
  private List<User> users;

  @DocumentReference
  private Booking booking;
}
