package com.compasso.shadowlivelo.service.validation;

import com.compasso.shadowlivelo.advice.exception.DateException;
import com.compasso.shadowlivelo.domain.model.Client;
import lombok.var;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;

@Service
public class AgeValidator {

    public void validate(Client client){
        if(client.getBirthDate().isAfter(LocalDate.now())){
            throw new DateException("You can't be born after today!");
        }
        if(client.getBirthDate().isEqual(LocalDate.now())){
            throw new DateException("You can't be born now!");

        }
        LocalDate birthDate = client.getBirthDate();
        var age = getAgeForBirthDate(birthDate);
        client.setAge(age);
    }
         private int getAgeForBirthDate(LocalDate birthDate) {
        var age =  Period.between(birthDate, LocalDate.now()).getYears();
        return age;
    }

}
