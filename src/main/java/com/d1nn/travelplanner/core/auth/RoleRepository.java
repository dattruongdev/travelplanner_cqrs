package com.d1nn.travelplanner.core.auth;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoleRepository extends MongoRepository<Role, String> {
  Role findByName(String name);
}
