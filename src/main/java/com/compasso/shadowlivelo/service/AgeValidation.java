package com.compasso.shadowlivelo.service;

import com.compasso.shadowlivelo.advice.exception.AgeException;
import com.compasso.shadowlivelo.domain.model.Client;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeValidation {

    public void validate(Client client) {
        LocalDate today = LocalDate.now();
        LocalDate birthDate = client.getBirthDate();
        int age = Period.between(birthDate, today).getYears();
        if(age != client.getAge()){
            throw new AgeException("Your age does not equal subtracting the current year from your date of birth, check your information");

        }

    }
}
