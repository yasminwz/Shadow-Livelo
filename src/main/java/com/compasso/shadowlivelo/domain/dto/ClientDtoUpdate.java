package com.compasso.shadowlivelo.domain.dto;


import com.compasso.shadowlivelo.domain.model.City;
import lombok.*;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoUpdate {

    private String name;
    private String lastName;
    private char sex;
    private LocalDate birthDate;
    private int age;

    private City city;

}
