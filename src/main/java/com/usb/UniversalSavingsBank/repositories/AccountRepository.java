package com.usb.UniversalSavingsBank.repositories;

import com.usb.UniversalSavingsBank.entities.AccountNumber;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<AccountNumber, String> {
}
