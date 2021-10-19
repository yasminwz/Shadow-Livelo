package com.compasso.shadowlivelo.domain.dto;

import com.compasso.shadowlivelo.domain.model.City;
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

    private City city;

}
