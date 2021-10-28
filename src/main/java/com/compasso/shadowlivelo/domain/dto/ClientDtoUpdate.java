package com.compasso.shadowlivelo.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoUpdate {

    private String name;
    private String lastName;
    private String gender;
    private LocalDate birthDate;

    private CityDtoRequest cityDtoRequest;

}
