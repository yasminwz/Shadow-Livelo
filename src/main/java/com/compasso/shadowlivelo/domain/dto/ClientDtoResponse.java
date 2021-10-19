package com.compasso.shadowlivelo.domain.dto;

import com.compasso.shadowlivelo.domain.model.City;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDtoResponse {

    private Long id;
    private String name;
    private String lastName;
    private LocalDate birthDate;
    private int age;
    private String gender;

    private City city;



}
