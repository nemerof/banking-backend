package com.usb.UniversalSavingsBank.repositories;

import com.usb.UniversalSavingsBank.entities.Card;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CardRepository extends MongoRepository<Card, String> {
}
