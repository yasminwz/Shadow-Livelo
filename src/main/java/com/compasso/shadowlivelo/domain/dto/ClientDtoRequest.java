package com.compasso.shadowlivelo.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDtoRequest {

    private String name;
    private String lastName;
    private LocalDate birthDate;
    private String gender;

    private CityDtoRequest cityDtoRequest;

}
