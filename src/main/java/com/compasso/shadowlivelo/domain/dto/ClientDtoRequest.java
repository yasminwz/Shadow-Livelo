package com.compasso.shadowlivelo.domain.dto;

import com.compasso.shadowlivelo.domain.model.City;
import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoRequest {

    private String name;
    private String lastName;
    private LocalDate birthDate;
    private int age;
    private  char sex;

    private City city;

}
