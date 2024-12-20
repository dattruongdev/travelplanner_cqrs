package com.d1nn.travelplanner.core.booking.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Flight {
  @Id
  private String id;
  private String airline;
  private String departureAirport;
  private String destinationAirport;
  private String departureDateTime;
  private String arrivalDateTime;
  private double price;
  private int availableSeats;
}
