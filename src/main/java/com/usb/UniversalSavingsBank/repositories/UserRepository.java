package com.usb.UniversalSavingsBank.repositories;

import com.usb.UniversalSavingsBank.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUserId(String id);
    Optional<User> findByEmail(String email);
}
