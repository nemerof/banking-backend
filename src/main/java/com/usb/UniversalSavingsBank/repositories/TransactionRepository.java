package com.usb.UniversalSavingsBank.repositories;

import com.usb.UniversalSavingsBank.entities.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TransactionRepository extends MongoRepository<Transaction, String> {

    List<Transaction> findAllByCardId(String cardId);
}
