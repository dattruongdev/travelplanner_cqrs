package com.d1nn.travelplanner.core.auth;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class Role {
  @Id
  private String id;
  private String name;
}
