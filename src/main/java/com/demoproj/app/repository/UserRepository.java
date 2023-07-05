package com.demoproj.app.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demoproj.app.model.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    List<User> findByAddressCountry(String country);
}
