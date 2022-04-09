package com.usb.UniversalSavingsBank.repositories;

import com.usb.UniversalSavingsBank.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserDetailsRepo extends MongoRepository<User, String> {
}
