package com.usb.UniversalSavingsBank.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
public class User implements Serializable {

    private String firstName;
    private String surname;
    private String email;
    private String address;
    private LocalDate birthDate;
    private int age;

    private String login;
    private String password;

    private String authProof; // todo email 2-step verification

    private String accountNumber;
    private String userId;

    public User(String firstName, String surname, String email, String address, LocalDate birthDate, String login, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.birthDate = birthDate;
        this.login = login;
        this.password = password;

        this.age = (int) ChronoUnit.YEARS.between(LocalDate.now(), birthDate);
        this.userId = UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
        return "User {" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", accountNumber=" + accountNumber +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return accountNumber.equals(user.accountNumber) && userId.equals(user.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, userId);
    }
}
